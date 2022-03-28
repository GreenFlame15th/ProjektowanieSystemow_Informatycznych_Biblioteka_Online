package com.company;

public class Creator {
    protected String name;

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Creator(String name) {
        this.name = name;
    }
}
