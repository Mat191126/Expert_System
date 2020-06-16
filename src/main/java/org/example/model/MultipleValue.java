package org.example.model;

import java.util.List;

public class MultipleValue extends Value{
    @Override
    public List<String> getInputPattern() {
        return null;
    }

    @Override
    public boolean getSelectionType() {
        return false;
    }

    public MultipleValue(List<String> params, boolean selectionType){

    }
}
