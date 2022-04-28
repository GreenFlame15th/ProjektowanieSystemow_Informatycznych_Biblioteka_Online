package com.company;



public class LibraryObject {
    private int id;
    private Information information;
    private Place place;

    public enum Place {
        SHELF,
        ARCHIVE,
        CHECKED,
        STOCK;

        @Override
        public String toString() {
            switch (this) {
                case SHELF:
                    return "shelf";
                case ARCHIVE:
                    return "archive";
                case CHECKED:
                    return "checked";
            }
            return "";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: " + id + "\n" + information.toString() + "\nCurrently at:");
        if(place != null){sb.append(place.toString());}
        else{sb.append("unknown");}
        return sb.toString();
    }
    public LibraryObject() {
    }
    public LibraryObject(LibraryObject libraryObject) {
        this.id = libraryObject.id;
        this.information = libraryObject.information;
        this.place = libraryObject.place;
    }
    public LibraryObject(int id, Information information, Place place) {
        this.id = id;
        this.information = information;
        this.place = place;
    }


    //region getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
    //endregion
}
