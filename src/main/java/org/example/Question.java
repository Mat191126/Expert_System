package org.example;

public class Question {
    private Answer answer;

    public Question(String ID, String question, Answer answer){

    }
    public String getID(){
        return "ID";
    }

    public String getQuestion(){
        return "question";
    }

    public Answer getAnswer(){
        return this.answer;
    }

    public boolean getEvaluatedAnswer(String input){
        return true;
    }
}
