package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireStation;

import java.util.List;
import java.util.Set;

public interface IFireStationService {


    FireStation getStation(int station);
    List<FireStation> getByStationNumbers(List<Integer> stationNumber);
    Set<FireStation> getAllStations();
    FireStation getByAdress(String address);
    FireStation saveStation(FireStation newFireStation);
    FireStation updateFireStation( int station, FireStation fireStation);
    void deleteStation(int station);
}
