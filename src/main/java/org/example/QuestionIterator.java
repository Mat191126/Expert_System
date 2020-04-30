package org.example;

public class QuestionIterator implements Container{
    public String[] questions = {"Q1", "Q2", "Q3"};


    @Override
    public Iterator getIterator() {
        return new QuestionsIterator();
    }

    private class QuestionsIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {

            if(index < questions.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return questions[index++];
            }
            return null;
        }
    }
}
