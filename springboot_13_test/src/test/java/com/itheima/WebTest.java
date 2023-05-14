package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

// webEnvironment默认是SpringBootTest.WebEnvironment.NONE
// DEFINED_PORT默认端口，RANDOM_PORT随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
// 开启虚拟Mvc调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    // 小范围的自动装配
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        // 创建了一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行对应的请求
        mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        // 创建了一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行对应的请求
        ResultActions action = mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，
        // 定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用时成功的：状态200
        ResultMatcher ok = status.isOk();
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        // 创建了一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行对应的请求
        ResultActions action = mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，
        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("springboot");
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(result);
    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {
        // 创建了一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/one");
        // 执行对应的请求
        ResultActions action = mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，
        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\n" +
                "\"id\": 1,\n" +
                "\"type\": \"springboot\",\n" +
                "\"name\": \"springboot\",\n" +
                "\"description\": \"springboot\"\n" +
                "}");
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(result);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        // 创建了一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/one");
        // 执行对应的请求
        ResultActions action = mvc.perform(builder);

        // 设定预期值与真实值进行比较，成功测试通过，
        // 定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(contentType);
    }

    // 实际开发写法
    @Test
    void getOne(@Autowired MockMvc mvc) throws Exception {
        // 创建了一个虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/one");
        // 执行对应的请求
        ResultActions action = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        action.andExpect(contentType);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\n" +
                "\"id\": 1,\n" +
                "\"type\": \"springboot\",\n" +
                "\"name\": \"springboot\",\n" +
                "\"description\": \"springboot\"\n" +
                "}");
        action.andExpect(result);
    }
}
