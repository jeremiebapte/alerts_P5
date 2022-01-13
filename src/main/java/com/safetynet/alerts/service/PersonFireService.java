package com.safetynet.alerts.service;

import com.safetynet.alerts.dto.FireDTO;
import com.safetynet.alerts.dto.PersonFire;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonFireService {

    private final IPersonService personService;
    private final IFireStationService fireStationService;
    private final IMedicalRecordService medicalRecordService;

    public PersonFireService(IPersonService personService,
                             IFireStationService fireStationService,
                             IMedicalRecordService medicalRecordService) {

        this.personService = personService;
        this.fireStationService = fireStationService;
        this.medicalRecordService = medicalRecordService;
    }

    public FireDTO fireAdress(String address){
        Set<Person> allPersons = personService.getByAdress(address);
        List<PersonFire> personFireList = allPersons.stream()
                .map(person -> new PersonFire(person)).collect(Collectors.toList());

        FireStation fireStation = fireStationService.getByAdress(address);
        if (fireStation == null){
            throw new IllegalArgumentException("L'adresse de la station n'est pas valable");
        }

        personFireList.forEach(personFire -> {
           MedicalRecord medicalRecord =  medicalRecordService.getMedicalRecord(
                   personFire.getFirstName(), personFire.getLastName());
                    personFire.setMedication(medicalRecord.getMedications());
                    personFire.setAllergies(medicalRecord.getAllergies());


        });
        FireDTO fireDTO = new FireDTO(personFireList, fireStation.getStation());
        return fireDTO;


    }

}
