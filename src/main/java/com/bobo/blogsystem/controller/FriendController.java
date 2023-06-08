package com.bobo.blogsystem.controller;

import com.bobo.blogsystem.service.FriendService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/friend")
@Api(tags = "博友接口")
public class FriendController {

    @Resource
    private FriendService friendService;
}
