package com.safetynet.alerts.dto;

import com.safetynet.alerts.model.Person;

import java.util.Collection;
import java.util.List;

public class FloodStation {

    private Collection<PersonFlood> personFloodList;
    private List<Integer> stationNumbers;

    public FloodStation(Person person) {
        this.personFloodList = personFloodList;

        this.stationNumbers = stationNumbers;
    }

    public Collection<PersonFlood> getPersonList() {
        return personFloodList;
    }

    public List<Integer> getStationNumbers() {
        return stationNumbers;
    }
}
