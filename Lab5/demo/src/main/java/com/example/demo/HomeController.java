package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.LoginCredentials;
import com.example.demo.service.PasswordValidator;
import com.example.demo.service.EmailValidator;
import com.example.demo.model.Question;
import com.example.demo.service.QuestionList;

import java.util.List; 

@Controller 
public class HomeController {

  private final EmailValidator emailValidator = new EmailValidator();
  private final PasswordValidator passwordValidator = new PasswordValidator();
  private final QuestionList questionList = new QuestionList();

  @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("loginCredentials", new LoginCredentials());
        model.addAttribute("emailok", true); // Add this line
        model.addAttribute("passwordok", true); // And this line
        return "home";
    }

  @PostMapping("/login")
  public String login(@ModelAttribute LoginCredentials loginCredentials, Model model) {
      boolean emailValid = emailValidator.validEmail(loginCredentials.getEmail());
      boolean passwordStrong = passwordValidator.isStrongPassword(loginCredentials.getPassword());

      if (emailValid && passwordStrong) {
        return "redirect:https://sdm21007-vm.cse.uconn.edu/proxy/8099/questions";  // Redirect if both are valid
      } else {
        // Stay on the same page and display validation messages
        model.addAttribute("emailok", emailValid);
        model.addAttribute("passwordok", passwordStrong);
        model.addAttribute("loginCredentials", loginCredentials);
        return "home";
    }
  }


  @GetMapping("/questions")
  public String questionsPage(Model model) {
    List<Question> questions = questionList.getQuestions();
    model.addAttribute("questions", questions);
    return "questions";
  }


  @GetMapping("/score")
  public String scorePage() {
    return "score";
  }

  



}