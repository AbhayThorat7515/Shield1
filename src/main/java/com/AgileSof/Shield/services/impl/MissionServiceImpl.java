package com.AgileSof.Shield.services.impl;


import com.AgileSof.Shield.dao.MissionRepository;
import com.AgileSof.Shield.dto.MissionDto;
import com.AgileSof.Shield.dto.MissionUpdateDto;
import com.AgileSof.Shield.entities.Mission;
import com.AgileSof.Shield.exception.ShieldException;
import com.AgileSof.Shield.services.MissionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MissionServiceImpl implements MissionService {
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addMisson(MissionDto missionDto) {
      /*  Mission mission = new Mission();
        mission.setMissionName(missionDto.getMissionName());
        mission.setMissionStatus(missionDto.getMissionStatus());*/
        Mission mission=new ModelMapper().map(missionDto,Mission.class);
        Mission saveMission= missionRepository.save(mission);
        MissionDto missionDto1=modelMapper.map(saveMission,MissionDto.class);
    }

    // check status of all mession
    @Override
    public List<MissionDto> getStatus() {
        List<MissionDto> missionDto=  new ArrayList<>();
        List<Mission> list=missionRepository.findAll();
        for (Mission mission:list){
            missionDto.add(modelMapper.map(mission,MissionDto.class));
        }
        return missionDto;
    }

    //get status of mession by mission name
    @Override
    public MissionDto getStatusByMissionName(String mission_name) {
      Optional<Mission> mission = missionRepository.findAllByMissionName(mission_name);
       MissionDto missionDto= new MissionDto();
        if (mission.isPresent()) {
            MissionDto currentDto=modelMapper.map(mission,MissionDto.class);
            return currentDto;
        } else {
            throw new ShieldException(HttpStatus.BAD_REQUEST, "Send valid Mission Name");
        }
    }

    @Override
    public MissionUpdateDto update(MissionUpdateDto missionUpdateDto) {
        Mission mission = new Mission();
        Long i = missionUpdateDto.getId();
        Optional<Mission> currentMission = missionRepository.findById(i);
        if (currentMission.isPresent()) {
            mission.setId(missionUpdateDto.getId());
            mission.setMissionName(missionUpdateDto.getMissionName());
            mission.setMissionStatus(missionUpdateDto.getMissionStatus());
            missionRepository.save(mission);
            return missionUpdateDto;
        }else {
            throw new ShieldException(HttpStatus.NOT_FOUND,"You Enter invalid id");
        }
    }


    //get mission detail by id
    @Override
    public MissionDto getById(Long id) {
        Optional<Mission> mission = missionRepository.findById(id);
        if (mission.isPresent()) {

        MissionDto missionDto=modelMapper.map(mission,MissionDto.class);
            return missionDto;
        } else throw new ShieldException(HttpStatus.BAD_REQUEST, "You send invalid id ");
    }

    // for get data by mission status
    @Override
    public List<MissionDto> getDetailsByMissionStatus(String missionStatus) {
        List<Mission> list = missionRepository.findByMissionStatus(missionStatus);

        if (!list.isEmpty()) {
            List<MissionDto> missionList=new ArrayList<>();
            for(Mission mission:list) {
                missionList.add(modelMapper.map(mission, MissionDto.class));
            }
            return missionList;
            } else {
            throw new ShieldException(HttpStatus.BAD_REQUEST, "Not Found Any " + missionStatus + " Mission");
        }
    }
}