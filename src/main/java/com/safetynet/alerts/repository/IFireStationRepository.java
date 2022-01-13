package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.FireStation;

import java.util.List;
import java.util.Set;

public interface IFireStationRepository {

    FireStation get(int station);
    Set<FireStation> getAll();
    FireStation save(FireStation newFireStation);
    FireStation update( int station, FireStation update);
    void delete(int station);
}
