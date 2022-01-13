package com.safetynet.alerts.service;


import com.safetynet.alerts.dto.PersonPerAge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonCoverByFireStationServiceTest {


    private  PersonCoverByFireStationService personCoverByFireStationService;
    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
    private FireStationRepositoryMock fireStationRepositoryMock = new FireStationRepositoryMock();
    private MedicalRecordRepositoryMock medicalRecordRepositoryMock = new MedicalRecordRepositoryMock();

    @BeforeEach
    void setUp(){
        PersonService personService = new PersonService(personRepositoryMock);
        FireStationService fireStationService = new FireStationService(fireStationRepositoryMock);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepositoryMock);
        personCoverByFireStationService = new PersonCoverByFireStationService(personService,medicalRecordService,fireStationService);
    }


    @Test
    void personPerAge(){

        PersonPerAge perAge = personCoverByFireStationService.personCoverFireStation(1);
        assertNotNull(perAge);
        assertEquals(2,perAge.getPersonForFireStation().size());
        assertEquals(1,perAge.getMajor());
        assertEquals(1,perAge.getMinor());



    }

    @Test
    void personPerAgeException(){

        int fakeStationNumber = -1;
        assertThrows(NullPointerException.class,()->
                personCoverByFireStationService.personCoverFireStation(fakeStationNumber));
    }


}
