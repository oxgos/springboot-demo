package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.stereotype.Service;

// 继承ServiceImpl,Crud功能自动根据BookDao和Book实现了
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
