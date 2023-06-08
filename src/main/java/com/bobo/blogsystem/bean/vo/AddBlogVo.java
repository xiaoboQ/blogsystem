package com.bobo.blogsystem.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "博客增加Vo")
public class AddBlogVo {

    @ApiModelProperty("博客标题")
    private String title;

    @ApiModelProperty("博客内容")
    private String content;

    @ApiModelProperty("博客作者")
    private String email;
}
