package org.book.service;

import org.book.beans.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> books = new ArrayList<>();

    public BookServiceImpl() {
        // Adding 10 new generated books
        for (int i = 0; i < 10; i++) {
            books.add(new Book(1000 + i, "Book Title " + (i + 1), "Author " + (i + 1), i + 1, 100.0f + i));
        }
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
        return books.stream()
                .filter(book -> book.getBookId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public void deleteById(int id) {
        books.removeIf(book -> book.getBookId() == id);
    }

    @Override
    public Book update(Book book) {
        if(findById(book.getBookId()) == null) {
            return null;
        }
        books = books.stream()
                .map(b -> b.getBookId() == book.getBookId() ? book : b)
                .collect(Collectors.toList());
        return book;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

}
