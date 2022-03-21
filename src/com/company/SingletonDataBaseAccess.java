package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonDataBaseAccess {
    private static SingletonDataBaseAccess instance;
    private List<LibraryObject> stock;
    private SingletonDataBaseAccess()
    {
        stock = ReadList();
    }

    public static SingletonDataBaseAccess getInstance()
    {
        if (instance == null)
        {
            synchronized (SingletonDataBaseAccess.class)
            {
                if(instance==null)
                {
                    instance = new SingletonDataBaseAccess();
                }
            }
        }
        return instance;
    }
    public synchronized boolean add(LibraryObject libraryObject)
    {
        stock.add(libraryObject);
        RecordList();
        return true;
    }
    public synchronized List<LibraryObject> getStock()
    {
        return new ArrayList<LibraryObject>(stock);
    }
    public synchronized boolean remove(LibraryObject libraryObject)
    {
        stock.remove(libraryObject);
        RecordList();
        return true;
    }
    public synchronized boolean modify(LibraryObject oldObject, LibraryObject newObject)
    {
        if(stock.contains(oldObject))
        {
            stock.set(stock.indexOf(oldObject), newObject);
            RecordList();
            return true;
        }
        else return false;
    }
    private void RecordList()
    {
        try {
            XMLEncoder e = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream("LibraryObject.xml")));
            e.writeObject(stock);
            e.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();} catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<LibraryObject> ReadList()
    {
        ArrayList<LibraryObject> result;
        try {
        XMLDecoder d = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream("LibraryObject.xml")));
        result = (ArrayList<LibraryObject>) d.readObject();
        d.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result = new ArrayList<LibraryObject>();
        }
        return result;
    }
}
