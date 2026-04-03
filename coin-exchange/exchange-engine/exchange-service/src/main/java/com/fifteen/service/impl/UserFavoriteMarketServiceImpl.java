package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.UserFavoriteMarket;
import com.fifteen.service.UserFavoriteMarketService;
import com.fifteen.mapper.UserFavoriteMarketMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【user_favorite_market(用户收藏交易市场)】的数据库操作Service实现
* @createDate 2026-03-27 16:42:09
*/
@Service
public class UserFavoriteMarketServiceImpl extends ServiceImpl<UserFavoriteMarketMapper, UserFavoriteMarket>
    implements UserFavoriteMarketService{

    /**
     * 用户取消收藏
     *
     * @param marketId // 交易市场的id
     * @param userId // 用户的Id
     * @return
     */
    @Override
    public boolean deleteUserFavoriteMarket(Long marketId, Long userId) {
        return remove(new LambdaQueryWrapper<UserFavoriteMarket>()
                .eq(UserFavoriteMarket::getMarketId, marketId)
                .eq(UserFavoriteMarket::getUserId, userId)
        );
    }
}




