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

        try
        {
            JSONObject jObj = (JSONObject) new JSONParser().parse(new FileReader("./test.json"));
            LibraryObject lb = new LibraryObject(jObj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}