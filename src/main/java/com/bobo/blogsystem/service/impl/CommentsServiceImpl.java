package com.bobo.blogsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.blogsystem.entity.Comments;
import com.bobo.blogsystem.mapper.CommentsMapper;
import com.bobo.blogsystem.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Resource
    private CommentsMapper commentsMapper;
}
