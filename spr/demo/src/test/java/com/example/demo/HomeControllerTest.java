package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)   // <1>
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;   

  @Test
  public void testHomePage() throws Exception {
    mockMvc.perform(get("/"))   
      .andExpect(status().isOk()) 
      .andExpect(view().name("home"))
      .andExpect(content().string(       
          containsString("Welcome To The Login Page")));
  }

  @Test
  public void testQuestionsPage() throws Exception {
    mockMvc.perform(get("/questions"))   
      .andExpect(status().isOk()) 
      .andExpect(view().name("questions"))
      .andExpect(content().string(       
          containsString("Quiz App")));
  }

  @Test
  public void testScorePage() throws Exception {
    mockMvc.perform(get("/score"))   
      .andExpect(status().isOk()) 
      .andExpect(view().name("score"))
      .andExpect(content().string(       
          containsString("Score Page")));
  }




}