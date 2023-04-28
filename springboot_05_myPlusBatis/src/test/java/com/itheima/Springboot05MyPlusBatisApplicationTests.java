package com.itheima;

import com.itheima.dao.DialogDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MyPlusBatisApplicationTests {

	@Autowired
	private DialogDao dialogDao;

	@Test
	void contextLoads() {
		System.out.println(dialogDao.selectById(1));
	}

	@Test
	void testGetAll() {
		System.out.println(dialogDao.selectList(null));
	}
}
