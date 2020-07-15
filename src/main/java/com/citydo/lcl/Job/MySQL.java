package com.citydo.lcl.Job;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.citydo.lcl.Domain.DemoData;
import com.citydo.lcl.Domain.MysqlTb;
import com.citydo.lcl.Mapper.MysqlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@EnableScheduling
@Order(value = 1)
public class MySQL implements CommandLineRunner {
    private static Logger logger = Logger.getLogger(MySQL.class.getName());
    @Resource
    private MysqlMapper mysqlMapper;

    @Override
    public void run(String... args) throws Exception {
        job();
    }

    public void job() {
        List<MysqlTb> strings = mysqlMapper.selectCatalog("standard_addr");
        logger.info(strings.toString());
        //simpleWrite(strings);
        repeatedWrite(strings);
    }
    public void simpleWrite(List<MysqlTb> strings) {
        // 写法1
        String fileName =  "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("sheet1").doWrite(data(strings));
    }

    public void repeatedWrite(List<MysqlTb> strings) {
        List<String> standard_addr = mysqlMapper.selectTbInfo("standard_addr");
        String fileName =  "mergeWrite" + ".xlsx";
        int i=1;
        ExcelWriterBuilder write = EasyExcel.write(fileName, DemoData.class);
        for (String TbName : standard_addr) {
                List<MysqlTb> standard_addr1 = mysqlMapper.selectSchemaInfo("standard_addr", TbName);
                OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy = new OnceAbsoluteMergeStrategy(i, i+standard_addr1.size()-1, 0, 0);
                write.registerWriteHandler(onceAbsoluteMergeStrategy);
                i=i+standard_addr1.size();
            }
        write.sheet("").doWrite(data(strings));
    }



    private List<DemoData> data(List<MysqlTb> list) {
        List<DemoData> list1 = new ArrayList<>();
        for (MysqlTb mysqlTb : list) {
            DemoData demoData = new DemoData();
            demoData.setA(mysqlTb.getTbName());
            demoData.setB(mysqlTb.getTbDesc());
            demoData.setC(mysqlTb.getTbDesc());
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
            demoData.setT(mysqlTb.getSchemaDesc());
            demoData.setU(mysqlTb.getSchema());
            demoData.setV("VARCHAR");
            demoData.setW("50");
            demoData.setX("");
            demoData.setY("否");
            demoData.setZ("是");
            demoData.setAa("");
            demoData.setAb("");
            demoData.setAc("");
            demoData.setAd("无条件共享");
            demoData.setAe("");
            demoData.setAf("共享平台");
            demoData.setAg("数据库");
            demoData.setAh("是");
            demoData.setAi("");
            list1.add(demoData);
        }
        logger.info(list1.toString());
        return list1;
    }


}
