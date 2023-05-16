package com.itheima;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot16MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        System.out.println(123);
        Book book = new Book();
        book.setId(1);
        book.setName("springboot1");
        book.setType("springboot2");
        book.setDescription("springboot3");

        mongoTemplate.save(book);
    }

    @Test
    void testFind() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }

}
