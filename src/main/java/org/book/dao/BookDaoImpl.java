package org.book.dao;

import org.book.beans.Book;
import org.book.exception.BookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book findBookById(int id) {
        String sql = "select * from book where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    @Override
    public List<Book> findAllBooks() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public Book addBook(Book book) {
        Book existingBook = findBookById(book.getBookId());
        if(existingBook == null){
            throw new BookException("Book with Id: " + book.getBookId() + " already exists");
        }
        String sql = "insert into book values(?,?,?,?)";
        jdbcTemplate.update(sql, book.getBookId(), book.getTitle(), book.getAuthor(), book.getPrice());
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = findBookById(book.getBookId());
        if(existingBook == null){
            throw new BookException("Book with Id: " + book.getBookId() + " does not exists");
        }
        String sql = "update book set title = ?, author = ?, price = ? where id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getBookId());
        return book;
    }

    @Override
    public int deleteBook(int id) {
        Book existingBook = findBookById(id);
        if(existingBook == null){
            throw new BookException("Book with Id: " + id + " does not exists");
        }
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, id);
        return id;
    }
}
