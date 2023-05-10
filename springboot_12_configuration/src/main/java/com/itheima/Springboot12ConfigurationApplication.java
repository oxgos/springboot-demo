package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 用了EnableConfigurationProperties指定类注入配置后，该类已经成了spring的bean,不用再用@Component修饰
//@EnableConfigurationProperties({ServerConfig.class}) // 多个Bean,传数组
@EnableConfigurationProperties(ServerConfig.class) // 单个Bean
public class Springboot12ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "data-source")
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot12ConfigurationApplication.class, args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
    }

}
