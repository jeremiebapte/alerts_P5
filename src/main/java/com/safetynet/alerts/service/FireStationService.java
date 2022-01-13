package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.FireStationRepository;
import com.safetynet.alerts.repository.IFireStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FireStationService implements IFireStationService {
    private final IFireStationRepository fireStationRepository;

    public FireStationService(IFireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }


    public FireStation getStation(int station){
       FireStation fireStation = fireStationRepository.get(station);
       if (fireStation == null){
           throw new NullPointerException("Cette Station n'existe pas");
       }
        return fireStation;
    }

    public List <FireStation> getByStationNumbers(List<Integer> stationNumber){
        Set<FireStation> allByNumber = fireStationRepository.getAll();
         return allByNumber.stream().filter(fireStation ->
                 stationNumber.contains(fireStation.getStation()))
                 .collect(Collectors.toList());
    }

    public Set<FireStation> getAllStations(){
        return this.fireStationRepository.getAll();
    }

    public FireStation getByAdress(String address){
        Set<FireStation> allFireStation = fireStationRepository.getAll();
        return allFireStation.stream().filter(fireStation ->
                fireStation.getAddress().toLowerCase()
                .equals(address.toLowerCase())).findFirst().orElse(null);

    }

    public FireStation saveStation(FireStation newFireStation){
        FireStation fireStation = fireStationRepository.save(newFireStation);
        if(fireStation == null){
            throw new IllegalArgumentException("Cette station existe deja");
        }
        return fireStation;
    }

    public FireStation updateFireStation( int station, FireStation fireStation){
        FireStation fireStation1 = fireStationRepository.update( station, fireStation);
        if (fireStation1 == null){
            throw new NullPointerException("La station n'existe pas");
        }
        return fireStation1;
    }

    public void deleteStation(int station){
        fireStationRepository.delete(station);
    }

}
