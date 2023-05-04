package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(10));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试类型20");
        book.setName("Spring实战 第5站20");
        book.setDescription("Spring入门经典教程，深入理解Spring20");
        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(10);
        book.setType("测试类型12");
        book.setName("Spring实战 第5站12");
        book.setDescription("Spring入门经典教程，深入理解Spring12");
        System.out.println(bookService.updateById(book));
    }

    @Test
    void testDelete() {
        System.out.println(bookService.removeById(12));
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.list());
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<Book>(1, 5);
        bookService.page(page);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
    }
}
