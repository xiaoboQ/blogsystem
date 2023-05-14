package com.bobo.blogsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户接口")
public class UserController {

    @ApiOperation("登录")
    @PostMapping("/login")
    public int test(){
        return 114514;
    }
}
