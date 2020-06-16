package org.example;

import org.example.controller.*;
import org.example.model.Fact;
import org.example.model.Question;
import org.example.view.DataPrinting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ESProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, String> userAnswers = new HashMap<>();
    private List<Fact> matchingFacts = new ArrayList<>();
    private DataPrinting dataPrinting = new DataPrinting();
    private InputProvider inputProvider = new InputProvider();

    public ESProvider (FactParser factParser, RuleParser ruleParser){
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }


    private void collectAnswers() throws IOException {
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        while (questionIterator.hasNext()){
            Question question = questionIterator.next();

            boolean isValidAnswer = false;
            while (!isValidAnswer) {
                dataPrinting.questionPrint(question);
                dataPrinting.printAnswers(question);
                String userAnswer = inputProvider.takeStringInput("Enter answer: ");
                isValidAnswer = question.getEvaluatedAnswer(userAnswer);
                if (isValidAnswer){
                    this.userAnswers.put(question.getID(), userAnswer);
                }
            }
        }
    }

    private boolean getAnswerByQuestion(String questionID){
        return true;
    }

    private String evaluate(){
        Iterator<Fact> factIterator = factRepository.getIterator();
        while (factIterator.hasNext()){
            Fact fact = factIterator.next();
            for (String parameterId : fact.getParameterSet()){
                boolean isUserAnswerMatches = parameterId.equals(userAnswers.get(parameterId));
                if (fact.getValueByID(parameterId) != isUserAnswerMatches){
                    break;
                }
                return fact.getRockName() + ": " + fact.getDescription();
            }
        }
        return null;
    }

    public void run() throws IOException {
        collectAnswers();
        String factDescription = evaluate();
        System.out.println(factDescription);
    }
}
