package com.citydo.lcl.Domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 基础数据类
 **/
@Data
public class DemoData {
    @ExcelProperty("信息资源英文名称\n" +
            "（必填）")
    private String A;
    @ExcelProperty("信息资源名称\n" +
            "（必填）")
    private String B;
    @ExcelProperty("信息资源摘要\n" +
            "（必填）")
    private String C;
    @ExcelProperty("信息资源格式分类\n" +
            "（必填）")
    private String D;
    @ExcelProperty("信息资源格式类型\n" +
            "（必填）")
    private String E;
    @ExcelProperty("数据存储总量\n" +
            "（选填,单位为M）")
    private String F;
    @ExcelProperty("结构化信息记录总数\n" +
            "（选填）")
    private String G;
    @ExcelProperty("信息资源共享类型\n" +
            "（必填）")
    private String H;
    @ExcelProperty("信息资源共享条件\n" +
            "（选填）")
    private String I;
    @ExcelProperty("信息资源共享方式分类\n" +
            "（必填）")
    private String J;
    @ExcelProperty("信息资源共享方式类型\n" +
            "（必填）")
    private String K;
    @ExcelProperty("信息资源是否向社会开放\n" +
            "（必填）")
    private String L;
    @ExcelProperty("信息资源开放条件\n" +
            "（选填）")
    private String M;
    @ExcelProperty("信息资源更新周期\n" +
            "（必填）")
    private String N;
    @ExcelProperty("具体更新时间（必填）")
    private String O;
    @ExcelProperty("信息资源主题分类\n" +
            "（选填项，多选,用英文,隔开）")
    private String P;
    @ExcelProperty("信息资源重点领域分类\n" +
            "（必填，多选,用英文,隔开）")
    private String Q;
    @ExcelProperty("信息资源是否归集数据\n" +
            "（必填）")
    private String R;
    @ExcelProperty("数据归集方式（选填,前项选择为是时必填）")
    private String S;
    @ExcelProperty("字段名称\n" +
            "（必填）")
    private String T;
    @ExcelProperty("字段英文名称\n" +
            "（必填）")
    private String U;
    @ExcelProperty("字段数据类型\n" +
            "（必填）")
    private String V;
    @ExcelProperty("字段数据长度\n" +
            "（选填）")
    private String W;
    @ExcelProperty("字段是否字典项\n" +
            "（选填项）")
    private String X;
    @ExcelProperty("字段是否主键\n" +
            "（必填）")
    private String Y;
    @ExcelProperty("字段是否为空\n" +
            "（必填）")
    private String Z;
    @ExcelProperty("字段描述\n" +
            "（选填）")
    private String AA;
    @ExcelProperty("对象类型\n" +
            "（选填项）")
    private String AB;
    @ExcelProperty("字段默认值\n" +
            "（选填项）")
    private String AC;
    @ExcelProperty("字段共享类型\n" +
            "（必填）")
    private String AD;
    @ExcelProperty("字段共享条件\n" +
            "（选填项）")
    private String AE;
    @ExcelProperty("字段共享方式分类\n" +
            "（必填）")
    private String AF;
    @ExcelProperty("字段共享方式类型\n" +
            "（必填）")
    private String AG;
    @ExcelProperty("字段是否向社会开放\n" +
            "（必填）")
    private String AH;
    @ExcelProperty("字段开放条件\n" +
            "（选填项，前面选择是时填写）")
    private String AI;

}
