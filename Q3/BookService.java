package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.exception.BookNotFoundException;

public interface BookService {
    Book getBookById(Long id) throws BookNotFoundException;
}
