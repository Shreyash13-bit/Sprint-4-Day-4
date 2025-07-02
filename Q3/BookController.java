package com.example.demo.controller;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.exception.BookNotFoundException;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }
}
