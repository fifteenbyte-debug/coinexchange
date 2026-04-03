package com.fifteen.service;

import com.fifteen.domain.UserAuthAuditRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author msc
* @description 针对表【user_auth_audit_record(实名认证审核信息)】的数据库操作Service
* @createDate 2026-03-17 17:38:19
*/
public interface UserAuthAuditRecordService extends IService<UserAuthAuditRecord> {

    List<UserAuthAuditRecord> getUserAuthAuditRecordList(Long id);
}
