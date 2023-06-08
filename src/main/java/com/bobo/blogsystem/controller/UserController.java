package com.bobo.blogsystem.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bobo.blogsystem.bean.Result;
import com.bobo.blogsystem.bean.vo.LoginVo;
import com.bobo.blogsystem.bean.vo.RegisterVo;
import com.bobo.blogsystem.entity.User;
import com.bobo.blogsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public int getTest(){
        return 11451;
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result<Boolean> postUser(@RequestBody RegisterVo registerVo){
        //数据校验
        if (registerVo.getUsername().length() == 0 || registerVo.getPassword().length() == 0 || registerVo.getEmail().length() == 0){
            return Result.fail("数据为空", false);
        }
        //检测当前用户是否已经被创建
        if (userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, registerVo.getUsername())) != null || userService.getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, registerVo.getEmail())) != null){
            return Result.fail("当前用户名或邮箱已被占用", false);
        }

        //复制数据
        User user = new User();
        BeanUtil.copyProperties(registerVo, user);
        user.setDeleted(1);
        user.setManger(0);

        userService.save(user);
        return Result.success(true);
    }

    @ApiModelProperty("登录")
    @PostMapping("/login")
    public Result<Boolean> login(@RequestBody LoginVo loginVo){
        //登陆验证
        if (userService.getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, loginVo.getEmail()).eq(User::getPassword, loginVo.getPassword())) != null){
            return Result.success(true);
        }
        return Result.fail("没有当前用户信息", false);
    }

}
