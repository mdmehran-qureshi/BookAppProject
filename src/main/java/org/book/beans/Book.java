package org.book.beans;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private int publications;
    private float price;

    public Book(int bookId, String title, String author, int publications, float price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publications = publications;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
