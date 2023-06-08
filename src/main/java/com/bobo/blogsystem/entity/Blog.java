package com.bobo.blogsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "博客表")
@TableName("blog")
public class Blog {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("博客标题")
    private String title;

    @ApiModelProperty("博客内容")
    private String content;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
