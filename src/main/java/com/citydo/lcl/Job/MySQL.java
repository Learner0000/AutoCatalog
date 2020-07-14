package com.citydo.lcl.Job;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.citydo.lcl.Domain.DemoData;
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
        repeatedWrite(lists);
    }

    public void repeatedWrite(ArrayList<List> list) {
        // 方法1 如果写到同一个sheet
        String fileName =  "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 需要指定写用哪个class去写
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < list.get(1).size(); i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = data(list,i);
                excelWriter.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

    }

    private List<DemoData> data(ArrayList<List> list, int i) {
        List<MysqlTb> list1 = list.get(1);
        MysqlTb mysqlTb = list1.get(i);


    }
}
