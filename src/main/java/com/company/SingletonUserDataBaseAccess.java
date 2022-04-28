package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonUserDataBaseAccess {
    private static SingletonUserDataBaseAccess instance;
    private List<User> users;
    private SingletonUserDataBaseAccess()
    {
        users = ReadList();
    }

    public static SingletonUserDataBaseAccess getInstance()
    {
        if (instance == null)
        {
            synchronized (SingletonUserDataBaseAccess.class)
            {
                if(instance==null)
                {
                    instance = new SingletonUserDataBaseAccess();
                }

            }
        }
        return instance;
    }
    public synchronized boolean add(User user)
    {
        users.add(user);
        RecordList();
        return true;
    }
    public synchronized List<User> getUsers()
    {
        return new ArrayList<User>(users);
    }
    public synchronized boolean remove(User user)
    {
        users.remove(user);
        RecordList();
        return true;
    }
    public synchronized boolean modify(User oldObject, User newObject)
    {
        if(users.contains(oldObject))
        {
            users.set(users.indexOf(oldObject), newObject);
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
                            new FileOutputStream("Users.xml")));
            e.writeObject(users);
            e.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();} catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<User> ReadList()
    {
        ArrayList<User> result;
        try {
        XMLDecoder d = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream("Users.xml")));
        result = (ArrayList<User>) d.readObject();
        d.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result = new ArrayList<User>();
        }
        return result;
    }
}
