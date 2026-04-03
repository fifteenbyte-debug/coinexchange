package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.Notice;
import com.fifteen.service.NoticeService;
import com.fifteen.mapper.NoticeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author msc
 * @description 针对表【notice(系统资讯公告信息)】的数据库操作Service实现
 * @createDate 2026-03-12 17:29:37
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
        implements NoticeService {

    @Override
    public Page<Notice> findByPage(Page<Notice> page, String title, String startTime, String endTime, Integer status) {
        Page<Notice> pageData = page(page, new LambdaQueryWrapper<Notice>()
                .like(StringUtils.isNotBlank(title), Notice::getTitle, title)
                .ge(StringUtils.isNotBlank(startTime), Notice::getCreated, startTime)
                .le(StringUtils.isNotBlank(endTime), Notice::getCreated, endTime + " 23:59:59")
                .eq(status != null, Notice::getStatus, status)
        );
        return pageData;
    }

    /**
     * 查询公告
     *
     * @param page
     * @return
     */
    @Override
    public Page<Notice> findNoticeForSimple(Page<Notice> page) {
        return page(page, new LambdaQueryWrapper<Notice>()
                .eq(Notice::getStatus, 1)
                .orderByAsc(Notice::getSort)
        );
    }
}




