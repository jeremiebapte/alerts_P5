package com.safetynet.alerts.dto;

import com.safetynet.alerts.model.Person;

import java.time.LocalDate;
import java.time.Period;

import java.util.Set;

public class PersonInfo {
    private String firstName;
    private String lastName;
    private String address;
    private String mail;
    private Set<String> medications;
    private Set <String> allergies;
    private int age;


    public PersonInfo(Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.mail = person.getEmail();


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<String> getMedications() {
        return medications;
    }

    public void setMedications(Set<String> medications) {
        this.medications = medications;
    }

    public Set<String> getAllergies() {
        return allergies;
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
