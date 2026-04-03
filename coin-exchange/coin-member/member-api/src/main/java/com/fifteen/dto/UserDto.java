package com.fifteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("远程调用传递user对象")
public class UserDto {

    /**
     * 自增id
     */
    @ApiModelProperty(value="自增id")
    private Long id;


    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 国际电话区号
     */
    @ApiModelProperty(value="国际电话区号")
    private String countryCode;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String mobile;


    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value="真实姓名")
    private String realName;

    private String paypassword;
}
