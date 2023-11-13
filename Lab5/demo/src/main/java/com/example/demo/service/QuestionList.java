package com.example.demo.service;

import com.example.demo.model.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        // Dummy questions based on topic
        // In a real scenario, this data might be fetched from a database or external service
        questions.add(new Question("Question 1: What is 5 + 5?", new String[]{"5", "cheese", "10", "20"}, "10"));
        // add more questions
        questions.add(new Question("Question 2: Why do I do poorly on every quiz?", 
            new String[]{"Because you suck", "You don't study", "Skill issue fr fr", "Sounds like a you problem"}, "You don't study"));
        questions.add(new Question("Question 3: How do you spell red?", 
        new String[]{"L.S.T.E.R.", "B.I.N.G.U.S", "B.A.B.A.B.O.O.E.Y.", "R.E.D."}, "R.E.D."));
        return questions;
    }
}