package com.citydo.lcl.unit;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.citydo.lcl.Domain.DemoData;

import java.util.List;

public class MyExcelWriter {
    public void mergeWrite() {

        /**
         * 合并单元格
         * <p>
         * 1. 创建excel对应的实体对象 参照{@link DemoData} {@link DemoMergeData}
         * <p>
         * 2. 创建一个merge策略 并注册
         * <p>
         * 3. 直接写即可
         *
         * @since 2.2.0-beta1
         */
        // 方法1 注解
        String fileName =  "mergeWrite" + System.currentTimeMillis() + ".xlsx";
        // 在DemoStyleData里面加上ContentLoopMerge注解
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        //EasyExcel.write(fileName, DemoMergeData.class).sheet("模板").doWrite(data());

        // 方法2 自定义合并单元格策略
        fileName = "mergeWrite" + System.currentTimeMillis() + ".xlsx";
        // 每隔2行会合并 把eachColumn 设置成 3 也就是我们数据的长度，所以就第一列会合并。当然其他合并策略也可以自己写
        LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        //EasyExcel.write(fileName, DemoData.class).registerWriteHandler(loopMergeStrategy).sheet("模板").doWrite(data());
    }
    /**
     * 重复多次写入
     * <p>
     * 1. 创建excel对应的实体对象 参照@link ComplexHeadData
     * <p>
     * 2. 使用@link ExcelProperty注解指定复杂的头
     * <p>
     * 3. 直接调用二次写入即可
     */

    public void repeatedWrite() {
        // 方法1 如果写到同一个sheet
        String fileName =  "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 需要指定写用哪个class去写
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                //List<DemoData> data = data();
                //excelWriter.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

    }

}
