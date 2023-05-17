// 手写业务层（没有用Mp）
package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

// 业务层接口
public interface BookService {
    Book getById(Integer id);
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    List<Book> getAll();
}
