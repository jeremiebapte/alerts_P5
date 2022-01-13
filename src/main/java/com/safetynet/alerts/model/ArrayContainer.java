package com.safetynet.alerts.model;

import java.util.Map;
import java.util.Set;

public class ArrayContainer {
    private Set<Person> persons;
    private Set<FireStation>firestations;
    private Set<MedicalRecord> medicalrecords;

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Set<FireStation> getFirestations() {
        return firestations;
    }

    public void setFirestations(Set<FireStation> firestations) {
        this.firestations = firestations;
    }

    public Set<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(Set<MedicalRecord> medicalrecords) {
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
