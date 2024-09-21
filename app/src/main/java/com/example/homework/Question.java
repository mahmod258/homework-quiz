package com.example.homework;

public class Question {
    private String question;
    private String[] answers;
    private int correctIndex;

    public Question(String question, int correctIndex) {
        this.question = question;
        this.answers = new String[]{"Response 1", "Response 2", "Response 3", "Response 4"};
        this.correctIndex = correctIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
}
