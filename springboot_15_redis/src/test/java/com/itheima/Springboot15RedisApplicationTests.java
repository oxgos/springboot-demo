package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot15RedisApplicationTests {

	// 操作对象的，key都为对象序列化，如果要像命令行那样操作，需要用StringRedisTemplate
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void set() {
		ValueOperations ops = redisTemplate.opsForValue();
		ops.set("age", 41);
	}

	@Test
	void get() {
		ValueOperations ops = redisTemplate.opsForValue();
		Object age = ops.get("age");
		System.out.println(age);
	}

	@Test
	void hset() {
		HashOperations ops = redisTemplate.opsForHash();
		ops.put("info", "aa", "a");
	}

	@Test
	void hget() {
		HashOperations ops = redisTemplate.opsForHash();
		Object o = ops.get("info", "aa");
		System.out.println(o);
	}

}
