package com.bobo.blogsystem.controller;

import com.bobo.blogsystem.service.MessageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/userblog")
@Api(tags = "留言接口")
public class MessageController {

    @Resource
    private MessageService messageService;
}
