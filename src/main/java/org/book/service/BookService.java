package org.book.service;

import org.book.beans.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();
    public Book findById(int id);
    public Book save(Book book);
    public void deleteById(int id);
    public Book update(Book book);
    public List<Book> findByAuthor(String author);
    public List<Book> findByTitle(String title);

}
