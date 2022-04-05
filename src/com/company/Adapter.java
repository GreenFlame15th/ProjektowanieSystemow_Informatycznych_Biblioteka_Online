package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public static List<LibraryObject> JSONObjectToLibraryObjects(JSONArray array)
    {
        List<LibraryObject> toReturn = new ArrayList<>();
        for (Object jsonObject:
                array) {
            toReturn.add(JSONObjectToLibraryObject((JSONObject) jsonObject));
        }
        return toReturn;
    }

    public static LibraryObject JSONObjectToLibraryObject(JSONObject jsonObjects)
    {
        return new LibraryObject(jsonObjects);
    }
}
