package com.citydo.lcl.Job;


import com.citydo.lcl.Domain.MysqlTb;
import com.citydo.lcl.Mapper.MysqlMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Component
@EnableScheduling
public class MySQL {
    private static Logger logger = Logger.getLogger(MySQL.class.getName());
    @Resource
    private MysqlMapper mysqlMapper;

    @Scheduled(cron = "${MySQLTimer}")
    public void job() {
        List<String> strings = mysqlMapper.selectTbInfo("standard_addr");
        logger.info(strings.toString());
        Iterator<String> iterator = strings.iterator();
        ArrayList<List> lists = new ArrayList<>();
        while (iterator.hasNext()){
            String next = iterator.next();
            logger.info(next);
            List<MysqlTb> standard_addr = mysqlMapper.selectSchemaInfo( "standard_addr",next);
            logger.info(standard_addr.toString());
            lists.add(standard_addr);
        }
        //logger.info(lists.toString());
    }
}
