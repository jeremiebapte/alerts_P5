package com.safetynet.alerts.dto;

import com.safetynet.alerts.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChildForAdress {
    private String firstName;
    private String lastName;
    private String adress;
    private List<String> personName = new ArrayList<>();
    private int age;

    public ChildForAdress(Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.adress = person.getAddress();
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
