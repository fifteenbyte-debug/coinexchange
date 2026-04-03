package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【notice(系统资讯公告信息)】的数据库操作Service
* @createDate 2026-03-12 17:29:37
*/
public interface NoticeService extends IService<Notice> {

    Page<Notice> findByPage(Page<Notice> page, String title, String startTime, String endTime, Integer status);

    Page<Notice> findNoticeForSimple(Page<Notice> page);
}
