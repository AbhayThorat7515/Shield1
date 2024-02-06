package com.AgileSof.Shield.services;

import com.AgileSof.Shield.dto.MissionDto;
import com.AgileSof.Shield.dto.MissionUpdateDto;
import com.AgileSof.Shield.entities.Mission;


import java.util.List;
import java.util.Optional;


public interface MissionService {

    public void addMisson(MissionDto missionDto);

    List<MissionDto> getStatus();


    MissionUpdateDto update(MissionUpdateDto missionUpdateDto);

    List<MissionDto>getDetailsByMissionStatus(String missionDto);

   MissionDto getStatusByMissionName(String mission_name);

    MissionDto getById(Long id);
}