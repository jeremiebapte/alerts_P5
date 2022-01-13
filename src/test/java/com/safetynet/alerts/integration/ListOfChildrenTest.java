package com.safetynet.alerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ListOfChildrenTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetListOfChildren() throws Exception {

        mockMvc.perform(get("/childAlert").param("address", "1509 Culver St"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
