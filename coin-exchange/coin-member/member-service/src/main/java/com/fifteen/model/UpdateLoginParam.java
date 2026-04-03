package com.fifteen.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("修改登录密码参数")
@Data
public class UpdateLoginParam {

    @ApiModelProperty("旧密码")
    @NotBlank
    private String oldpassword;

    @ApiModelProperty("新密码")
    @NotBlank
    private String newpassword;

    @ApiModelProperty("验证码")
    @NotBlank
    private String validateCode;
}
