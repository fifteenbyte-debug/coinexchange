package com.fifteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fifteen.domain.TurnoverRecord;
import com.fifteen.service.TurnoverRecordService;
import com.fifteen.mapper.TurnoverRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author msc
* @description 针对表【turnover_record(成交数据)】的数据库操作Service实现
* @createDate 2026-03-26 17:43:15
*/
@Service
public class TurnoverRecordServiceImpl extends ServiceImpl<TurnoverRecordMapper, TurnoverRecord>
    implements TurnoverRecordService{

}




