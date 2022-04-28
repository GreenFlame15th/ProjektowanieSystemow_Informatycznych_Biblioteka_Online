package com.company;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class Main {

    public static void main(String[] args) {

        com.mongodb.client.MongoClient client = MongoClients.create("mongodb+srv://appUser:app@cluster0.a4z3w.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("bookPlace");

        MongoCollection col = db.getCollection("Cluster0");

        Document testDoc = new Document("_id","1").append("name","Hi this is a name");

        col.insertOne(testDoc);

        client.close();
    }
}