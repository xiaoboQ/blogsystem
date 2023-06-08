package com.bobo.blogsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "评论表")
@TableName("comments")
public class Comments {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("评论人id")
    private Integer authorId;

    @ApiModelProperty("博客id")
    private Integer blogId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
