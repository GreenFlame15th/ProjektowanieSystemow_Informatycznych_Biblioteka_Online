package com.company;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

public class DBInterface {
    private static DBInterface instance;
    private MongoDatabase db;
    private MongoCollection col;
    private com.mongodb.client.MongoClient client;

    private DBInterface()
    {
    }
    public static DBInterface getInstance()
    {
        if (instance == null)
        {
            synchronized (DBInterface.class)
            {
                if(instance==null)
                {
                    instance = new DBInterface();
                }
            }
        }
        return instance;
    }

    public void connect()
    {
        client = MongoClients.create("mongodb+srv://appUser:app@cluster0.a4z3w.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        db = client.getDatabase("bookPlace");
        col = db.getCollection("bookThing");
    }

    public void close()
    {
        client.close();
    }

    public MongoCursor<Document> findDocumentById(String id) {
        DBObject query = new BasicDBObject("_id", id);
        return col.find((ClientSession) query).cursor();
    }

    public MongoCursor<Document> findDocumentByKey(Bson query) {
        return col.find(query).cursor();
    }

    public MongoCursor<Document> findDocumentByKey() {
        return col.find().cursor();
    }

    public MongoCursor<Document> findDocumentByKey(BasicDBObject query) {
        return col.find(query).cursor();
    }

    public boolean modify(Bson newObject, Bson oldObject)
    {
        col.findOneAndDelete(oldObject);
        col.insertOne(newObject);
        return true;
    }

    public boolean insert(Bson object)
    {
        col.insertOne(object);
        return true;
    }

    public boolean remove(Bson object)
    {
        col.findOneAndDelete(object);
        return true;
    }


}
