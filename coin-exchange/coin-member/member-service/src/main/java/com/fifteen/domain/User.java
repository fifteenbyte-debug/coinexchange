package com.fifteen.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户表
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户类型：1-普通用户；2-代理人
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @NotBlank
    private String username;

    /**
     * 国际电话区号
     */
    @TableField(value = "country_code")
    private String countryCode;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @NotBlank
    private String mobile;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 交易密码
     */
    @TableField(value = "paypassword")
    private String paypassword;

    /**
     * 交易密码设置状态
     */
    @TableField(value = "paypass_setting")
    private Integer paypassSetting;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 证件类型:1，身份证；2，军官证；3，护照；4，台湾居民通行证；5，港澳居民通行证；9，其他；
     */
    @TableField(value = "id_card_type")
    private Integer idCardType;

    /**
     * 认证状态：0-未认证；1-初级实名认证；2-高级实名认证
     */
    @TableField(value = "auth_status")
    private Integer authStatus;

    /**
     * Google令牌秘钥
     */
    @TableField(value = "ga_secret")
    private String gaSecret;

    /**
     * Google认证开启状态,0,未启用，1启用
     */
    @TableField(value = "ga_status")
    private Integer gaStatus;

    /**
     * 身份证号
     */
    @TableField(value = "id_card")
    private String idCard;

    /**
     * 代理商级别
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 认证时间
     */
    @TableField(value = "authtime")
    private Date authtime;

    /**
     * 登录数
     */
    @TableField(value = "logins")
    private Integer logins;

    /**
     * 状态：0，禁用；1，启用；
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 邀请码
     */
    @TableField(value = "invite_code")
    private String inviteCode;

    /**
     * 邀请关系
     */
    @TableField(value = "invite_relation")
    private String inviteRelation;

    /**
     * 直接邀请人ID
     */
    @TableField(value = "direct_inviteid")
    private String directInviteid;

    /**
     * 0 否 1是  是否开启平台币抵扣手续费
     */
    @TableField(value = "is_deductible")
    private Integer isDeductible;

    /**
     * 审核状态,1通过,2拒绝,0,待审核
     */
    @TableField(value = "reviews_status")
    private Integer reviewsStatus;

    /**
     * 代理商拒绝原因
     */
    @TableField(value = "agent_note")
    private String agentNote;

    /**
     * API的KEY
     */
    @TableField(value = "access_key_id")
    private String accessKeyId;

    /**
     * API的密钥
     */
    @TableField(value = "access_key_secret")
    private String accessKeySecret;

    /**
     * 引用认证状态id
     */
    @TableField(value = "refe_auth_id")
    private Long refeAuthId;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /**
     * 创建时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;

    /**
     * 会员高级认证状态，0:审核中，1:审核通过，2:拒绝--（拒绝理由），3:未填写
     */
    @TableField(exist = false)
    private Integer seniorAuthStatus;

    /**
     * 拒绝理由
     */
    @TableField(exist = false)
    private String seniorAuthDesc;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
                && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getPaypassword() == null ? other.getPaypassword() == null : this.getPaypassword().equals(other.getPaypassword()))
                && (this.getPaypassSetting() == null ? other.getPaypassSetting() == null : this.getPaypassSetting().equals(other.getPaypassSetting()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
                && (this.getIdCardType() == null ? other.getIdCardType() == null : this.getIdCardType().equals(other.getIdCardType()))
                && (this.getAuthStatus() == null ? other.getAuthStatus() == null : this.getAuthStatus().equals(other.getAuthStatus()))
                && (this.getGaSecret() == null ? other.getGaSecret() == null : this.getGaSecret().equals(other.getGaSecret()))
                && (this.getGaStatus() == null ? other.getGaStatus() == null : this.getGaStatus().equals(other.getGaStatus()))
                && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
                && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
                && (this.getAuthtime() == null ? other.getAuthtime() == null : this.getAuthtime().equals(other.getAuthtime()))
                && (this.getLogins() == null ? other.getLogins() == null : this.getLogins().equals(other.getLogins()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getInviteCode() == null ? other.getInviteCode() == null : this.getInviteCode().equals(other.getInviteCode()))
                && (this.getInviteRelation() == null ? other.getInviteRelation() == null : this.getInviteRelation().equals(other.getInviteRelation()))
                && (this.getDirectInviteid() == null ? other.getDirectInviteid() == null : this.getDirectInviteid().equals(other.getDirectInviteid()))
                && (this.getIsDeductible() == null ? other.getIsDeductible() == null : this.getIsDeductible().equals(other.getIsDeductible()))
                && (this.getReviewsStatus() == null ? other.getReviewsStatus() == null : this.getReviewsStatus().equals(other.getReviewsStatus()))
                && (this.getAgentNote() == null ? other.getAgentNote() == null : this.getAgentNote().equals(other.getAgentNote()))
                && (this.getAccessKeyId() == null ? other.getAccessKeyId() == null : this.getAccessKeyId().equals(other.getAccessKeyId()))
                && (this.getAccessKeySecret() == null ? other.getAccessKeySecret() == null : this.getAccessKeySecret().equals(other.getAccessKeySecret()))
                && (this.getRefeAuthId() == null ? other.getRefeAuthId() == null : this.getRefeAuthId().equals(other.getRefeAuthId()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPaypassword() == null) ? 0 : getPaypassword().hashCode());
        result = prime * result + ((getPaypassSetting() == null) ? 0 : getPaypassSetting().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getIdCardType() == null) ? 0 : getIdCardType().hashCode());
        result = prime * result + ((getAuthStatus() == null) ? 0 : getAuthStatus().hashCode());
        result = prime * result + ((getGaSecret() == null) ? 0 : getGaSecret().hashCode());
        result = prime * result + ((getGaStatus() == null) ? 0 : getGaStatus().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getAuthtime() == null) ? 0 : getAuthtime().hashCode());
        result = prime * result + ((getLogins() == null) ? 0 : getLogins().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getInviteCode() == null) ? 0 : getInviteCode().hashCode());
        result = prime * result + ((getInviteRelation() == null) ? 0 : getInviteRelation().hashCode());
        result = prime * result + ((getDirectInviteid() == null) ? 0 : getDirectInviteid().hashCode());
        result = prime * result + ((getIsDeductible() == null) ? 0 : getIsDeductible().hashCode());
        result = prime * result + ((getReviewsStatus() == null) ? 0 : getReviewsStatus().hashCode());
        result = prime * result + ((getAgentNote() == null) ? 0 : getAgentNote().hashCode());
        result = prime * result + ((getAccessKeyId() == null) ? 0 : getAccessKeyId().hashCode());
        result = prime * result + ((getAccessKeySecret() == null) ? 0 : getAccessKeySecret().hashCode());
        result = prime * result + ((getRefeAuthId() == null) ? 0 : getRefeAuthId().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", username=").append(username);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", mobile=").append(mobile);
        sb.append(", password=").append(password);
        sb.append(", paypassword=").append(paypassword);
        sb.append(", paypassSetting=").append(paypassSetting);
        sb.append(", email=").append(email);
        sb.append(", realName=").append(realName);
        sb.append(", idCardType=").append(idCardType);
        sb.append(", authStatus=").append(authStatus);
        sb.append(", gaSecret=").append(gaSecret);
        sb.append(", gaStatus=").append(gaStatus);
        sb.append(", idCard=").append(idCard);
        sb.append(", level=").append(level);
        sb.append(", authtime=").append(authtime);
        sb.append(", logins=").append(logins);
        sb.append(", status=").append(status);
        sb.append(", inviteCode=").append(inviteCode);
        sb.append(", inviteRelation=").append(inviteRelation);
        sb.append(", directInviteid=").append(directInviteid);
        sb.append(", isDeductible=").append(isDeductible);
        sb.append(", reviewsStatus=").append(reviewsStatus);
        sb.append(", agentNote=").append(agentNote);
        sb.append(", accessKeyId=").append(accessKeyId);
        sb.append(", accessKeySecret=").append(accessKeySecret);
        sb.append(", refeAuthId=").append(refeAuthId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", created=").append(created);
        sb.append("]");
        return sb.toString();
    }
}