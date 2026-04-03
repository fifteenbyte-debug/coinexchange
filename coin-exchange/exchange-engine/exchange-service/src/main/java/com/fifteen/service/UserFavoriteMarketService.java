package com.fifteen.service;

import com.fifteen.domain.UserFavoriteMarket;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【user_favorite_market(用户收藏交易市场)】的数据库操作Service
* @createDate 2026-03-27 16:42:09
*/
public interface UserFavoriteMarketService extends IService<UserFavoriteMarket> {

    boolean deleteUserFavoriteMarket(Long id, Long userId);
}
