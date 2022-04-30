package com.company;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class DBAdapter {
    public static Information aaaa()
    {
        return null;
    }

    public static void printQuery(MongoCursor<Document> cursor)
    {
        while (cursor.hasNext())
            System.out.println(cursor.next());
    }

    public static void printDB(DBInterface db)
    {
        System.out.println("db:");
        printQuery(db.findDocumentByKey());
    }
}
