package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

public interface IBookService {
    boolean save(Book book);
}
