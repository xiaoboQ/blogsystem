package com.bobo.blogsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.blogsystem.entity.Friend;
import com.bobo.blogsystem.mapper.FriendMapper;
import com.bobo.blogsystem.service.FriendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

    @Resource
    private FriendMapper friendMapper;
}
