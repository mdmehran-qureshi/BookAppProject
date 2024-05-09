package org.book.controllers;

import org.book.beans.Book;
import org.book.controllers.output.BookControllerGetOutput;
import org.book.controllers.output.BookControllerOutput;
import org.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAllBooks")
    public ResponseEntity<BookControllerGetOutput> findAllBooks() {
        List<Book> books = bookService.findAll();
        BookControllerGetOutput output = new BookControllerGetOutput(
                true,
                books.isEmpty() ? "No Books Found" : String.format("Found %d Books", books.size()),
                books);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<BookControllerGetOutput> findBookById(@PathVariable("id") int id) {
        Book book = bookService.findById(id);
        BookControllerGetOutput output = new BookControllerGetOutput(
                true,
                book == null ? "Book Not Found" : String.format("Found Book with Id = %s", id),
                book == null ? new ArrayList<>() : List.of(book));
        return ResponseEntity.ok(output);
    }

    @GetMapping("/findBooksByTitle/{title}")
    public ResponseEntity<BookControllerGetOutput> findBooksByTitle(@PathVariable("title") String title) {
        List<Book> books = bookService.findByTitle(title);
        BookControllerGetOutput output = new BookControllerGetOutput(
                true,
                books.isEmpty() ? "No Books Found" : String.format("Found %d Books", books.size()),
                books);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/findBooksByAuthor/{author}")
    public ResponseEntity<BookControllerGetOutput>findBooksByAuthor(@PathVariable("author") String author) {
        List<Book> books = bookService.findByAuthor(author);
        BookControllerGetOutput output = new BookControllerGetOutput(
                true,
                books.isEmpty() ? "No Books Found" : String.format("Found %d Books", books.size()),
                books);
        return ResponseEntity.ok(output);
    }

    @PostMapping("/addBook")
    public ResponseEntity<BookControllerOutput> addBook(@RequestBody Book book) {
        Book book_ = bookService.save(book);
        if (book_ == null) {
            BookControllerOutput output = new BookControllerOutput(false, "Unable to add book");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(output);
        }
        BookControllerOutput output = new BookControllerOutput(true, "Successfully added book");
        return ResponseEntity.ok(output);
    }

    @PutMapping("/editBook")
    public ResponseEntity<BookControllerOutput> editBook(@RequestBody Book book) {
        Book book_ = bookService.update(book);
        if (book_ == null) {
            BookControllerOutput output = new BookControllerOutput(false, "Unable to edit book or Book Not Found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(output);
        }
        BookControllerOutput output = new BookControllerOutput(true, "Successfully edited book");
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<BookControllerOutput> deleteBookById(@PathVariable("id") int id) {
        bookService.deleteById(id);
        BookControllerOutput output = new BookControllerOutput(true, "Successfully deleted Book");
        return ResponseEntity.ok(output);
    }

}
