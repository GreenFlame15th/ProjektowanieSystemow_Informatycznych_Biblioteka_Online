package com.company;

public class Author extends Creator {
    private String sirName;

    public Author(String name) {
        super(name);
    }

    public Author() {
    }

    public Author(String name, String sirName) {
        super(name);
        this.sirName = sirName;
    }

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
