package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringbootApiExampleApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void contextLoads() {
  }

  @Test
  public void getAllRides() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/rides")
            .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  @Test
  public void getRide() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
            .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  }

  @Test
  public void returnNotFoundForInvalidRide() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/ride/4")
            .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn();
  }

  @Test
  public void addNewRide() throws Exception {
    String newRide = "{\"name\":\"Monorail\",\"description\":\"Sedate travelling ride.\",\"thrillFactor\":2,\"vomitFactor\":1}";
    mockMvc.perform(MockMvcRequestBuilders.post("/ride")
            .contentType(MediaType.APPLICATION_JSON)
            .content(newRide)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
  }

}
