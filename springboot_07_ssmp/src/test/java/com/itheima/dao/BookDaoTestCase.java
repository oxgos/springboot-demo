package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        bookDao.selectById(1);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(11);
        book.setType("测试数据123-update");
        book.setName("测试数据123-update");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(11);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
    }

    @Test
    void testGetBy() {
        // 查询类
        QueryWrapper<Book> qw = new QueryWrapper<>();
        // name列带有Spring关键字的数据 select * from tbl_book where name like %Spring%
        qw.like("name", "Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2() {
        String name = "1";
        // Lambda语法（Book::getName）
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();

        // 好处，安全性高，不用hard code列名，容易出错
        // if (name != null) lqw.like(Book::getName, name);
        // 按条件查询，condition为false，不查询
        lqw.like(Strings.isNotEmpty(name), Book::getName, name);
        bookDao.selectList(lqw);
    }
}
