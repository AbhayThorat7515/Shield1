package com.AgileSof.Shield.dao;

import com.AgileSof.Shield.entities.Avenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AvengerRepository extends JpaRepository<Avenger, Long> {

    Optional<Avenger> findByAvengerName(String avengerName);

    Optional<Avenger> findByAvengerNotification(Long avengerId);



    /*    Optional<Avenger> findById(Long avenger_id);*/

}
