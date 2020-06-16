package org.example;

import org.example.controller.FactParser;
import org.example.controller.Iterator;
import org.example.controller.RuleParser;
import org.example.model.Fact;

public class ESProwider {
    private FactParser factParser;
    private RuleParser ruleParser;

    public ESProwider (FactParser factParser, RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void displayFactsDescription() {
        Iterator<Fact> factIterator = factParser.getFactRepository().getIterator();
        while (factIterator.hasNext()) {
            System.out.println(factIterator.next().getDescription());
        }
    }

    public void collectAnswers(){

    }

    public boolean getAnswerByQuestion(String questionID){
        return true;
    }

    public String evaluate(){
        return "string";
    }

    public void run(){

    }
}
