package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class DaoTest {

    @Autowired
    private IBookService bookService;

    @Test
    @Transactional
    @Rollback(false) // @Transactional默认回滚，也可用@Rollback直接配置
    void testSave() {
        Book book = new Book();
        book.setType("springboot");
        book.setName("springboot");
        book.setDescription("springboot");
        bookService.save(book);
    }
}
