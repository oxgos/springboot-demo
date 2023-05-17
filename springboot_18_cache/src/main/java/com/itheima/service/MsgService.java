// 手写业务层（没有用Mp）
package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

// 业务层接口
public interface MsgService {
    public String get(String tele);
    public Boolean check(String tele, String code);
}
