package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }
}

