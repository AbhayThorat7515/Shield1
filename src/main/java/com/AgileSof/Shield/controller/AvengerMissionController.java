package com.AgileSof.Shield.controller;


import com.AgileSof.Shield.entities.AvengerMission;
import com.AgileSof.Shield.exception.ResponseDto;
import com.AgileSof.Shield.services.AvengerMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping(value = "/avengerMission")
public class AvengerMissionController {
    @Autowired
    AvengerMissionService avengerMissionService;

    /**+
     * This method assignee mission to avenger
     * @param avenger_id
     * @param mission_id
     * @return
     */
    @RequestMapping(value = "/assign-mission/{avenger_Id},{mission_id}", method = RequestMethod.POST)
    public ResponseEntity<?> assignMissionToAvenger(@PathVariable("avenger_Id") Long avenger_id, @PathVariable("mission_id") Long mission_id) throws IOException {
        avengerMissionService.assignMissionToAvenger(avenger_id, mission_id);
        return ResponseEntity.ok().body("Successfully Added");
    }

    /**+
     *
     * @param avenger_id
     * @return
     */
    @RequestMapping(value = "/fetch-complete-mission/{avenger_id}", method = RequestMethod.GET)
    public Optional<AvengerMission> getAvengerCompleteMission(@PathVariable Long avenger_id) {
        return avengerMissionService.getAvengerCompleteMission(avenger_id);
    }

    /**
     * +
     * This method fetch avengers mission details by id
     *
     * @param avengerId
     * @return
     */

    @RequestMapping(value = "/fetch-all-avenger-assignee-mission/{avengerId}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto<Optional<AvengerMission>>> getAllAvengerAssignedMission(@PathVariable("avengerId") Long avengerId){
        return ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(), "Avenger details", avengerMissionService.getAllAvengerAssigneeMession(avengerId)));
    }
 }