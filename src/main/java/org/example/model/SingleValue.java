package org.example.model;

import java.util.List;

public class SingleValue extends Value{
    @Override
    public List<String> getInputPattern() {
        return null;
    }

    @Override
    public boolean getSelectionType() {
        return false;
    }

    public SingleValue(String param, boolean selectionType){

    }
}
