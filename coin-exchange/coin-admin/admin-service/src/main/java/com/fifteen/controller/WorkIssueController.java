package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.WorkIssue;
import com.fifteen.model.R;
import com.fifteen.service.WorkIssueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/workIssues")
@Api("工单管理")
public class WorkIssueController {

    @Autowired
    private WorkIssueService workIssueService;

    @GetMapping
    @ApiOperation("分页查询工单")
    @PreAuthorize("hasAnyAuthority('work_issue_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "工单状态"),
            @ApiImplicitParam(name = "startTime", value = "开始时间"),
            @ApiImplicitParam(name = "endTime", value = "结束时间"),
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页大小"),
    })
    public R<Page<WorkIssue>> findByPage(@ApiIgnore Page<WorkIssue> page, Integer status, String startTime, String endTime) {
        page.addOrder(OrderItem.desc("last_update_time"));
        Page<WorkIssue> workIssuePage = workIssueService.findByPage(page, status, startTime, endTime);
        return R.ok(workIssuePage);
    }

    @PatchMapping
    @ApiOperation("回复某个工单")
    @PreAuthorize("hasAnyAuthority('work_issue_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "工单ID"),
            @ApiImplicitParam(name = "answer", value = "回复内容"),
    })
    public R<String> updateAnswer(Long id, String answer) {
        WorkIssue workIssue = new WorkIssue();
        workIssue.setAnswer(answer);
        workIssue.setId(id);
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        workIssue.setAnswerUserId(Long.valueOf(userIdStr));
        workIssue.setStatus(2);
        workIssue.setAnswerName("客服中心");
        boolean b = workIssueService.updateById(workIssue);
        if (!b) {
            return R.fail("回复失败");
        }
        return R.ok("回复成功");
    }

    @GetMapping("/issueList")
    @ApiOperation(value = "前台查询工单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页"),
            @ApiImplicitParam(name = "size" ,value = "显示的条数")
    })
    public R<Page<WorkIssue>> getIssueList(@ApiIgnore Page<WorkIssue> page){
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Page<WorkIssue> pageData =  workIssueService.getIssueList(page,Long.valueOf(userIdStr)) ;
        return R.ok(pageData) ;
    }

    @PostMapping("/addWorkIssue")
    @ApiOperation(value = "会员添加问题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workIssue" , value = "workIssue的json,只包含questions")
    })
    public R addWorkIssue(@RequestBody WorkIssue workIssue){
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        workIssue.setUserId(Long.valueOf(userIdStr)); // 设置用户的Id
        workIssue.setStatus(1); // 设置状态
        boolean save = workIssueService.save(workIssue);
        if(save){
            return R.ok("提交成功") ;
        }
        return R.fail("提交失败") ;
    }


}
