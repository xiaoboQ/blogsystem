package com.bobo.blogsystem.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "登录Vo")
public class LoginVo {

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户密码")
    private String password;
}
