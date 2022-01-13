package com.safetynet.alerts.service;

import com.safetynet.alerts.dto.ChildPerHouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class ListOfChildrenServiceTest {


    private static ListOfChildrenService listOfChildrenService;



    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();
    private MedicalRecordRepositoryMock medicalRecordRepositoryMock = new MedicalRecordRepositoryMock();

    @BeforeEach
    void setUp(){
        PersonService personService = new PersonService(personRepositoryMock);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepositoryMock);
        listOfChildrenService = new ListOfChildrenService(personService,medicalRecordService);

    }

    @Test
    void childAlert(){
        ChildPerHouse childPerHouse = listOfChildrenService.childAlert("947 E. Rose Dr");
        assertNotNull(childPerHouse);
        assertEquals(1,childPerHouse.getChildren().size());
        assertEquals(1,childPerHouse.getOthers().size());


    }



}
