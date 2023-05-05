package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        // 如果当前页码值大于了总页面码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (currentPage > page.getPages()) {
//            bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(page);
//    }

    // query入参直接用实例去取
    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果当前页码值大于了总页面码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(page);
    }
}
