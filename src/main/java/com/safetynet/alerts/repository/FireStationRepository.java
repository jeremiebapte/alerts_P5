package com.safetynet.alerts.repository;


import com.safetynet.alerts.model.ArrayContainer;
import com.safetynet.alerts.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class FireStationRepository implements IFireStationRepository {

    private final ArrayContainer data;
    private Set<FireStation> fireStations = new HashSet<>();

    public FireStationRepository(ArrayContainer data) {
        this.data = data;
        this.fireStations = this.data.getFirestations();
        System.out.println(this.fireStations);
    }


    public FireStation get(int station) {
        FireStation fireStation = this.fireStations.stream().filter(fireStation1 ->
                fireStation1.getStation() == station).findFirst().orElse(null);

        return fireStation;

    }

    public Set<FireStation> getAll(){
        return this.fireStations;
    }

    public FireStation save(FireStation newFireStation) {
        boolean result = this.fireStations.add(newFireStation);
        if (!result) {
            return null;
        }
        return newFireStation;

    }

    public FireStation update( int station, FireStation update) {
        FireStation fireStation = get( station);
        if (fireStation == null) {
            return null;
        }
        this.fireStations.remove(fireStation);
        this.fireStations.add(update);
        return update;
    }

    public void delete(int station){
        this.fireStations = this.fireStations.stream().filter(fireStation ->
                fireStation.getStation() != station).collect(Collectors.toSet());
    }
}
