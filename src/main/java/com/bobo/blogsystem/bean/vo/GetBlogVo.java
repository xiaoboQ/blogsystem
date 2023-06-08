package com.bobo.blogsystem.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "博客获取Vo")
public class GetBlogVo {

    //email若为正常则查询自己，若为*则随机查询
    @ApiModelProperty
    private String email;
}
