package com.bobo.blogsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blogsystem.entity.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
}
