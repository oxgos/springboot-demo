package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 表现层
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(1, bookService.list(), "");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(1, bookService.getById(id), "");
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        int code = bookService.save(book) ? 1 : 0;
        return new R(code);
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        int code = bookService.updateById(book) ? 1 : 0;
        return new R(code);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        int code = bookService.removeById(id) ? 1 : 0;
        return new R(code);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(1, bookService.getPage(currentPage, pageSize), "");
    }
}
