package org.book.controllers.output;

import org.book.beans.Book;

import java.util.List;

public class BookControllerGetOutput {

    private boolean success;
    private String message;
    private List<Book> books;

    public BookControllerGetOutput(boolean success, String message, List<Book> books) {
        this.success = success;
        this.message = message;
        this.books = books;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
