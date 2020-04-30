package org.example;

public class FactIterator implements Container {
    public String[] facts = {"A", "B", "C"};

    @Override
    public Iterator getIterator() {
        return new FactsIterator();
    }

    private class FactsIterator implements Iterator{
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
