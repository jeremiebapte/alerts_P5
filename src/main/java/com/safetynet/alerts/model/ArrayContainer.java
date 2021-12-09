package com.safetynet.alerts.model;

import java.util.List;
import java.util.Map;

public class ArrayContainer {
    private List<Map>persons;
    private List<Map>firestations;
    private List<Map>medicalrecords;

    public List<Map> getPersons() {
        return persons;
    }

    public void setPersons(List<Map> persons) {
        this.persons = persons;
    }

    public List<Map> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<Map> firestations) {
        this.firestations = firestations;
    }

    public List<Map> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<Map> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    @Override
    public String toString() {
        return "ArrayContainer{" +
                "persons=" + persons +
                ", firestations=" + firestations +
                ", medicalrecords=" + medicalrecords +
                '}';
    }
}
