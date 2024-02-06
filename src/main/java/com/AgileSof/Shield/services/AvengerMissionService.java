package com.AgileSof.Shield.services;


import com.AgileSof.Shield.entities.AvengerMission;

import java.io.IOException;
import java.util.Optional;

public interface AvengerMissionService {
   void assignMissionToAvenger(Long avenger_id, Long mission_id) throws IOException;

    Optional<AvengerMission> getAllAvengerAssigneeMession(Long avenger_id);

    Optional<AvengerMission> getAvengerCompleteMission(Long avenger_id);
}
