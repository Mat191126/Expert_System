package org.example.model;

import java.util.Set;

public class Fact {
    private String ID;
    private String description;

    public Fact(String ID, String description){
        this.ID = ID;
        this.description = description;
    }

    public Set<String> getIDSet(){
        return null;
    }

    public void setFactValueByID(String ID, boolean value){

    }

    public boolean getValueByID(String ID){
        return true;
    }

    public String getDescription(){
        return description;
    }
}
