package com.AgileSof.Shield.services.impl;

import com.AgileSof.Shield.constant.NotificationStatus;
import com.AgileSof.Shield.dao.AvengerMissionRepository;
import com.AgileSof.Shield.dao.AvengerRepository;
import com.AgileSof.Shield.dao.MissionRepository;
import com.AgileSof.Shield.entities.Avenger;
import com.AgileSof.Shield.entities.AvengerMission;
import com.AgileSof.Shield.entities.Mission;
import com.AgileSof.Shield.services.AvengerMissionService;
import com.AgileSof.Shield.exception.ShieldException;
import com.AgileSof.Shield.util.EmailNotification;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;

@Service
public class AvengerMissionServiceImpl implements AvengerMissionService {

    @Autowired
    private AvengerRepository avengerRepository;

    @Autowired
   private MissionRepository missionRepository;

    @Autowired
    private AvengerMissionRepository avengerMissionRepository;

    @Autowired
    private EmailNotification emailNotification;

    @Override
    public void assignMissionToAvenger(Long avenger_id, Long mission_id) throws IOException {

        Mission mission = missionRepository.findById(mission_id).orElseThrow(() -> new ShieldException(HttpStatus.BAD_REQUEST, "You Enter Invalid Mission ID"));
        Avenger avenger = avengerRepository.findById(avenger_id).orElseThrow(() -> new ShieldException(HttpStatus.BAD_REQUEST, "You Enter Invalid Avenger ID"));
        //I get all avenger id and then get count of id's which i send  by using countByAvenger and then if condition apply on it.
        Optional<Avenger> existingAvenger = avengerRepository.findById(avenger_id);
        if (existingAvenger.isPresent()) {
            Long count = avengerMissionRepository.countByAvenger(existingAvenger.get());
            if (count < 2) {
                AvengerMission avengerMission = new AvengerMission();
                avengerMission.setMissions(mission);
                avengerMission.setAvenger(avenger);
                avengerMissionRepository.save(avengerMission);
                // get mission name in existingmissionname
                String existingMissionName = mission.getMissionName();
                if (avenger.getAvengerNotification().equalsIgnoreCase((NotificationStatus.EMAIL.name()))) {
                    Email to = new Email(avenger.getEmailId());
                    emailNotification.sendmail(to, "We are assignee you on new mission" +existingMissionName+ "  Lets go!!", "hii");
                } else if (avenger.getAvengerNotification().equalsIgnoreCase(NotificationStatus.SMS.name())) {
                 //    smsNotification.sendSmS(avenger.getPhoneNumber(), "We are assignee you on mission " + existingMissionName + "be ready!!");
                } else {
                    throw new ShieldException(HttpStatus.NOT_FOUND, "FAIL To Send NOTIFICATION!!");
                }
            }else {
                    throw new ShieldException(HttpStatus.BAD_REQUEST, "We cannot Assign mission to avenger " + avenger_id);
                }
            } else {
                throw new ShieldException(HttpStatus.BAD_REQUEST, "No Avenger found with  id  " + avenger_id);
            }
        }

    //getAllAvengerAssigneMession
    @Override
    public Optional<AvengerMission> getAllAvengerAssigneeMession(Long avenger_id) {
        Optional<AvengerMission> avengerMission=avengerMissionRepository.findById(avenger_id);
        if (avengerMission.isPresent()){
            return avengerMission;
        }else {
            throw new ShieldException(HttpStatus.BAD_REQUEST,"You Enter Wrong Id");
        }
    }

    @Override
    public Optional<AvengerMission> getAvengerCompleteMission(Long avenger_id) {
        Optional<AvengerMission> avengerMission=avengerMissionRepository.findById(avenger_id);
        if(avengerMission.isPresent()){
            System.out.print(avengerMission);
        }else {
            throw new ShieldException(HttpStatus.NOT_FOUND,"You Enter Invalid Id");
        }
        return avengerMission;
    }
}