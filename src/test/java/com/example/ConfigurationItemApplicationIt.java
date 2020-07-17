package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConfigurationItemApplicationIt {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllCis() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ci")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getSingleCi() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ci/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidConfigurationItem() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ci/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewConfigurationItem() throws Exception {
        String newCi = "{\"name\":\"S123890VM\",\"description\":\"test vm.\",\"ipAddress\":\"1.1.1.1\",\"macAddress\":\"1.1.1.2\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/ci")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newCi)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}