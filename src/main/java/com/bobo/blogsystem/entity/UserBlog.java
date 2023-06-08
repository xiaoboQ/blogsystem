package com.bobo.blogsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "用户博客表")
@TableName("user_blog")
public class UserBlog {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("博客作者id")
    private Integer userId;

    @ApiModelProperty("博客id")
    private Integer blogId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
