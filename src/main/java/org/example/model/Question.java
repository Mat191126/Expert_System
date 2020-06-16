package org.example.model;

public class Question {
    private String ID;
    private String question;
    private Answer answer;

    public Question(String ID, String question, Answer answer){
        this.ID = ID;
        this.question = question;
        this.answer = answer;
    }
    public String getID(){
        return this.ID;
    }

    public String getQuestion(){
        return this.question;
    }

    public Answer getAnswer(){
        return this.answer;
    }

    public boolean getEvaluatedAnswer(String input){
        return true;
    }
}
