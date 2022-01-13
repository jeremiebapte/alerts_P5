package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IFireStationRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FireStationRepositoryMock implements IFireStationRepository {
    private Set<FireStation> fireStations = new HashSet<>();

    public FireStationRepositoryMock() {
     init();
    }


    private void init(){
        FireStation fireStation = new FireStation();
        fireStation.setStation(3);
        fireStation.setAddress("1509 Culver St");

        FireStation fireStation2 = new FireStation();
        fireStation2.setStation(1);
        fireStation2.setAddress("947 E. Rose Dr");

        FireStation fireStation3 = new FireStation();
        fireStation3.setStation(2);
        fireStation3.setAddress("748 Townings Dr");

         fireStations = new HashSet<FireStation>() {{
            add(fireStation);
            add(fireStation2);
            add(fireStation3);
        }

        };
    }

    @Override
    public FireStation get(int station) {
        FireStation fireStation = this.fireStations.stream().filter(fireStation1 ->
                fireStation1.getStation() == station).findFirst().orElse(null);

        return fireStation;
    }

    @Override
    public Set<FireStation> getAll() {

        return fireStations;

    }

    @Override
    public FireStation save(FireStation newFireStation) {
        boolean result = fireStations.add(newFireStation);
        if (!result) {
            return null;
        }
        return newFireStation;
    }

    @Override
    public FireStation update(int station, FireStation update) {

        FireStation fireStation = get( station);
        if (fireStation == null) {
            return null;
        }
        this.fireStations.remove(fireStation);
        this.fireStations.add(update);
        return update;

    }

    @Override
    public void delete(int station) {

        this.fireStations = this.fireStations.stream().filter(fireStation ->
                fireStation.getStation() != station).collect(Collectors.toSet());


    }
}
