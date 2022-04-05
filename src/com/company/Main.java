package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Main {

    public static void main(String[] args) {
        SingletonDataBaseAccess db = SingletonDataBaseAccess.getInstance();

        Facade facade = new Facade();
        try
        {
            JSONObject jObj = (JSONObject) new JSONParser().parse(new FileReader("./exampleBook.json"));
            LibraryObject lb = facade.JSONObjectToLibraryObject(jObj);
            System.out.println(lb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("\n##########");

        for (LibraryObject l:
             new Iterator().setCount(2).List(db.getStock())) {
            System.out.println(l.toString()+"\n-------------");
        }

        System.out.println("\n##########");

        User u1 = new User(1);
        User u5 = new User(5);

        new PrintDB().Action(u5, null);

        System.out.println("\n##########");

        new PrintDB().Action(u1, null);

        System.out.println("\n##########");

        for (User u:
                new Iterator().List(SingletonUserDataBaseAccess.getInstance().getUsers())) {
            System.out.println(u.getId());
        }

    }
}