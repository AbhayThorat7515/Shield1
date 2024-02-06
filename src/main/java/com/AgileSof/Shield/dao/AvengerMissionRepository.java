package com.AgileSof.Shield.dao;

import com.AgileSof.Shield.entities.Avenger;
import com.AgileSof.Shield.entities.AvengerMission;
import com.AgileSof.Shield.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AvengerMissionRepository extends JpaRepository<AvengerMission, Long> {
    Long countByAvenger(Avenger aven);

    Optional<AvengerMission> findByMissions(Mission mission);

    List<AvengerMission> findByAvenger( Avenger avenger_id);

}
