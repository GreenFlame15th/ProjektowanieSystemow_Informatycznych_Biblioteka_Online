package com.company;

public class Book extends LibraryObject implements  ICanBeBorrowed {
    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
