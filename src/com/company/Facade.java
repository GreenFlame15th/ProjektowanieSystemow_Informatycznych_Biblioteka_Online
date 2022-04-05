package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class Facade {
    SingletonDataBaseAccess db = SingletonDataBaseAccess.getInstance();

    //region Adapter
    public static List<LibraryObject> JSONObjectToLibraryObjects(JSONArray array)
    {
        return  Adapter.JSONObjectToLibraryObjects(array);
    }

    public static LibraryObject JSONObjectToLibraryObject(JSONObject jsonObjects)
    {
        return Adapter.JSONObjectToLibraryObject(jsonObjects);
    }
    //endregion
    //region DB
    public boolean add(LibraryObject libraryObject)
    {
        return db.add(libraryObject);
    }
    public synchronized List<LibraryObject> getStock()
    {
        return db.getStock();
    }
    public synchronized boolean remove(LibraryObject libraryObject)
    {
        return db.remove(libraryObject);
    }
    public synchronized boolean modify(LibraryObject oldObject, LibraryObject newObject)
    {
        return db.modify(oldObject, newObject);
    }
    //endregion
}
