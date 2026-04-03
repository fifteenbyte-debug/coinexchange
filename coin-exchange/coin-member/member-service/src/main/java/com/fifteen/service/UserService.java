package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.UnsetPayPasswordParam;
import com.fifteen.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fifteen.domain.UserBank;
import com.fifteen.dto.UserDto;
import com.fifteen.model.*;

import java.util.List;
import java.util.Map;

/**
 * @author msc
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2026-03-17 17:38:19
 */
public interface UserService extends IService<User> {

    Page<User> findByPage(Page<User> page, String mobile, String userId, String userName, String realName, Integer status, Integer reviewStatus);

    /**
     * 通过用户id查询该用户邀请的人员
     *
     * @param page
     * @param userId
     * @return
     */
    Page<User> findDirectInvitePage(Page<User> page, Long userId);

    /**
     * 修改用户审核状态
     *
     * @param id
     * @param authStatus
     * @param authCode
     */
    void updateUserAuthStatus(Long id, Integer authStatus, Long authCode, String remark);

    /**
     * 用户的实名认证
     *
     * @param aLong
     * @param userAuthForm
     * @return
     */
    boolean identifyCheck(Long aLong, UserAuthForm userAuthForm);

    /**
     * 用户的高级认证
     *
     * @param aLong
     * @param list
     */
    void authUser(Long aLong, List<String> list);

    /**
     * 修改手机号
     *
     * @param updatePhoneParam
     * @return
     */
    boolean updatePhone(Long id, UpdatePhoneParam updatePhoneParam);

    boolean checkNewPhone(String mobile, String countryCode);

    boolean updateLoginPwd(Long aLong, UpdateLoginParam updateLoginParam);

    boolean updatePayPwd(Long aLong, UpdateLoginParam updatePayPwdParam);

    boolean unsetPayPassword(Long aLong, UnsetPayPasswordParam setPayPasswordParam);

    List<User> getUserInvites(Long aLong);

    Map<Long, UserDto> getBasicUsers(List<Long> ids, String userName, String mobile);

    boolean register(RegisterParam registerParam);

    boolean unsetPassword(UnSetPasswordParam unsetPasswordParam);
}
