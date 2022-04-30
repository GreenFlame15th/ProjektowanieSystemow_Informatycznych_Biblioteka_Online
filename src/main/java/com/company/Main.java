package com.company;

public abstract class Main {

    public static void main(String[] args) {

        DBInterface db = DBInterface.getInstance();
        db.connect();
        DBAdapter.printDB(db);
        db.close();
    }
}