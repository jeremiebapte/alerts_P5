package com.safetynet.alerts.service;


import com.safetynet.alerts.dto.ChildForAdress;
import com.safetynet.alerts.dto.ChildPerHouse;
import com.safetynet.alerts.dto.PersonForFireStation;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ListOfChildrenService {
  private final IPersonService personService;
  private final IMedicalRecordService medicalRecordService;

  public ListOfChildrenService(IPersonService personService,
                               IMedicalRecordService medicalRecordService) {

    this.personService = personService;
    this.medicalRecordService = medicalRecordService;

  }

  public ChildPerHouse childAlert(String address) {
    Set<Person> allPersons = personService.getByAdress(address);
    List<ChildForAdress> childForAdressList = allPersons.stream()
            .map(person -> new ChildForAdress(person)).collect(Collectors.toList());

    childForAdressList.forEach(childForAdress -> {
      MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord(
              childForAdress.getFirstName(),
              childForAdress.getLastName());
              childForAdress.setAge(medicalRecord.getBirthdate());
    });

    ChildPerHouse childPerHouse = new ChildPerHouse(childForAdressList);
    return childPerHouse;
  }
}


