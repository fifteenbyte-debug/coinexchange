package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.WorkIssue;
import com.fifteen.dto.UserDto;
import com.fifteen.feign.UserServiceFeign;
import com.fifteen.service.WorkIssueService;
import com.fifteen.mapper.WorkIssueMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author msc
 * @description 针对表【work_issue(工单记录)】的数据库操作Service实现
 * @createDate 2026-03-12 17:30:17
 */
@Service
@Slf4j
public class WorkIssueServiceImpl extends ServiceImpl<WorkIssueMapper, WorkIssue>
        implements WorkIssueService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    public Page<WorkIssue> findByPage(Page<WorkIssue> page, Integer status, String startTime, String endTime) {
        Page<WorkIssue> pageData = page(page, new LambdaQueryWrapper<WorkIssue>()
                .like(status != null, WorkIssue::getStatus, status)
                .ge(StringUtils.isNotBlank(startTime), WorkIssue::getCreated, startTime)
                .le(StringUtils.isNotBlank(endTime), WorkIssue::getCreated, endTime + " 23:59:59")
        );
        List<WorkIssue> records = pageData.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return pageData;
        }
        List<Long> userIds = records.stream().map(WorkIssue::getUserId).collect(Collectors.toList());
        Map<Long, UserDto> basicUsers = userServiceFeign.getBasicUsers(userIds, null, null);

        records.forEach(workIssue -> {
            UserDto userDto = basicUsers.get(workIssue.getUserId());
            if (userDto != null) {
                workIssue.setUsername(userDto.getUsername());
                workIssue.setRealName(userDto.getRealName());
            } else {
                log.info("用户不存在：{}", workIssue.getUserId());
            }
        });
        return pageData;
    }

    @Override
    public Page<WorkIssue> getIssueList(Page<WorkIssue> page, Long userId) {
        Page<WorkIssue> pageData = page(page, new LambdaQueryWrapper<WorkIssue>()
                .eq(WorkIssue::getUserId, userId)
                .orderByAsc(WorkIssue::getStatus));
        return pageData;
    }
}




