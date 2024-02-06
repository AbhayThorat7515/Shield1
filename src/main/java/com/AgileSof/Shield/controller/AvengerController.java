package com.AgileSof.Shield.controller;

import com.AgileSof.Shield.dto.AvengerDto;
import com.AgileSof.Shield.exception.ResponseDto;
import com.AgileSof.Shield.exception.ShieldException;
import com.AgileSof.Shield.services.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/avenger")

public class AvengerController {
    @Autowired
    private AvengerService avengerService;

    /**
     * +
     * This method is add avenger.
     *
     * @param avengerDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addAvenger(@Valid @RequestBody AvengerDto avengerDto, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            throw new ShieldException(bindingResult, HttpStatus.BAD_REQUEST, "avengername & avengerStatus  is mandatory");
        }
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(),"Avanger add successfully",avengerService.addAvenger(avengerDto)));
    }

    /**
     *
     * @param avengerDto
     * @return
     */
    @RequestMapping(value = "/fetch-details/{avengerName}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto<AvengerDto>> getAvengerDetailsByName(@PathVariable("avengerName") String avengerDto) {
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(), "Avenger Details",avengerService.getAvengerDetailsByName(avengerDto)));
    }

    /**
     *
     * @param avengerDto
     * @return
     */
    @GetMapping("/complete-mission/{avenger_id}")
    public ResponseEntity<?> completeMission(@PathVariable("avenger_id") Long avengerDto){
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(),"Avenger Details By id",avengerService.completeMission(avengerDto)));
    }
}