package com.fifteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.UserAuthAuditRecord;
import com.fifteen.service.UserAuthAuditRecordService;
import com.fifteen.mapper.UserAuthAuditRecordMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author msc
 * @description 针对表【user_auth_audit_record(实名认证审核信息)】的数据库操作Service实现
 * @createDate 2026-03-17 17:38:19
 */
@Service
public class UserAuthAuditRecordServiceImpl extends ServiceImpl<UserAuthAuditRecordMapper, UserAuthAuditRecord>
        implements UserAuthAuditRecordService {

    @Override
    public List<UserAuthAuditRecord> getUserAuthAuditRecordList(Long id) {
        return list(new LambdaQueryWrapper<UserAuthAuditRecord>().eq(UserAuthAuditRecord::getUserId, id)
                .orderByDesc(UserAuthAuditRecord::getCreated)
                .last("limit 3"));
    }
}




