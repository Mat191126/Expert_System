package org.example;

import java.util.ArrayList;
import java.util.List;

public class FactRepository implements Container{
    private List<Fact> facts;

    public void addFact(Fact fact){
        this.facts = new ArrayList<>();
    }

    /*public Iterator<Fact> getIterator(){
        return null;
    }*/

    @Override
    public Iterator getIterator() {
        return new FactIterator();
    }

    private class FactIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {

            if(index < facts.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return facts.get(index++);
            }
            return null;
        }
    }
}
