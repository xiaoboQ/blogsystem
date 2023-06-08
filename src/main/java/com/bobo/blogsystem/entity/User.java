package com.bobo.blogsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "用户表")
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户有邮箱")
    private String email;

    //当该值为0则说明用户被删除，为1则未被删除
    @ApiModelProperty("用户逻辑删除")
    private Integer deleted;

    //若为0则是非管理员
    @ApiModelProperty("管理员")
    private Integer manger;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
