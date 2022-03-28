package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Adapter {
    public LibraryObject JSONObjectToLibraryObject(JSONObject jsonObject)
    {
        return new LibraryObject(jsonObject);
    }

    public List<LibraryObject> JSONObjectToLibraryObject(List<JSONObject> jsonObjects)
    {
        List<LibraryObject> toReturn = new ArrayList<>();
        for (JSONObject jsonObject:
                jsonObjects) {
            toReturn.add(JSONObjectToLibraryObject(jsonObject));
        }
        return toReturn;
    }
}
