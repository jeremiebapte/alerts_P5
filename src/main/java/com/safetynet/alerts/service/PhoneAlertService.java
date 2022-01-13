package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PhoneAlertService  {

    private final IFireStationService fireStationService;
    private final IPersonService personService;

    public PhoneAlertService(IFireStationService fireStationService, IPersonService personService) {
        this.fireStationService = fireStationService;
        this.personService = personService;
    }


public List<String> phoneNumbers (int fireStationNumber){
    FireStation fireStation = fireStationService.getStation(fireStationNumber);
    String stationAddress = fireStation.getAddress();
    Set<Person> allPersons = personService.getByAdress(stationAddress);

    List<String> phones = allPersons.stream().map(person -> person.getPhone())
                        .collect(Collectors.toList());
    return phones;

}

}

