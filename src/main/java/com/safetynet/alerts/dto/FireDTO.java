package com.safetynet.alerts.dto;

import java.util.List;

public class FireDTO {
    private List<PersonFire> persons;
    private int stationNumber;


    public FireDTO(List<PersonFire> personFire, int stationNumber) {
        this.persons = personFire;
        this.stationNumber = stationNumber;
    }

    public List<PersonFire> getPersons() {
        return persons;
    }

    public int getStationNumber() {
        return stationNumber;
    }
}
