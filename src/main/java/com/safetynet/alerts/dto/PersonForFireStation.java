package com.safetynet.alerts.dto;


import com.safetynet.alerts.model.Person;


import java.time.LocalDate;
import java.time.Period;


public class PersonForFireStation {
private String firstName;
private String lastName;
private String adress;
private String phone;
private int age;


 public PersonForFireStation (Person person) {
     this.firstName = person.getFirstName();
     this.lastName = person.getLastName();
     this.adress = person.getAddress();
     this.phone = person.getPhone();

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

    public String getAdress(String address) {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
