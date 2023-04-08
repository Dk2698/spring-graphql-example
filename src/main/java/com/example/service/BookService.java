package com.example.service;

import com.example.entity.Book;

import java.util.List;

public interface BookService {
    Book crate(Book book);

    List<Book> getAll();

    Book get(int bookId);
}
