package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import java.util.Arrays;


import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

// import com.example.demo.model.LoginCredentials;
import com.example.demo.service.PasswordValidator;
import com.example.demo.service.EmailValidator;
import com.example.demo.model.Question;
import com.example.demo.service.QuestionList;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@WebMvcTest(HomeController.class)   // <1>
public class HomeControllerTests {

  @Autowired
  private MockMvc mockMvc;   // 

  // Mock the dependencies
  @MockBean
  private EmailValidator emailValidator;

  @MockBean
  private PasswordValidator passwordValidator;

  @MockBean
  private QuestionList questionList;


  @Test
  public void testHomePage() throws Exception {
  mockMvc.perform(get("/"))
      .andExpect(status().isOk()) 
      .andExpect(view().name("home"))
      .andExpect(content().string(       
      containsString("Welcome To The Quiz Page")));
  }
  @Test
    public void testLoginEndpointSuccess() throws Exception {
      given(emailValidator.validEmail("user@example.com")).willReturn(true);
      given(passwordValidator.isStrongPassword("strongpassword123")).willReturn(true);

        mockMvc.perform(post("/login")
                .param("email", "user@example.com")
                .param("password", "strongpassword123"))
                .andExpect(status().isOk()) ;
    }

    @Test
    public void testLoginEndpointFailure() throws Exception {
      given(emailValidator.validEmail("userexample.com")).willReturn(false);
      given(passwordValidator.isStrongPassword("weak")).willReturn(false);

        mockMvc.perform(post("/login")
                .param("email", "userexample.com")
                .param("password", "weak"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("emailok", false))
                .andExpect(model().attribute("passwordok", false));
    }

  
  @Test
  public void testQuestionsPage() throws Exception {
    mockMvc.perform(get("/questions"))   
      .andExpect(status().isOk()) 
      .andExpect(view().name("questions"))
      .andExpect(content().string(       
          containsString("Quiz App")));
  }



}