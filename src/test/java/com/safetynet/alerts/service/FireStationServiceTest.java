package com.safetynet.alerts.service;


import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FireStationServiceTest {

    private static FireStationService fireStationService;

    @Mock
    private static Set<FireStation> fireStationSet;
    private static List<Integer> stationNumberList;
    private static FireStation newFireStation;

    @BeforeEach
    void setUp() {

        FireStationRepositoryMock fireStationRepositoryMock = new FireStationRepositoryMock();
        fireStationService = new FireStationService(fireStationRepositoryMock);
        fireStationSet = new HashSet<>();
        stationNumberList = new ArrayList<>();
        stationNumberList.add(1);
        stationNumberList.add(2);
        stationNumberList.add(3);
        newFireStation = new FireStation();

    }


    @Test
    public void getStation(){
        FireStation stationGetted = fireStationService.getStation(1);
        assertEquals(1,stationGetted.getStation());
    }


    @Test
    public void getByStationNumbers(){
        List<FireStation> fireStations = fireStationService.getByStationNumbers(stationNumberList);

        assertEquals(3,fireStations.size());

    }

    @Test
    void getAllStations() {
        fireStationSet = fireStationService.getAllStations();

        assertEquals(3,fireStationSet.size());

    }

    @Test
    void getByAdress() {
        FireStation stationGot = fireStationService.getByAdress("1509 Culver St");
        assertEquals("1509 Culver St", stationGot.getAddress());
    }

    @Test
    void saveStation() {
        fireStationSet = fireStationService.getAllStations();
        assertEquals(3,fireStationSet.size());

        fireStationService.saveStation(newFireStation);

        fireStationSet = fireStationService.getAllStations();
        assertEquals(4,fireStationSet.size());
    }

    @Test
    void updateFireStation() {
        FireStation station = fireStationService.getStation(1);
        assertEquals(1,station.getStation());
        station.setAddress("123 Abc ST");


        FireStation stationUpdated = fireStationService.updateFireStation(1,station);
        assertEquals("123 Abc ST",stationUpdated.getAddress());



    }

    @Test
    void deleteStation() {
        fireStationSet = fireStationService.getAllStations();
        assertEquals(3,fireStationSet.size());

        fireStationService.deleteStation(2);
        fireStationSet = fireStationService.getAllStations();
        assertEquals(2,fireStationSet.size());

    }


}