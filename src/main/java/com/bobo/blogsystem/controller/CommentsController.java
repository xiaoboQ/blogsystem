package com.bobo.blogsystem.controller;

import com.bobo.blogsystem.service.CommentsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/comments")
@Api(tags = "评论接口")
public class CommentsController {

    @Resource
    private CommentsService commentsService;
}
