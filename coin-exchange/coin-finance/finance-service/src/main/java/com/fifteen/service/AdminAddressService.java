package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.AdminAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【admin_address(平台归账手续费等账户)】的数据库操作Service
* @createDate 2026-03-24 15:05:56
*/
public interface AdminAddressService extends IService<AdminAddress> {

    /**
     * 条件分页查询归集地址
     * @param page
     * 分页参数
     * @param coinId
     * 币种的Id
     * @return
     */
    Page<AdminAddress> findByPage(Page<AdminAddress> page, Long coinId);
}
