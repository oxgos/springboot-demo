package com.itheima;

import com.itheima.Springboot03JUnitApplication;
import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(classes = Springboot03JUnitApplication.class) // 和引导类目录结构不同，需指定引导类
@SpringBootTest
class Springboot03JUnitApplicationTests {
	@Autowired
	private BookDao bookDao;

	@Test
	void contextLoads() {
		bookDao.save();
	}

}
