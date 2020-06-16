package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input){
        for (int valueIndex = 0; valueIndex < values.size(); valueIndex++){
           Value value = values.get(valueIndex);
           List<String> inputPatterns = value.getInputPattern();
           for (String inputPattern : inputPatterns) {
               boolean isEqual = inputPattern.equals(input);
               if (isEqual){
                   return true;
               }
           }
        }
        return false;
    }

    public void addValue(Value value){
        this.values.add(value);
    }

    public List<Value> getValues() {
        return values;
    }
}
