package com.bobo.blogsystem.controller;

import com.bobo.blogsystem.service.UserBlogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/userblog")
@Api(tags = "用户博客接口")
public class UserBlogController {

    @Resource
    private UserBlogService userBlogService;
}
