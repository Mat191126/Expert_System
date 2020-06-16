package org.example.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String rockName;
    private String description;
    private Map<String, Boolean> parameterValues = new HashMap<>();
    private Set<String> parameterSet = new HashSet<>();

    public Fact(String rockName, String description){
        this.rockName = rockName;
        this.description = description;
    }

    public Set<String> getParameterSet(){
        return this.parameterSet;
    }

    public void setFactValueByID(String parameterID, boolean value){
        this.parameterValues.put(parameterID, value);
        this.parameterSet.add(parameterID);
    }

    public boolean getValueByID(String parameterID){
        return parameterValues.get(parameterID);
    }

    public String getDescription(){
        return description;
    }
}
