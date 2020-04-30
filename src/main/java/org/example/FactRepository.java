package org.example;

public class FactRepository implements Container{
    public String[] facts = {"A", "B", "C"};

    public void addFact(Fact fact){

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

            if(index < facts.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return facts[index++];
            }
            return null;
        }
    }
}
