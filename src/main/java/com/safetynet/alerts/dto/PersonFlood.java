package com.safetynet.alerts.dto;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

public class PersonFlood {

    private String firstName;
    private String lastname;
    private int age;
    private String phone;
    private Set<String> medications;
    private Set <String> allergies;



    public PersonFlood(Person person) {
        this.firstName = person.getFirstName();
        this.lastname = person.getLastName();
        this.phone = person.getPhone();
    }


    public String getLastname() {
        return lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public Set<String> getMedications() {
        return medications;
    }

    public Set<String> getAllergies() {
        return allergies;
    }

    public void setMedications(Set<String> medications) {
        this.medications = medications;
    }

    public void setAllergies(Set<String> allergies) {
        this.allergies = allergies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(LocalDate birthDate) {
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
    }

}
