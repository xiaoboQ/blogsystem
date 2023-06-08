package com.bobo.blogsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.blogsystem.entity.UserBlog;
import com.bobo.blogsystem.mapper.UserBlogMapper;
import com.bobo.blogsystem.service.UserBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBlogServiceImpl extends ServiceImpl<UserBlogMapper, UserBlog> implements UserBlogService {

    @Resource
    private UserBlogMapper userBlogMapper;
}
