package com.bobo.blogsystem.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "博客信息Dto")
public class GetBlogDto {

    @ApiModelProperty("博客标题")
    private String title;

    @ApiModelProperty("博客内容")
    private String content;
}