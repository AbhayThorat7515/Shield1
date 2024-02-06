package com.AgileSof.Shield.dao;

import com.AgileSof.Shield.dto.MissionUpdateDto;
import com.AgileSof.Shield.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
     List<Mission> findByMissionStatus(String missionStatus);

 //   Optional<Mission> findAllByMission(String missionName);

  //it is for a get by mission name
   // Optional<Mission> findByMissionName(String missionName);


    Optional<Mission> findAllByMissionName(String missionName);

    void save(MissionUpdateDto missionUpdateDto);
/*
    Optional<Mission> findAll(String missionName);*/
}
