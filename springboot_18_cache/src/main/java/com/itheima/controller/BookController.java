package com.itheima.controller;

import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 表现层
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll() {
        return new R(bookService.getAll());
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

    @PutMapping
    public R update(@RequestBody Book book) {
        Boolean flag = bookService.update(book);
        int code = flag ? 1 : 0;
        String message = flag ? "更新成功!" : "更新失败!";
        return new R(code, message);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        int code = bookService.delete(id) ? 1 : 0;
        return new R(code, "删除成功");
    }

}
