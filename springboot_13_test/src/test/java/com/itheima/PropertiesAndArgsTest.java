package com.itheima;

import com.itheima.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// 1.properties属性哥以为当前测试用例添加临时的属性配置（优先级比yml高）
//@SpringBootTest(properties = {"test.prop=testValue1"})
// 2.args属性可以为当前测试用例添加临时的命令行参数
//@SpringBootTest(args = {"--test.prop=testValue2"})
// springboot2.7args覆盖properties，2.5pro覆盖args
//@SpringBootTest(args = {"--test.prop=testValue2"}, properties = {"test.prop=testValue1"})
@SpringBootTest(properties = {"test.prop=testValue1"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties() {

        System.out.println(msg);
        System.out.println(bookCase);
    }
}
