package com.itheima.controller;

import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

// 表现层
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(bookService.list());
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(bookService.getById(id));
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        Boolean flag = bookService.save(book);
        int code = flag ? 1 : 0;
        String message = flag ? "添加成功!" : "添加失败!";
        return new R(code, message);
    }

    // 模拟请求报错
//    @PostMapping
//    public R save(@RequestBody Book book) throws IOException {
//        if (true) throw new IOException();
//        int code = bookService.save(book) ? 1 : 0;
//        return new R(code);
//    }

    @PutMapping
    public R update(@RequestBody Book book) {
        Boolean flag = bookService.updateById(book);
        int code = flag ? 1 : 0;
        String message = flag ? "更新成功!" : "更新失败!";
        return new R(code, message);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        int code = bookService.removeById(id) ? 1 : 0;
        return new R(code, "删除成功");
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(bookService.getPage(currentPage, pageSize));
    }
}
