package com.bobo.blogsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.blogsystem.entity.Message;
import com.bobo.blogsystem.mapper.MessageMapper;
import com.bobo.blogsystem.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Resource
    private MessageMapper messageMapper;
}
