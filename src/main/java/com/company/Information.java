package com.company;

import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Information {
    private Map<String, Object> characteristics = new HashMap<String, Object>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Object> e : characteristics.entrySet())
        {
            sb.append(e.getKey() + ": " + e.getValue() + "/n");
        }

        return sb.toString();
    }

    public Information() {
    }
    public Information(Information information) {
        this.characteristics = new HashMap<>(information.getCharacteristics());

    }
    public Information(Document document){
        Set<String> keys = document.keySet();
        for (String s:
                keys) {
            append(s,document.get(s));
        }
    }

    //region getters and setters

    public void append(String key, Object value)
    {
        characteristics.put(key, value);
    }

    public Map<String, Object> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, Object> characteristics) {
        this.characteristics = characteristics;
    }

    public Document toDocument()
    {
        Document toReturn = new Document();
        for(Map.Entry<String, Object> e : characteristics.entrySet())
        {
            toReturn.append(e.getKey(), e.getValue());
        }
        return toReturn;
    }


    //endregion
}
