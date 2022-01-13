package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@ExtendWith(MockitoExtension.class)
public class PhoneAlertServiceTest {


    private static PhoneAlertService phoneAlertService;

    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
    private FireStationRepositoryMock fireStationRepositoryMock = new FireStationRepositoryMock();


    @BeforeEach
    void setUp(){

       PersonServiceMock personServiceMock = new PersonServiceMock(personRepositoryMock);
       FireStationServiceMock fireStationServiceMock = new FireStationServiceMock(fireStationRepositoryMock);
       phoneAlertService = new PhoneAlertService(fireStationServiceMock,personServiceMock);


    }

    @Test
    void phoneNumbers(){

        List<String> phones = phoneAlertService.phoneNumbers(3);
        assertFalse(phones.isEmpty());
        assertEquals(1,phones.size());

    }
}
