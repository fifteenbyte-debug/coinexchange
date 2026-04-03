package com.fifteen.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fifteen.domain.Notice;
import com.fifteen.model.R;
import com.fifteen.service.NoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;

@RestController
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    @ApiOperation("分页查询公告")
    @PreAuthorize("hasAnyAuthority('notice_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页数量"),
            @ApiImplicitParam(name = "title", value = "公告的标题"),
            @ApiImplicitParam(name = "startTime", value = "开始时间"),
            @ApiImplicitParam(name = "endTime", value = "结束时间"),
            @ApiImplicitParam(name = "status", value = "状态")
    })
    public R<Page<Notice>> findByPage(@ApiIgnore Page<Notice> page, String title, String startTime, String endTime, Integer status) {
        page.addOrder(OrderItem.desc("last_update_time"));
        return R.ok(noticeService.findByPage(page, title, startTime, endTime, status));
    }

    @PostMapping("/delete")
    @ApiOperation("删除公告")
    @PreAuthorize("hasAnyAuthority('notice_delete')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "公告的id列表")
    })
    public R delete(@RequestBody String[] ids) {
        return noticeService.removeByIds(Arrays.asList(ids)) ? R.ok() : R.fail("删除失败");
    }

    @PostMapping("/updateStatus")
    @ApiOperation("更新公告状态")
    @PreAuthorize("hasAnyAuthority('notice_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公告的id"),
            @ApiImplicitParam(name = "status", value = "公告的状态")
    })
    public R updateStatus(Long id, Integer status) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setStatus(status);
        return noticeService.updateById(notice) ? R.ok("修改成功") : R.fail("更新失败");
    }

    @PostMapping
    @ApiOperation("添加公告")
    @PreAuthorize("hasAnyAuthority('notice_create')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "notice", value = "notice的json数据")
    })
    public R add(@RequestBody @Validated Notice notice) {
        notice.setStatus(1);
        boolean save = noticeService.save(notice);
        return save ? R.ok("添加公告成功") : R.fail("添加公告失败");
    }


    @PatchMapping
    @ApiOperation("修改公告")
    @PreAuthorize("hasAnyAuthority('notice_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "notice", value = "notice的json数据")
    })
    public R update(@RequestBody @Validated Notice notice) {
        boolean update = noticeService.updateById(notice);
        return update ? R.ok("修改公告成功") : R.fail("修改公告失败");
    }

    /**
     * simple 就是给用户/会员看的
     */
    @GetMapping("/simple")
    @ApiOperation(value = "查询前台展示的notice")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数")
    })
    public R<Page<Notice>> findNoticeForSimple(Page<Notice> page) {
        Page<Notice> pageData = noticeService.findNoticeForSimple(page);
        return R.ok(pageData);
    }


    @GetMapping("/simple/{id}")
    @ApiOperation(value = "查询某条Notice的详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "notice的id")
    })
    public R<Notice> noticeSimpleInfo(@PathVariable("id") Long id) {
        Notice notice = noticeService.getById(id);
        return R.ok(notice);
    }
}
