package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.IFireStationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FireStationServiceMock implements IFireStationService {

    private final IFireStationRepository fireStationRepository;

    public FireStationServiceMock(IFireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    @Override
    public FireStation getStation(int station) {
        FireStation fireStation = fireStationRepository.get(station);
        if (fireStation == null){
            throw new NullPointerException("Cette Station n'existe pas");
        }
        return fireStation;
    }

    @Override
    public List<FireStation> getByStationNumbers(List<Integer> stationNumber) {
        Set<FireStation> allByNumber = fireStationRepository.getAll();
        return allByNumber.stream().filter(fireStation ->
                stationNumber.contains(fireStation.getStation()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<FireStation> getAllStations() {
        return this.fireStationRepository.getAll();
    }

    @Override
    public FireStation getByAdress(String address) {
        Set<FireStation> allFireStation = fireStationRepository.getAll();
        return allFireStation.stream().filter(fireStation ->
                fireStation.getAddress().toLowerCase()
                        .equals(address.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public FireStation saveStation(FireStation newFireStation) {
        FireStation fireStation = fireStationRepository.save(newFireStation);
        if(fireStation == null){
            throw new IllegalArgumentException("Cette station existe deja");
        }
        return fireStation;
    }

    @Override
    public FireStation updateFireStation(int station, FireStation fireStation) {
        FireStation fireStation1 = fireStationRepository.update( station, fireStation);
        if (fireStation1 == null){
            throw new NullPointerException("La station n'existe pas");
        }
        return fireStation1;
    }

    @Override
    public void deleteStation(int station) {
        fireStationRepository.delete(station);
    }
}
