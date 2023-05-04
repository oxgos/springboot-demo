package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

import java.util.List;

// 获取get,保存save,更新update,删除remove
public interface IBookService extends IService<Book> {
    // 自定义方法
    // @Override看Override有没报错，有报错证明没有重名方法，则不用写override注解
    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);
}
