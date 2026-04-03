package com.fifteen.vo;

import com.fifteen.domain.User;
import com.fifteen.domain.UserAuthAuditRecord;
import com.fifteen.domain.UserAuthInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "用户认证详细信息")
public class UseAuthInfoVo implements Serializable {

    @ApiModelProperty(value = "用户信息")
    private User user;

    @ApiModelProperty(value = "用户认证详情列表")
    private List<UserAuthInfo> userAuthInfoList;

    @ApiModelProperty(value = "用户认证审核记录列表")
    private List<UserAuthAuditRecord> authAuditRecordList;
}
