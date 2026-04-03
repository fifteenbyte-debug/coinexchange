package com.fifteen.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.util.Md5Utils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.*;
import com.fifteen.dto.UserDto;
import com.fifteen.mappers.UserDtoMapper;
import com.fifteen.model.*;
import com.fifteen.service.UserAuthAuditRecordService;
import com.fifteen.service.UserAuthInfoService;
import com.fifteen.service.UserService;
import com.fifteen.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2026-03-17 17:38:19
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserAuthAuditRecordService userAuthAuditRecordService;

    @Autowired
    private UserAuthInfoService userAuthInfoService;

    @Autowired
    private Snowflake snowflake;

    @Override
    public Page<User> findByPage(Page<User> page, String mobile, String userId, String userName, String realName, Integer status, Integer reviewStatus) {
        return page(page, new LambdaQueryWrapper<User>()
                .like(StringUtils.isNotBlank(mobile), User::getMobile, mobile)
                .like(StringUtils.isNotBlank(userId), User::getId, userId)
                .like(StringUtils.isNotBlank(userName), User::getUsername, userName)
                .like(StringUtils.isNotBlank(realName), User::getRealName, realName)
                .eq(status != null, User::getStatus, status)
                .eq(reviewStatus != null, User::getReviewsStatus, reviewStatus));
    }

    @Override
    public Page<User> findDirectInvitePage(Page<User> page, Long userId) {
        return page(page, new LambdaQueryWrapper<User>().eq(User::getDirectInviteid, userId));
    }

    @Override
    @Transactional
    public void updateUserAuthStatus(Long id, Integer authStatus, Long authCode, String remark) {
        log.info("开始修改用户的审核状态，当前用户={},用户的审核状态={},图片的唯一code={}", id, authStatus, authCode);
        User user = getById(id);
        if (user != null)
            user.setReviewsStatus(authStatus); //审核状态
        updateById(user);
        UserAuthAuditRecord userAuthAuditRecord = new UserAuthAuditRecord();
        userAuthAuditRecord.setAuthCode(authCode);
        userAuthAuditRecord.setUserId(id);
        userAuthAuditRecord.setStatus(authStatus);
        userAuthAuditRecord.setRemark(remark);
        String userStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        userAuthAuditRecord.setAuditUserId(Long.valueOf(userStr));
        userAuthAuditRecord.setAuditUserName("--------------------");//审核人名称->远程调用admin=service
        userAuthAuditRecordService.save(userAuthAuditRecord);

    }

    @Override
    public boolean identifyCheck(Long id, UserAuthForm userAuthForm) {
        User user = getById(id);
        Assert.notNull("认证用户不存在");
        Integer authStatus = user.getAuthStatus();
        if (!Objects.equals(authStatus, 0)) {
            throw new IllegalArgumentException("该用户已经认证成功了");
        }
        //极验认证，这里代码没写
        //实名认证，调用阿里云，这里代码没写
        user.setAuthtime(new Date());
        user.setAuthStatus(1);
        user.setRealName(userAuthForm.getRealName());
        user.setIdCardType(userAuthForm.getIdCardType());
        user.setIdCard(userAuthForm.getIdCard());
        updateById(user);
        return true;
    }

    @Override
    public void authUser(Long id, List<String> imgs) {
//        if (CollectionUtils.isEmpty(imgs)) {
//            throw new IllegalArgumentException("用户的身份证信息为null");
//        }
        User user = getById(id);
        if (user == null) {
            throw new IllegalArgumentException("请输入正确的userId");
        }
        long authCode = snowflake.nextId(); // 使用时间戳(有重复) --> 雪花算法
        List<UserAuthInfo> userAuthInfoList = new ArrayList<>(imgs.size());
        for (int i = 0; i < imgs.size(); i++) { // 有序排列
            String s = imgs.get(i);
            UserAuthInfo userAuthInfo = new UserAuthInfo();
            userAuthInfo.setImageUrl("https://djqkl.oss-cn-hongkong.aliyuncs.com/static/1530607874865.jpg");
            userAuthInfo.setUserId(id);
            userAuthInfo.setSerialno(i + 1);  // 设置序号 ,1 正面  2 反面 3 手持
            userAuthInfo.setAuthCode(authCode); // 是一组身份信息的标识 3 个图片为一组
            userAuthInfoList.add(userAuthInfo);
        }
        userAuthInfoService.saveBatch(userAuthInfoList); // 批量操作


        user.setReviewsStatus(0); // 等待审核
        updateById(user); // 更新用户的状态
    }

    @Override
    public boolean updatePhone(Long userId, UpdatePhoneParam updatePhoneParam) {
        User user = getById(userId);
        String oldMobile = user.getMobile();
        user.setMobile(updatePhoneParam.getNewMobilePhone());
        log.info("修改手机号,userId={},oldMobile={},newMobile={}", userId, oldMobile, updatePhoneParam.getNewMobilePhone());
        return updateById(user);
    }

    @Override
    public boolean checkNewPhone(String mobile, String countryCode) {
        int count = count(new LambdaQueryWrapper<User>().eq(User::getMobile, mobile).eq(User::getCountryCode, countryCode));
        if (count > 0) {
            throw new IllegalArgumentException("该手机号已经存在");
        }
        return true;
    }

    @Override
    public boolean updateLoginPwd(Long userId, UpdateLoginParam updateLoginParam) {
        User user = getById(userId);
        if (user == null) {
            throw new IllegalArgumentException("请输入正确的用户Id");
        }
        String oldpassword = updateLoginParam.getOldpassword();
        boolean matches = new BCryptPasswordEncoder().matches(oldpassword, user.getPassword());
        if (!matches) {
            throw new IllegalArgumentException("请输入正确的旧密码");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(updateLoginParam.getNewpassword()));
        return updateById(user);
    }

    @Override
    public boolean updatePayPwd(Long userId, UpdateLoginParam updatePayPwdParam) {
        User user = getById(userId);
        if (user == null) {
            throw new IllegalArgumentException("请输入正确的用户Id");
        }
        String oldpassword = updatePayPwdParam.getOldpassword();
        boolean matches = new BCryptPasswordEncoder().matches(oldpassword, user.getPaypassword());
        if (!matches) {
            throw new IllegalArgumentException("请输入正确的旧密码");
        }
        user.setPaypassword(new BCryptPasswordEncoder().encode(updatePayPwdParam.getNewpassword()));
        return updateById(user);
    }

    @Override
    public boolean unsetPayPassword(Long userId, UnsetPayPasswordParam setPayPasswordParam) {
        User user = getById(userId);
        if (user == null) {
            throw new IllegalArgumentException("请输入正确的用户Id");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPaypassword(bCryptPasswordEncoder.encode(setPayPasswordParam.getPayPassword()));
        return updateById(user);
    }

    @Override
    public List<User> getUserInvites(Long userId) {
        List<User> users = list(new LambdaQueryWrapper<User>().eq(User::getDirectInviteid, userId));
        if (CollectionUtils.isEmpty(users)) {
            return Collections.emptyList();
        }
        users.forEach(user -> {
            user.setPaypassword("*****");
            user.setPassword("*****");
            user.setAccessKeyId("*****");
            user.setAccessKeySecret("*****");
        });
        return users;
    }

    @Override
    public Map<Long, UserDto> getBasicUsers(List<Long> ids, String userName, String mobile) {
        if (CollectionUtils.isEmpty(ids) && StringUtils.isEmpty(userName) && StringUtils.isEmpty(mobile)) {
            return Collections.emptyMap();
        }
        List<User> list = list(new LambdaQueryWrapper<User>()
                .in(!CollectionUtils.isEmpty(ids), User::getId, ids)
                .like(!StringUtils.isEmpty(userName), User::getUsername, userName)
                .like(!StringUtils.isEmpty(mobile), User::getMobile, mobile));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }
        // 将user->userDto
        List<UserDto> userDtos = UserDtoMapper.INSTANCE.convert2Dto(list);
        Map<Long, UserDto> userDtoMaps = userDtos.stream().collect(Collectors.toMap(UserDto::getId, userDto -> userDto));
        return userDtoMaps;
    }

    /**
     * 用户的注册
     *
     * @param registerParam 注册的表单参数
     * @return
     */
    @Override
    public boolean register(RegisterParam registerParam) {
        log.info("用户开始注册{}", JSON.toJSONString(registerParam, true));
        String mobile = registerParam.getMobile();
        String email = registerParam.getEmail();
        // 1 简单的校验
        if (StringUtils.isEmpty(email) && StringUtils.isEmpty(mobile)) {
            throw new IllegalArgumentException("手机号或邮箱不能同时为空");
        }
        // 2 查询校验
        int count = count(new LambdaQueryWrapper<User>()
                .eq(!StringUtils.isEmpty(email), User::getEmail, email)
                .eq(!StringUtils.isEmpty(mobile), User::getMobile, mobile)
        );
        if (count > 0) {
            throw new IllegalArgumentException("手机号或邮箱已经被注册");
        }

        User user = getUser(registerParam); // 构建一个新的用户
        return save(user);
    }

    @Override
    public boolean unsetPassword(UnSetPasswordParam unsetPasswordParam) {
        log.info("开始重置密码{}",JSON.toJSONString(unsetPasswordParam, true));
        String mobile = unsetPasswordParam.getMobile();
        User user = getOne(new LambdaQueryWrapper<User>().eq(User::getMobile, mobile));
        if(user == null){
            throw new IllegalArgumentException("该用户不存在");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(unsetPasswordParam.getPassword()));
        return updateById(user);
    }

    private User getUser(RegisterParam registerParam) {
        User user = new User();
        user.setCountryCode(registerParam.getCountryCode());
        user.setEmail(registerParam.getEmail());
        user.setMobile(registerParam.getMobile());
        String encodePwd = new BCryptPasswordEncoder().encode(registerParam.getPassword());
        user.setPassword(encodePwd);
        user.setPaypassSetting(0);
        user.setStatus(1);
        user.setType(1);
        user.setAuthStatus(0);
        user.setLogins(0);
        user.setInviteCode(RandomUtil.randomString(6)); // 用户的邀请码
        if (!StringUtils.isEmpty(registerParam.getInvitionCode())) {
            User userPre = getOne(new LambdaQueryWrapper<User>().eq(User::getInviteCode, registerParam.getInvitionCode()));
            if (userPre != null) {
                user.setDirectInviteid(String.valueOf(userPre.getId())); // 邀请人的id , 需要查询
                user.setInviteRelation(String.valueOf(userPre.getId())); // 邀请人的id , 需要查询
            }
        }
        return user;
    }

    @Override
    public User getById(Serializable id) {
        User user = super.getById(id);
        if (user == null) {
            throw new IllegalArgumentException("请输入正确的用户Id");
        }
        Integer seniorAuthStatus = null; // 用户的高级认证状态
        String seniorAuthDesc = "";// 用户的高级认证未通过,原因
        Integer reviewsStatus = user.getReviewsStatus(); // 用户被审核的状态 1通过,2拒绝,0,待审核"
        if (reviewsStatus == null) { //为null 时,代表用户的资料没有上传
            seniorAuthStatus = 3;
            seniorAuthDesc = "资料未填写";
        } else {
            switch (reviewsStatus) {
                case 1:
                    seniorAuthStatus = 1;
                    seniorAuthDesc = "审核通过";
                    break;
                case 2:
                    seniorAuthStatus = 2;
                    // 查询被拒绝的原因--->审核记录里面的
                    // 时间排序,
                    List<UserAuthAuditRecord> userAuthAuditRecordList = userAuthAuditRecordService.getUserAuthAuditRecordList(user.getId());
                    if (!CollectionUtils.isEmpty(userAuthAuditRecordList)) {
                        UserAuthAuditRecord userAuthAuditRecord = userAuthAuditRecordList.get(0);
                        seniorAuthDesc = userAuthAuditRecord.getRemark();
                    } else {
                        seniorAuthDesc = "原因未知";
                    }
                    break;
                case 0:
                    seniorAuthStatus = 0;
                    seniorAuthDesc = "等待审核";
                    break;

            }
        }
        user.setSeniorAuthStatus(seniorAuthStatus);
        user.setSeniorAuthDesc(seniorAuthDesc);
        return user;
    }


    public static void main(String[] args) {
        String oldPassword = "LTD12345";
        String md5 = Md5Utils.getMD5(oldPassword.getBytes());
        System.out.println(md5);
        BCryptPasswordEncoder ltd12345 = new BCryptPasswordEncoder();
        String encode = ltd12345.encode(md5);
        System.out.println("old:" + encode);

        String newPassword = "LTE12345";
        String md5_new = Md5Utils.getMD5(newPassword.getBytes());
        System.out.println(md5_new);
        BCryptPasswordEncoder lte12345 = new BCryptPasswordEncoder();
        String encode_new = lte12345.encode(md5_new);
        System.out.println("new:" + encode_new);
    }
}




