package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("getById is running....");
        return "springboot";
    }

    @GetMapping("/one")
    public Book getOne() {
        Book book = new Book();
        book.setId(1);
        book.setType("springboot");
        book.setName("springboot");
        book.setDescription("springboot");
        return book;
    }
}
