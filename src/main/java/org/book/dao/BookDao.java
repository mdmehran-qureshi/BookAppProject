package org.book.dao;

import org.book.beans.Book;

import java.util.List;

public interface BookDao {

    public Book findBookById(int id);
    public List<Book> findAllBooks();
    public Book addBook(Book book);
    public Book updateBook(Book book);
    public int deleteBook(int id);

}
