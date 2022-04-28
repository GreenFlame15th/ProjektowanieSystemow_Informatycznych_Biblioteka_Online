package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Iterator {
    private int step = 1;
    private int count = 0;
    private int startAt = 0;

    public <T> List<T> List(List<T> list)
    {
        ArrayList<T> toReturn = new ArrayList<>();
        int index;
        if(startAt < 0)
            index = 0;
        else
            index =startAt;

        int step = 1;
        if(this.step < 1)
            step = this.step;

        int walked =0;


        while(index < list.size() && (count > walked || count <= 0))
        {
            toReturn.add(list.get(index));
            index += step;
            walked++;
        }
        return toReturn;
    }

    public <T> List<T> Stack(Stack<T> stack)
    {
        ArrayList<T> toReturn = new ArrayList<>();
        for (T object:
                stack) {
            toReturn.add(object);
        }
        Collections.reverse(toReturn);
        return List(toReturn);
    }


    //region getters and setters
    public int getStep() {
        return step;
    }

    public Iterator setStep(int step) {
        this.step = step;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Iterator setCount(int count) {
        this.count = count;
        return this;
    }

    public int getStartAt() {
        return startAt;
    }

    public Iterator setStartAt(int startAt) {
        this.startAt = startAt;
        return this;
    }
    //endregion
}
