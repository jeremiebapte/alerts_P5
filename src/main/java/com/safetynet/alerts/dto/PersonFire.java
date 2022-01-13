package com.safetynet.alerts.dto;

import com.safetynet.alerts.model.Person;

import java.util.Set;

public class PersonFire {
    private String firstName;
    private String lastName;
    private Set<String> medication;
    private Set<String> allergies;
    private String phone;


    public PersonFire (Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.phone = person.getPhone();

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Set<String> getMedication() {
        return medication;
    }

    public void setMedication(Set<String> medication) {
         this.medication = medication;
    }

    public Set<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<String> allergies) {
        this.allergies = allergies;
    }
}
