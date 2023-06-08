package com.bobo.blogsystem.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bobo.blogsystem.bean.Result;
import com.bobo.blogsystem.bean.dto.GetBlogDto;
import com.bobo.blogsystem.bean.vo.AddBlogVo;
import com.bobo.blogsystem.bean.vo.GetBlogVo;
import com.bobo.blogsystem.entity.Blog;
import com.bobo.blogsystem.entity.User;
import com.bobo.blogsystem.entity.UserBlog;
import com.bobo.blogsystem.service.BlogService;
import com.bobo.blogsystem.service.UserBlogService;
import com.bobo.blogsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/blog")
@Api(tags = "博客接口")
public class BolgController {

    @Resource
    private BlogService blogService;

    @Resource
    private UserService userService;

    @Resource
    private UserBlogService userBlogService;

    @ApiOperation("博客增加")
    @PostMapping("/add")
    public Result<Boolean> addBlog(@RequestBody AddBlogVo addBlogVo){
        System.out.println("Done");
        if (addBlogVo.getTitle().length() == 0 || addBlogVo.getContent().length() == 0){
            return Result.fail("数据为空", false);
        } else if (blogService.getOne(new LambdaQueryWrapper<Blog>().eq(Blog::getTitle, addBlogVo.getTitle())) != null) {
            return Result.fail("标题重复", false);
        }
        Blog blog = new Blog();
        BeanUtil.copyProperties(addBlogVo, blog);
        //存放博客数据
        blogService.save(blog);

        //存放博客用户表
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, addBlogVo.getEmail()));
        Blog blogTemp = blogService.getOne(new LambdaQueryWrapper<Blog>().eq(Blog::getTitle, addBlogVo.getTitle()));

        int userId = user.getId();
        int blogId = blogTemp.getId();
        UserBlog userBlog = new UserBlog();
        userBlog.setUserId(userId);
        userBlog.setBlogId(blogId);
        //存放用户博客表
        userBlogService.save(userBlog);

        return Result.success(true);
    }

    @ApiOperation("获取博客")
    @PostMapping("/getBlog")
    public Result<List<GetBlogDto>> getBlog(@RequestBody GetBlogVo getBlogVo){
        if (!getBlogVo.getEmail().equals("*")){
            User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, getBlogVo.getEmail()));
            int userId = user.getId();
            List<UserBlog> userBlogs = userBlogService.list(new LambdaQueryWrapper<UserBlog>().eq(UserBlog::getUserId, userId).select(UserBlog::getBlogId));
            List<GetBlogDto> getBlogDtos = new ArrayList<>();
            for (UserBlog userBlog : userBlogs) {
                int blogId = userBlog.getBlogId();
                Blog blog = blogService.getOne(new LambdaQueryWrapper<Blog>().eq(Blog::getId, blogId));
                GetBlogDto getBlogDto = new GetBlogDto();
                getBlogDto.setTitle(blog.getTitle());
                getBlogDto.setContent(blog.getContent());
                getBlogDtos.add(getBlogDto);
            }
            return Result.success(getBlogDtos);
        } else{
            List<Blog> blogs = blogService.list();
            int length = blogs.size();

            if (length <= 10){
                List<GetBlogDto> getBlogDtos = new ArrayList<>();
                for (Blog blog : blogs){
                    GetBlogDto getBlogDto = new GetBlogDto();
                    getBlogDto.setTitle(blog.getTitle());
                    getBlogDto.setContent(blog.getContent());
                }
                return Result.success(getBlogDtos);
            }else{
                Random random = new Random();
                int number = random.nextInt(length - 10);
                List<GetBlogDto> getBlogDtos = new ArrayList<>();
                for (int j = 0 ; j < 10 ; j++){
                    GetBlogDto getBlogDto = new GetBlogDto();
                    System.out.println(blogs.get(number));
                    getBlogDto.setTitle(blogs.get(number).getTitle());
                    getBlogDto.setContent(blogs.get(number).getContent());
                    getBlogDtos.add(getBlogDto);
                    number+=1;
                }
                return Result.success(getBlogDtos);
            }
        }
    }
}
