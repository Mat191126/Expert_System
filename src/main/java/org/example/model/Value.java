package org.example.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {

    private List<String> inputPattern = new ArrayList<>();
    private boolean selectionType;

    public Value(String pattern, boolean selectionType){
        this.inputPattern.add(pattern);
        this.selectionType = selectionType;
    }

    public Value(List<String> patterns, boolean selectionType){
        this.inputPattern = patterns;
        this.selectionType = selectionType;
    }


    public List<String> getInputPattern(){
        return inputPattern;
    }

    public boolean getSelectionType() {
        return selectionType;
    }
}
