package com.coin.user.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("基础返回类")
@Data
public class BaseResponse<T> {
    @ApiModelProperty(value = "code码", required = true)
    private Integer code;
    @ApiModelProperty(value = "消息内容", required = true)
    private String message;
    @ApiModelProperty(value = "具体值", required = true)
    private T data;
}
