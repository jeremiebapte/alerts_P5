package com.safetynet.alerts.service;


import com.safetynet.alerts.dto.PersonInfo;
import com.safetynet.alerts.dto.PersonInfoList;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonInfoService {

    private final IPersonService personService;
    private final IMedicalRecordService medicalRecordService;

    public PersonInfoService(IPersonService personService, IMedicalRecordService medicalRecordService) {
        this.personService = personService;
        this.medicalRecordService = medicalRecordService;
    }

    public List<PersonInfo> getAllInfo(String firstName, String lastName) {
        Set<Person> allPersons = personService.getByLastName(lastName);
        List<PersonInfo> personInfoList = new ArrayList<>();
        allPersons.forEach(person -> {
            PersonInfo personInfo = new PersonInfo(person);
            MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord(firstName, lastName);

            personInfo.setAge(medicalRecord.getBirthdate());
            personInfo.setAllergies(medicalRecord.getAllergies());
            personInfo.setMedications(medicalRecord.getMedications());

            personInfoList.add(personInfo);
        });


        return personInfoList;



    }
}



