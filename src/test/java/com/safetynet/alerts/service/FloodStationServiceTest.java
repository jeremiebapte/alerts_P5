package com.safetynet.alerts.service;

import com.safetynet.alerts.dto.FloodStation;
import com.safetynet.alerts.dto.PersonFlood;
import com.safetynet.alerts.model.FireStation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FloodStationServiceTest {

    private  FloodStationService floodStationService;
    private  PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
    private  FireStationRepositoryMock fireStationRepositoryMock = new FireStationRepositoryMock();
    private  MedicalRecordRepositoryMock medicalRecordRepositoryMock = new MedicalRecordRepositoryMock();
    private  List<Integer> stations ;
    FireStationService fireStationService = new FireStationService(fireStationRepositoryMock);


    @BeforeEach
     void setUp() {
        PersonService personService  = new PersonService(personRepositoryMock);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepositoryMock);
        floodStationService = new FloodStationService(personService,fireStationService,medicalRecordService);
        stations = new ArrayList<>();
        stations.add(1);
        stations.add(2);
    }

    @Test

    void floodStation(){
        Map<String, List<PersonFlood>> floodStation = floodStationService.floodStation(stations);
        List<FireStation> fireStationList = fireStationService.getByStationNumbers(stations);


        assertEquals(2,floodStation.size());
        assertTrue(floodStation.containsKey(fireStationList.get(0).getAddress()));
        assertTrue(floodStation.containsKey(fireStationList.get(1).getAddress()));
        assertFalse(floodStation.get(fireStationList.get(0).getAddress()).isEmpty());




    }



}
