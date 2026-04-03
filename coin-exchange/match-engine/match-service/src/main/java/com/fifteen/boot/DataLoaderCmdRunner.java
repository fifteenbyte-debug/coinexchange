package com.fifteen.boot;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fifteen.disruptor.DisruptorTemplate;
import com.fifteen.domain.EntrustOrder;
import com.fifteen.mapper.EntrustOrderMapper;
import com.fifteen.util.BeanUtils;
import org.apache.commons.lang.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoaderCmdRunner implements CommandLineRunner {


    @Autowired
    private EntrustOrderMapper entrustOrderMapper ;

    @Autowired
    private DisruptorTemplate disruptorTemplate ;
    /**
     * 项目启动完毕后会执行该方法
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        List<EntrustOrder> entrustOrders = entrustOrderMapper.selectList(
                new LambdaQueryWrapper<EntrustOrder>()
                        .eq(EntrustOrder::getStatus, 0)
                        .orderByAsc(EntrustOrder::getCreated)
        );
        if(CollectionUtil.isEmpty(entrustOrders)){
            return;
        }
        StopWatch stopWatch = new StopWatch() ;
        for (EntrustOrder entrustOrder : entrustOrders) {
            disruptorTemplate.onData(BeanUtils.entrustOrder2Order(entrustOrder));
        }
    }


}
