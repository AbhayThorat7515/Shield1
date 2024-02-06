package com.AgileSof.Shield.controller;

import com.AgileSof.Shield.dao.MissionRepository;
import com.AgileSof.Shield.dto.MissionDto;
import com.AgileSof.Shield.dto.MissionUpdateDto;
import com.AgileSof.Shield.entities.Mission;
import com.AgileSof.Shield.exception.ResponseDto;
import com.AgileSof.Shield.exception.ShieldException;
import com.AgileSof.Shield.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mission")
public class MissionController {
    @Autowired
    private MissionService missionService;
    @Autowired
    private MissionRepository missionRepository;

    /**
     * +
     * This method add the missions
     *
     * @param missionDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public  ResponseEntity<?>  addMisson(@Valid @RequestBody MissionDto missionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ShieldException(bindingResult, HttpStatus.BAD_REQUEST, "You Enter Empty Values !! PLEASE PROVIDE VALUES :)");
        } else {
            missionService.addMisson(missionDto);
        }
        return ResponseEntity.ok().body(missionDto);
    }

    /**
     * +
     * This method fetch status of all mission
     *
     * @return
     */
    @RequestMapping(value = "/fetch-status", method = RequestMethod.GET)
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(), "Mission Details", missionService.getStatus()));
    }

    /**+
     *
     * @param missionDto
     * @return
     */
    @RequestMapping(value = "/fetch-status-by-missionName/{mission_name}", method = RequestMethod.GET)
    public ResponseEntity<?> getStatusByMissionName(@PathVariable("mission_name") String missionDto) {
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(),"Mission Name is", missionService.getStatusByMissionName(missionDto)));
    }

    /**+
     *
     * @param missionUpdateDto
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    private ResponseEntity<ResponseDto<MissionUpdateDto>> saveOrUpdate(@RequestBody MissionUpdateDto missionUpdateDto) {
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(),"Mission Update Successfully ",missionService.update(missionUpdateDto)));
    }

    /**
     * +
     * This method fetch details of mission by id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/fetch-mission-details-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMissionById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(), "Mission Detail",missionService.getById(id)));
    }

    /**+
     *
     * @param missionDto
     * @return
     */
    @RequestMapping(value = "/fetch-details-by-status/{mission_status}", method = RequestMethod.GET)
    public ResponseEntity<?> getDetailsByStatus(@PathVariable("mission_status") String  missionDto) {
    return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(),"Mission Status", missionService.getDetailsByMissionStatus(missionDto)));
    }
}