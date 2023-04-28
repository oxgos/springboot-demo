package com.itheima.dao;

import com.itheima.domain.Dialog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 配置映射
@Mapper
public interface DialogDao {
    @Select("select * from dialog_t where id = #{id}")
    public Dialog getById(Integer id);
}
