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
        List<MysqlTb> strings = mysqlMapper.selectCatalog("standard_addr");
        logger.info(strings.toString());
        repeatedWrite(strings);
    }

    public void repeatedWrite(List<MysqlTb> list) {
        // 方法1 如果写到同一个sheet
        String fileName =  "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 需要指定写用哪个class去写
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            //for (int i = 0; i < list.size(); i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据，这里我无需分页查询
                List<DemoData> data = data(list);
                excelWriter.write(data, writeSheet);
            //}
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

    }

    private List<DemoData> data(List<MysqlTb> list) {
        List<DemoData> list1 = new ArrayList<>();
        Iterator<MysqlTb> iterator = list.iterator();
        while (iterator.hasNext()){
            DemoData demoData = new DemoData();
            MysqlTb next = iterator.next();
            demoData.setA(next.getTbName());
            demoData.setB(next.getTbDesc());
            demoData.setC(next.getTbDesc());
            demoData.setD("数据库");
            demoData.setE("MySQL");
            demoData.setF("");
            demoData.setG("");
            demoData.setH("有条件共享");
            demoData.setI("");
            demoData.setJ("共享平台");
            demoData.setK("数据库");
            demoData.setL("否");
            demoData.setM("");
            demoData.setN("每天");
            demoData.setO("每天上午");
            demoData.setP("");
            demoData.setQ("民生服务");
            demoData.setR("是");
            demoData.setS("共享交换");
            demoData.setT(next.getSchemaDesc());
            demoData.setU(next.getSchema());
            demoData.setV("VARCHAR");
            demoData.setW("50");
            demoData.setX("");
            demoData.setY("否");
            demoData.setZ("是");
            demoData.setAA("");
            demoData.setAB("");
            demoData.setAC("");
            demoData.setAD("无条件共享");
            demoData.setAE("");
            demoData.setAF("共享平台");
            demoData.setAG("数据库");
            demoData.setAH("是");
            demoData.setAI("");
            list1.add(demoData);
        }
        return list1;
    }
}
