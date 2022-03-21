package com.company;

public class Author extends Creator {
    private String sirName;

    public String getSirName() {
        return sirName;
    }

    @Override
    public String toString() {
        return getName() + " " + getSirName();
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }
}
