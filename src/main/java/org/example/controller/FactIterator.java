package org.example.controller;

import org.example.controller.Iterator;

import java.util.List;

public class FactIterator<E> implements Iterator<E> {
    private int index;
    private List<E> elements;

    public FactIterator(List<E> elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return index < elements.size();
    }

    @Override
    public E next() {
        if(this.hasNext()){
            return elements.get(index++);
        }
        return null;
    }
}