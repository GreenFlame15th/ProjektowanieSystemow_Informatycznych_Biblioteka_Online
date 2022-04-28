package com.company;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class LibraryObjectFactory {
    public static LibraryObject makeLibraryObject(String type)
    {
        LibraryObject toReturn = new LibraryObject();
        toReturn.setInformation(makeInformation(type));
        return  toReturn;
    }

    public static Information makeInformation(String type)
    {
        Information toReturn = new Information();
        toReturn.setType(type);
        switch(type) {
            case "book":
                toReturn.setName("unknown");
                toReturn.setCreationDate(new Date(0));
                toReturn.setCreators(new ArrayList<>());
                toReturn.setPageCount(-1);
                break;
            case "cassette":
                toReturn.setName("unknown");
                toReturn.setCreationDate(new Date(0));
                toReturn.setCreators(new ArrayList<>());
                toReturn.setDuration(new Time(0));
                break;
            case "document":
                toReturn.setName("unknown");
                toReturn.setCreationDate(new Date(0));
                toReturn.setCreators(new ArrayList<>());
                toReturn.setPageCount(-1);
                toReturn.setSignatures(new ArrayList<>());
                break;
            default: ;
        }
        return toReturn;
    }
    //region fields in information
    //private String type;
    //private String name;
    //private Date creationDate;
    //private List<Creator> creators;
    //private int pageCount;
    //private Time duration;
    //endregion

}
