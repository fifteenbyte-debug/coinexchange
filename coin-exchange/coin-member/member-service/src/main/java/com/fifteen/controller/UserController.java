package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.*;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.model.*;
import com.fifteen.service.UserAuthAuditRecordService;
import com.fifteen.service.UserAuthInfoService;
import com.fifteen.service.UserBankService;
import com.fifteen.service.UserService;
import com.fifteen.vo.UseAuthInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Api(value = "用户管理")
public class UserController implements UserServiceFeign {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthAuditRecordService userAuthAuditRecordService;

    @Autowired
    private UserAuthInfoService userAuthInfoService;

    @Autowired
    private UserBankService userBankService;

    @GetMapping
    @ApiOperation("分页查询会员列表")
    @PreAuthorize("hasAnyAuthority('user_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "真实姓名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", dataType = "Integer", paramType = "query")
    })
    public R<Page> findByPage(@ApiIgnore Page<User> page, String mobile, String userId, String userName, String realName, Integer status) {
        page.addOrder(OrderItem.desc("last_update_time"));
        Page<User> userPage = userService.findByPage(page, mobile, userId, userName, realName, status, null);
        return R.ok(userPage);
    }

    @PostMapping("/status")
    @ApiOperation("修改会员状态")
    @PreAuthorize("hasAnyAuthority('user_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "会员ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", required = true, dataType = "Integer", paramType = "query")
    })
    public R updateStatus(Long id, Integer status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        return userService.updateById(user) ? R.ok("更新成功") : R.fail("更新失败");
    }

    @PatchMapping
    @ApiOperation("修改会员信息")
    @PreAuthorize("hasAnyAuthority('user_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "会员信息", required = true, dataType = "User", paramType = "body")
    })
    public R update(@RequestBody @Validated User user) {
        return userService.updateById(user) ? R.ok("更新成功") : R.fail("更新失败");
    }

    @GetMapping("/info")
    @ApiOperation("获取会员信息")
    @PreAuthorize("hasAnyAuthority('user_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "会员ID", required = true, dataType = "Long", paramType = "query")
    })
    public R<User> userInfo(Long id) {
        return R.ok(userService.getById(id));
    }

    @GetMapping("/directInvites")
    @ApiOperation("获取用户邀请的用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "query")
    })
    public R<Page<User>> getDirectInvites(@ApiIgnore Page<User> page, Long userId) {
        Page<User> userPage = userService.findDirectInvitePage(page, userId);
        return R.ok(userPage);
    }

    @GetMapping("/auths")
    @ApiOperation("获取用户待审核列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "mobile", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "真实姓名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "reviewsStatus", value = "审核状态", dataType = "Integer", paramType = "query")
    })
    public R<Page<User>> findUserAuths(@ApiIgnore Page<User> page, String mobile, String userId, String userName, String realName, Integer reviewsStatus) {
        Page<User> userPage = userService.findByPage(page, mobile, userId, userName, realName, null, reviewsStatus);
        return R.ok(userPage);
    }

    @GetMapping("/auth/info")
    @ApiOperation("获取用户认证详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "query")
    })
    public R<UseAuthInfoVo> getUserAuthInfo(Long id) {
        User user = userService.getById(id);
        List<UserAuthAuditRecord> userAuthAuditRecordList = null;
        List<UserAuthInfo> userAuthInfoList = null;
        if (user != null) {
            //用户的审核记录
            Integer reviewsStatus = user.getReviewsStatus();
            if (reviewsStatus == null || reviewsStatus == 0) { //待审核
                userAuthAuditRecordList = Collections.emptyList();
                userAuthInfoList = userAuthInfoService.getUserAuthInfoByUserId(id);
            } else {
                userAuthAuditRecordList = userAuthAuditRecordService.getUserAuthAuditRecordList(id);

                //查询用户的认证详情列表->用户的身份信息
                UserAuthAuditRecord userAuthAuditRecord = userAuthAuditRecordList.get(0);
                Long authCode = userAuthAuditRecord.getAuthCode();
                userAuthInfoList = userAuthInfoService.getUserAuthInfoByCode(authCode);
            }

        }
        UseAuthInfoVo useAuthInfoVo = new UseAuthInfoVo(user, userAuthInfoList, userAuthAuditRecordList);
        return R.ok(useAuthInfoVo);
    }

    @PostMapping("/auths/status")
    @ApiOperation("修改用户认证状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "authStatus", value = "认证状态", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "authCode", value = "认证码", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "审核拒绝的原因", dataType = "String", paramType = "query")
    })
    public R updateUserAuthStatus(@RequestParam Long id, @RequestParam Integer authStatus, @RequestParam Long authCode, String remark) {
        userService.updateUserAuthStatus(id, authStatus, authCode, remark);
        return R.ok("修改成功");
    }


    @GetMapping("/current/info")
    @ApiOperation("获取当前登录用户信息")
    public R<User> currentUserInfo() {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userService.getById(Long.valueOf(idStr));
        user.setPassword("****");
        user.setPaypassword("****");
        user.setAccessKeyId("****");
        user.setAccessKeySecret("****");
        return R.ok(user);
    }


    @PostMapping("/authAccount")
    @ApiOperation("用户实名认证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "真实姓名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "idCard", value = "身份证号", required = true, dataType = "String", paramType = "query"),
    })
    public R identifyCheck(@RequestBody UserAuthForm userAuthForm) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isOk = userService.identifyCheck(Long.valueOf(idStr), userAuthForm);
        return isOk ? R.ok("认证成功") : R.fail("认证失败");
    }

    @PostMapping("/authUser")
    @ApiOperation("用户高级认证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imgs", value = "图片地址", required = true, dataType = "String", paramType = "query"),
    })
    public R authUser(@RequestBody String[] imgs) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        userService.authUser(Long.valueOf(idStr), Arrays.asList(imgs));
        return R.ok();
    }


    @GetMapping("/checkTel")
    @ApiOperation(value = "检查新的手机号是否可用,如可用,则给该新手机发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "新的手机号"),
            @ApiImplicitParam(name = "countryCode", value = "手机号的区域")
    })
    public R checkNewPhone(@RequestParam(required = true) String mobile, @RequestParam(required = true) String countryCode) {
        boolean isOk = userService.checkNewPhone(mobile, countryCode);
        return isOk ? R.ok() : R.fail("新的手机号校验失败");
    }

    @PostMapping("/updatePhone")
    @ApiOperation("修改手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "updatePhoneParam", value = "updatePhoneParam 的json数据"),
    })
    public R updatePhone(@RequestBody @Validated UpdatePhoneParam updatePhoneParam) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isOk = userService.updatePhone(Long.valueOf(idStr), updatePhoneParam);
        return isOk ? R.ok("修改成功") : R.fail("修改失败");
    }

    @PostMapping("/updateLoginPassword")
    @ApiOperation("修改登录密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "updateLoginPwdParam", value = "updateLoginPwdParam 的json数据"),
    })
    public R updateLoginPwd(@RequestBody @Validated UpdateLoginParam updateLoginParam) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isOk = userService.updateLoginPwd(Long.valueOf(idStr), updateLoginParam);
        return isOk ? R.ok("修改成功") : R.fail("修改失败");
    }

    @PostMapping("/updatePayPassword")
    @ApiOperation("修改交易密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "updatePayPwdParam", value = "updatePayPwdParam 的json数据"),
    })
    public R updatePayPwd(@RequestBody @Validated UpdateLoginParam updatePayPwdParam) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isOk = userService.updatePayPwd(Long.valueOf(idStr), updatePayPwdParam);
        return isOk ? R.ok("修改交易密码成功") : R.fail("修改交易密码失败");
    }

    @PostMapping("/setPayPassword")
    @ApiOperation("重置交易密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "setPayPasswordParam", value = "setPayPasswordParam 的json数据"),
    })
    public R setPayPassword(@RequestBody @Validated UnsetPayPasswordParam setPayPasswordParam) {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        boolean isOk = userService.unsetPayPassword(Long.valueOf(idStr), setPayPasswordParam);
        return isOk ? R.ok("设置交易密码成功") : R.fail("设置交易密码失败");
    }

    @GetMapping("/invites")
    @ApiOperation("获取用户邀请列表")
    public R<List<User>> getUserInvites() {
        String idStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        List<User> users = userService.getUserInvites(Long.valueOf(idStr));
        return R.ok(users);
    }


    @PostMapping("/register")
    @ApiOperation(value = "用户的注册")
    public R register(@RequestBody RegisterParam registerParam) {
        boolean isOk = userService.register(registerParam);
        if (isOk) {
            return R.ok();
        }
        return R.fail("注册失败");
    }

    @PostMapping("/setPassword")
    @ApiOperation("重置登录密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unsetPasswordParam", value = "unsetPasswordParam 的json数据"),
    })
    public R unsetPassword(@RequestBody @Validated UnSetPasswordParam unsetPasswordParam){
        boolean isOk = userService.unsetPassword(unsetPasswordParam);
        return isOk ? R.ok("重置密码成功") : R.fail("重置密码失败");
    }

    @Override
    public Map<Long,UserDto> getBasicUsers(List<Long> ids, String userName, String mobile) {
        Map<Long,UserDto> userDtos = userService.getBasicUsers(ids,userName,mobile);
        return userDtos;
    }


}
