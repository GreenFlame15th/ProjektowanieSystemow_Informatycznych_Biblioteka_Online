package com.company;

public abstract class Main {

    public static void main(String[] args) {
        SingletonDataBaseAccess db = SingletonDataBaseAccess.getInstance();

        for (LibraryObject libraryObject: db.getStock()) {
        System.out.println("-------\n"+libraryObject.toString());
        }

        System.out.println("######################");

        db.add(LibraryObjectFactory.makeLibraryObject("book"));
        db.add(LibraryObjectFactory.makeLibraryObject("book"));
        db.add(LibraryObjectFactory.makeLibraryObject("cassette"));
        db.add(LibraryObjectFactory.makeLibraryObject("document"));
        db.add(LibraryObjectFactory.makeLibraryObject("oneOfType"));

        for (LibraryObject libraryObject: db.getStock()) {
            System.out.println("-------\n"+libraryObject.toString());
        }

        System.out.println("######################");

        for (LibraryObject libraryObject: db.getStock().stream().filter(
                        libraryObject -> libraryObject.getInformation().getName() == "unknown" ||
                                libraryObject.getInformation() == null

                ).toList()) {
            db.remove(libraryObject);
        }

        for (LibraryObject libraryObject: db.getStock()) {
            System.out.println("-------\n"+libraryObject.toString());
        }
    }

}
