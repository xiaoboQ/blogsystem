package com.bobo.blogsystem.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mirea
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "返回响应数据")
public class Result<T> {

    @JsonProperty(index = 1)
    @ApiModelProperty(value = "是否成功,200正常,400异常,401授权,403禁止")
    private int code;

    @JsonProperty(index = 2)
    @ApiModelProperty(value = "返回信息")
    private String msg;

    @JsonProperty(index = 3)
    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> Result<T> success(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> success(T data) {
        return success(200, "操作成功", data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return success(200, msg, data);
    }

    public static <T> Result<T> fail(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> fail(String msg) {
        return fail(400, msg, null);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return fail(400, msg, data);
    }
}

