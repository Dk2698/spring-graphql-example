package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BookGraphqlController {

    @Autowired
    private BookService  bookService;

    @MutationMapping("createBook")
    public Book create(@Argument BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPages());
        return this.bookService.crate(b);
    }

    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book get(@Argument int bookId){
        return this.bookService.get(bookId);
    }
}

@Getter
@Setter
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}