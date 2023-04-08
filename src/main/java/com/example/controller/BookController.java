package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService  bookService;

    @PostMapping
    public Book create(@RequestBody Book book){
        return this.bookService.crate(book);
    }

    @GetMapping
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Book get(@PathVariable int bookId){
        return this.bookService.get(bookId);
    }
}
