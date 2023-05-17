// 手写业务层实现（没有用Mp）
package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

// 实现类
// 业务层的Bean
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

//    private HashMap<Integer, Book> cache = new HashMap<Integer, Book>();

    @Override
    @Cacheable(value = "cacheSpace", key="#id")
    public Book getById(Integer id) {
        Book queryBook = bookDao.selectById(id);
        return queryBook;
    }

//    @Override
//    public Book getById(Integer id) {
//        // 如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
//        Book book = cache.get(id);
//        if (book == null) {
//            Book queryBook = bookDao.selectById(id);
//            cache.put(id, queryBook);
//            return queryBook;
//        }
//        return book;
//    }

    @Override
    public Boolean save(Book book) {
        // 返回的是影响行，所以大于0成功，反之失败
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }


    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

}
