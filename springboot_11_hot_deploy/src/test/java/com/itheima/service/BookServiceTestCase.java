package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.impl.BookServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookServiceImpl2 bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试类型11");
        book.setName("Spring实战 第5站11");
        book.setDescription("Spring入门经典教程，深入理解Spring11");
        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(12);
        book.setType("测试类型12");
        book.setName("Spring实战 第5站12");
        book.setDescription("Spring入门经典教程，深入理解Spring12");
        System.out.println(bookService.update(book));
    }

    @Test
    void testDelete() {
        System.out.println(bookService.delete(12));
    }

    @Test
    void testGetById() {
        System.out.println(bookService.getById(10));
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
    }
}
