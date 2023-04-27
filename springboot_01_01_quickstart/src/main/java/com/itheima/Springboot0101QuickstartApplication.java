package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// 引导类
// 这个注解：里面包含了@ComponentScan注解，会把引导类所在包的所有bean扫描出来
@SpringBootApplication
public class Springboot0101QuickstartApplication {

	public static void main(String[] args) {
		// 启动了spring的容器
		ConfigurableApplicationContext ctx = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
		// 每个controller都是一个bean，挂载在容器上面
		//		UserContorller bean = ctx.getBean(UserContorller.class);
		//		System.out.println("bean ======> " + bean);
		//		User uBean = ctx.getBean(User.class);
		//		System.out.println(uBean);
	}

}
