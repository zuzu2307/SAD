package com.solid.book;

import java.util.List;

public class BookReader extends BookPrintToScreen {
    public void main(String[] args) {
        Book book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        super.printToScreen(book);
    }

}
