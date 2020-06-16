package org.example.controller;

import org.example.model.Question;

import java.util.ArrayList;
import java.util.List;

public class RuleRepository {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public Iterator<Question> getIterator(){
        return new QuestionIterator<>(questions);
    }
}
