package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot12ConfigurationApplicationTests {

    @Value("${servers.ipAddress}")
    private String msg;

    @Test
    void contextLoads() {
        System.out.println(msg);
    }

}
