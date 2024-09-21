package com.example.homework;

public class Quiz {
    private Question[] questions = {
            new Question("Question 1", 0),
            new Question("Question 2", 1),
            new Question("Question 3", 2),
            new Question("Question 4", 3)
    };

    public Question[] getQuestions() {
        return questions;
    }
}
