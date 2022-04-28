package com.company;

import java.util.List;

public class Facade {
    SingletonDataBaseAccess db = SingletonDataBaseAccess.getInstance();
    
    //region DB
    public boolean add(LibraryObject libraryObject)
    {
        return db.add(libraryObject);
    }
    public List<LibraryObject> getStock()
    {
        return db.getStock();
    }
    public boolean remove(LibraryObject libraryObject)
    {
        return db.remove(libraryObject);
    }
    public boolean modify(LibraryObject oldObject, LibraryObject newObject)
    {
        return db.modify(oldObject, newObject);
    }
    //endregion
}
