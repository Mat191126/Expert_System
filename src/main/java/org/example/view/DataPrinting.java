package org.example.view;

import org.example.model.Answer;
import org.example.model.Question;
import org.example.model.Value;

import java.util.List;

public class DataPrinting {
    public void questionPrint(Question question){
        System.out.println(question.getQuestion());
    }

    public void printAnswers(Question question){
        Answer answer = question.getAnswer();
        List<Value> values = answer.getValues();
        System.out.print("[");
        for (int valueIndex = 0; valueIndex < values.size(); valueIndex++){
            Value value = values.get(valueIndex);
            List<String> inputPatterns = value.getInputPattern();
            for (int patternIndex = 0; patternIndex < inputPatterns.size(); patternIndex++){
                if (valueIndex == values.size() - 1){
                    System.out.println(inputPatterns.get(patternIndex) + "]");
                } else {
                    System.out.print(inputPatterns.get(patternIndex) + "/");
                }
            }
        }
    }
}
