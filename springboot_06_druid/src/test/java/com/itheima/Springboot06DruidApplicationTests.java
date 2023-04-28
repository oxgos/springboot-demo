package com.itheima;

import com.itheima.dao.DialogDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06DruidApplicationTests {

    @Autowired
    private DialogDao dialogDao;
    @Test
    void contextLoads() {
        System.out.println(dialogDao.getById(1));
    }

}
