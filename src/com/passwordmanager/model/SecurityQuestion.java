package com.passwordmanager.model;

public class SecurityQuestion {

    private int id;
    private int userId;
    private String question;
    private String answer;

    // No-arg constructor
    public SecurityQuestion() {
    }

    // Getter & Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter & Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter & Setter for question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter & Setter for answer
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
