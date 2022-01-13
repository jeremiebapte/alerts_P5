package com.safetynet.alerts.service;

import com.safetynet.alerts.dto.PersonForFireStation;
import com.safetynet.alerts.dto.PersonPerAge;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonCoverByFireStationService {
 private final IPersonService personService;
 private final IMedicalRecordService medicalRecordService;
 private final IFireStationService fireStationService;


    public PersonCoverByFireStationService(IPersonService personService,
                                           IMedicalRecordService medicalRecordService,
                                           IFireStationService fireStationService) {
        this.personService = personService;
        this.medicalRecordService = medicalRecordService;
        this.fireStationService = fireStationService;
    }


    public PersonPerAge personCoverFireStation(int stationNumber){
       FireStation fireStation = fireStationService.getStation(stationNumber);
       String adress = fireStation.getAddress();
       Set<Person> allPerson = personService.getByAdress(adress);
       List<PersonForFireStation> personForFireStations = allPerson.stream()
               .map(person -> new PersonForFireStation(person)).collect(Collectors.toList());

       personForFireStations.forEach(personForFireStation -> {
           MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord(
                    personForFireStation.getFirstName(),
                    personForFireStation.getLastName());
                    personForFireStation.setAge(medicalRecord.getBirthdate());
       });

        PersonPerAge personPerAge = new PersonPerAge(personForFireStations);
                                    return personPerAge;

    }

}




