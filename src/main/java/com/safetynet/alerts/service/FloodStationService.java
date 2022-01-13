package com.safetynet.alerts.service;


import com.safetynet.alerts.dto.PersonFlood;
import com.safetynet.alerts.dto.FloodStation;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FloodStationService {

    private final IPersonService personService;
    private final IFireStationService fireStationService;
    private final IMedicalRecordService medicalRecordService;

    public FloodStationService(IPersonService personService,
                               IFireStationService fireStationService,
                               IMedicalRecordService medicalRecordService) {
        this.personService = personService;
        this.fireStationService = fireStationService;
        this.medicalRecordService = medicalRecordService;
    }


    public Map<String, List<PersonFlood>> floodStation (List<Integer> stations){
         List<FireStation> allFireStations = fireStationService.getByStationNumbers(stations);
         Set<String> allAdresses = allFireStations.stream().map(fireStation ->
                fireStation.getAddress()).collect(Collectors.toSet());
         Map<String, List<PersonFlood>> listMap = new HashMap<>();

         for (String address : allAdresses){
             Set<Person> personSet = personService.getByAdress(address);
             List<PersonFlood> personFloodList = personSet.stream().map(person ->
                     new PersonFlood(person)).collect(Collectors.toList());

             personFloodList.forEach(personFlood -> {
                 MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord(
                         personFlood.getFirstName(), personFlood.getLastname());
                 personFlood.setAge(medicalRecord.getBirthdate());
                 personFlood.setAllergies(medicalRecord.getAllergies());
                 personFlood.setMedications(medicalRecord.getMedications());
             });
             listMap.put(address,personFloodList);
         }

                return listMap;
    }

}
