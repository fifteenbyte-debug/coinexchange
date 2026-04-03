package com.fifteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.WorkIssue;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author msc
* @description 针对表【work_issue(工单记录)】的数据库操作Service
* @createDate 2026-03-12 17:30:17
*/
public interface WorkIssueService extends IService<WorkIssue> {

    Page<WorkIssue> findByPage(Page<WorkIssue> page, Integer status, String startTime, String endTime);

    Page<WorkIssue> getIssueList(Page<WorkIssue> page, Long aLong);
}
