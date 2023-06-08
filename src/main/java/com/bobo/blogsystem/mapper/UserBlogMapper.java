package com.bobo.blogsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blogsystem.entity.UserBlog;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBlogMapper extends BaseMapper<UserBlog> {
}
