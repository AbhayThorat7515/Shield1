package com.AgileSof.Shield.services;

import com.AgileSof.Shield.dto.AvengerDto;
import com.AgileSof.Shield.entities.Avenger;
import com.AgileSof.Shield.entities.AvengerMission;

import java.util.Optional;

public interface AvengerService {
    AvengerDto  addAvenger(AvengerDto avengerDto);

    public AvengerDto getAvengerDetailsByName(String avenerName);

    AvengerDto completeMission(Long avenger_id);

    /*    Optional<CompletedMissionDto> checkByCompletedMission(Long avenger_id);*/
}