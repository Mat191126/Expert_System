package org.example;

import java.util.List;

public class Singlevalue extends Value{
    @Override
    public List<String> getInputPattern() {
        return null;
    }

    @Override
    public boolean getSelectionType() {
        return false;
    }

    public Singlevalue(String param, boolean selectionType){

    }
}
