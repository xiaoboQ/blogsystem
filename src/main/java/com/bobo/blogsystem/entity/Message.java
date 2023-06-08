package com.bobo.blogsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "留言表")
@TableName("message")
public class Message {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("留言内容")
    private String content;

    @ApiModelProperty("留言所有者id")
    private Integer userId;

    @ApiModelProperty("留言作者id")
    private Integer authorId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
