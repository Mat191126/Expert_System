package org.example.controller;

import org.example.model.Fact;

import java.util.ArrayList;
import java.util.List;

public class FactRepository {
    private List<Fact> facts = new ArrayList<>();

    public void addFact(Fact fact){
        this.facts.add(fact);
    }

    public Iterator<Fact> getIterator(){
        return new FactIterator<>(facts);
    }
}
