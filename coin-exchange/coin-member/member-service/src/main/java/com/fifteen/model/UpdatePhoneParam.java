package com.fifteen.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("修改手机号")
public class UpdatePhoneParam {

    @ApiModelProperty("国家代码")
    @NotBlank
    private String countryCode;

    @ApiModelProperty("新手机号")
    @NotBlank
    private String newMobilePhone;

    @ApiModelProperty("新手机号验证码")
    @NotBlank
    private String validateCode;

    @ApiModelProperty("旧手机号验证码")
    @NotBlank
    private String oldValidateCode;
}
