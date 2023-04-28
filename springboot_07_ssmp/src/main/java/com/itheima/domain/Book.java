package com.itheima.domain;

// lombok: 一个Java类库，提供了一给注解，简化POJO实体类开发
import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor // 所有参构造
//@NoArgsConstructor // 无参构造
//@Data整合了getter、setter、toString一系列方法，唯独没有构造方法
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String Description;
}
