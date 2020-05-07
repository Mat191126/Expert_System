package org.example;

public class ESProwider {
    private FactParser factParser;
    private RuleParser ruleParser;

    public ESProwider (FactParser factParser, RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void displayFacts() {
        Iterator<Fact> factIterator = factParser.getFactRepository().getIterator();
        while (factIterator.hasNext()) {
            System.out.println(factIterator.next().getDescription());
        }
    }

    public void collectAnswers(){

    }

    public boolean getAnswerByQuestion(String qusetionID){
        return true;
    }

    public String evaluate(){
        return "string";
    }


}
