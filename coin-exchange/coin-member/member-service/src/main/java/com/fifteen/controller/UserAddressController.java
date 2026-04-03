package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.UserAddress;
import com.fifteen.model.R;
import com.fifteen.service.UserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/userAddress")
@Api(tags = "用户钱包地址")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;


    @GetMapping
    @ApiOperation(value = "查询用户的钱包地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "current", value = "当前页", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, paramType = "query", dataType = "Integer")
    })
    public R<Page<UserAddress>> findByPage(@ApiIgnore Page<UserAddress> page, Long userId) {
        page.addOrder(OrderItem.desc("last_update_time"));
        Page<UserAddress> userAddressPage = userAddressService.findByPage(page, userId);
        return R.ok(userAddressPage);
    }

    @GetMapping("/current")
    public R getCurrentUserAddress(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        List<UserAddress> userAddressList = userAddressService.getUserAddressByUserId(Long.valueOf(userId)) ;
        return R.ok(userAddressList) ;
    }


    @GetMapping("/getCoinAddress/{coinId}")
    @ApiOperation(value = "查询用户某种币的钱包地址")
    public R<String> getCoinAddress(@PathVariable("coinId") Long coinId){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        UserAddress userAddress = userAddressService.getUserAddressByUserIdAndCoinId(userId,coinId) ;
        return R.ok(userAddress.getAddress()) ;
    }
}
