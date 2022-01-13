package com.safetynet.alerts.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.param;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMedicalRecord() throws Exception {

        mockMvc.perform(get("/medicalrecords"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetOneMedicalRecord()throws Exception{
        mockMvc.perform(get("/medicalrecords")
                .param("firstname","Tony")
                .param("lastname", "Cooper"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testPostMedicalRecord()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/medicalrecords")
                .content(asJsonString(new MedicalRecord()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPutMedicalRecord(){

    }

    @Test
    public void testDeleteMedicalRecord() throws Exception {
        mockMvc.perform(delete("/medicalrecords/{firstName}/{lastName}")
                .param("firstName","Reginold")
                .param("lastName","Walker"))
                .andExpect(status().isOk());


    }
}
