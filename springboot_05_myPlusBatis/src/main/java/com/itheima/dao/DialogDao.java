package com.itheima.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Dialog;
import org.apache.ibatis.annotations.Mapper;

// 配置映射
@Mapper
public interface DialogDao extends BaseMapper<Dialog> {}
