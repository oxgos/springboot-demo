package com.itheima.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置类,给Mp读取
@Configuration
public class MPConfig {
    // 第三方类
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // Mp的拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 配置分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
