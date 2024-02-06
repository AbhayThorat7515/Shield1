package com.AgileSof.Shield.services.impl;


import com.AgileSof.Shield.constant.MissionStatus;
import com.AgileSof.Shield.dao.AvengerMissionRepository;
import com.AgileSof.Shield.dao.AvengerRepository;
import com.AgileSof.Shield.dao.MissionRepository;
import com.AgileSof.Shield.dto.AvengerDto;
import com.AgileSof.Shield.entities.Avenger;
import com.AgileSof.Shield.entities.AvengerMission;
import com.AgileSof.Shield.exception.ShieldException;
import com.AgileSof.Shield.services.AvengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AvengerServiceImpl implements AvengerService {

    @Autowired
    private AvengerRepository avengerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AvengerMissionRepository avengerMissionRepository;
    @Autowired
    MissionRepository missionRepository;

    @Override
    public AvengerDto addAvenger(AvengerDto avengerDto) {
        try {

            AvengerDto current=new AvengerDto();
    /*        Avenger avenger = new Avenger();
            avenger.setAvengerName(avengerDto.getAvengerName());
            avenger.setAvengerStatus(avengerDto.getAvengerStatus());
            avenger.setAvengerNotification(avengerDto.getAvengerNotification());
            avenger.setEmailId(avengerDto.getEmailId());
            avenger.setPhoneNumber(avengerDto.getPhoneNumber());*/
            Avenger avenger =modelMapper.map(avengerDto, Avenger.class); //it showing error of mapperr cannot convert string to long
            Avenger saveAvenger=avengerRepository.save(avenger);
            AvengerDto currentAvenger=modelMapper.map(saveAvenger, AvengerDto.class);

            return  currentAvenger;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AvengerDto getAvengerDetailsByName(String avengerName) {
        Optional<Avenger> avenger = avengerRepository.findByAvengerName(avengerName);
        if (avenger.isPresent()) {

           AvengerDto current=modelMapper.map(avenger, AvengerDto.class);
            return current;
        } else {
            throw new ShieldException(HttpStatus.BAD_REQUEST, "Enter Valid  Avenger Name ");
        }
    }

    @Override
    public AvengerDto completeMission(Long avenger_id) {
       AvengerDto avengerDto=new AvengerDto();

        Avenger avenger = avengerRepository.findById(avenger_id).orElseThrow(() -> new ShieldException(HttpStatus.NOT_FOUND , "Avenger not found") );
            List<AvengerMission> avengerMissionList=avengerMissionRepository.findByAvenger(avenger);
            if (!avengerMissionList.isEmpty()) {
                if (avenger.getAvengerStatus().equalsIgnoreCase(MissionStatus.COMPLETE.name())) {
                    for (AvengerMission avengerMission : avengerMissionList) {

                       AvengerDto current=modelMapper.map(avenger, AvengerDto.class);
                        return current;
                    }
                }else{
                    throw new ShieldException(HttpStatus.NOT_FOUND,"We Cannot get any Complete Mission of "+avenger_id+"Avenger");
                }
            } else{
                throw new ShieldException(HttpStatus.NOT_FOUND, "You Enter Wrong Avenger id ");
            }
        return null;
    }
}