package com.bobo.blogsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blogsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
