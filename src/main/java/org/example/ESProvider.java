package org.example;

import org.example.controller.*;
import org.example.model.Question;

public class ESProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    public ESProvider (FactParser factParser, RuleParser ruleParser){
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }

    private void displayFactsDescription() {

    }

    private void collectAnswers(){
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        while (questionIterator.hasNext()){
            System.out.println(questionIterator.next());
        }
    }

    private boolean getAnswerByQuestion(String questionID){
        return true;
    }

    private String evaluate(){
        return "string";
    }

    public void run(){
        collectAnswers();
    }
}
