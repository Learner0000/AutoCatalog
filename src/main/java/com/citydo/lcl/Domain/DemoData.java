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
    private String a;
    @ExcelProperty("信息资源名称\n" +
            "（必填）")
    private String b;
    @ExcelProperty("信息资源摘要\n" +
            "（必填）")
    private String c;
    @ExcelProperty("信息资源格式分类\n" +
            "（必填）")
    private String d;
    @ExcelProperty("信息资源格式类型\n" +
            "（必填）")
    private String e;
    @ExcelProperty("数据存储总量\n" +
            "（选填,单位为M）")
    private String f;
    @ExcelProperty("结构化信息记录总数\n" +
            "（选填）")
    private String g;
    @ExcelProperty("信息资源共享类型\n" +
            "（必填）")
    private String h;
    @ExcelProperty("信息资源共享条件\n" +
            "（选填）")
    private String i;
    @ExcelProperty("信息资源共享方式分类\n" +
            "（必填）")
    private String j;
    @ExcelProperty("信息资源共享方式类型\n" +
            "（必填）")
    private String k;
    @ExcelProperty("信息资源是否向社会开放\n" +
            "（必填）")
    private String l;
    @ExcelProperty("信息资源开放条件\n" +
            "（选填）")
    private String m;
    @ExcelProperty("信息资源更新周期\n" +
            "（必填）")
    private String n;
    @ExcelProperty("具体更新时间（必填）")
    private String o;
    @ExcelProperty("信息资源主题分类\n" +
            "（选填项，多选,用英文,隔开）")
    private String p;
    @ExcelProperty("信息资源重点领域分类\n" +
            "（必填，多选,用英文,隔开）")
    private String q;
    @ExcelProperty("信息资源是否归集数据\n" +
            "（必填）")
    private String r;
    @ExcelProperty("数据归集方式（选填,前项选择为是时必填）")
    private String s;
    @ExcelProperty("字段名称\n" +
            "（必填）")
    private String t;
    @ExcelProperty("字段英文名称\n" +
            "（必填）")
    private String u;
    @ExcelProperty("字段数据类型\n" +
            "（必填）")
    private String v;
    @ExcelProperty("字段数据长度\n" +
            "（选填）")
    private String w;
    @ExcelProperty("字段是否字典项\n" +
            "（选填项）")
    private String x;
    @ExcelProperty("字段是否主键\n" +
            "（必填）")
    private String y;
    @ExcelProperty("字段是否为空\n" +
            "（必填）")
    private String z;
    @ExcelProperty("字段描述\n" +
            "（选填）")
    private String aa;
    @ExcelProperty("对象类型\n" +
            "（选填项）")
    private String ab;
    @ExcelProperty("字段默认值\n" +
            "（选填项）")
    private String ac;
    @ExcelProperty("字段共享类型\n" +
            "（必填）")
    private String ad;
    @ExcelProperty("字段共享条件\n" +
            "（选填项）")
    private String ae;
    @ExcelProperty("字段共享方式分类\n" +
            "（必填）")
    private String af;
    @ExcelProperty("字段共享方式类型\n" +
            "（必填）")
    private String ag;
    @ExcelProperty("字段是否向社会开放\n" +
            "（必填）")
    private String ah;
    @ExcelProperty("字段开放条件\n" +
            "（选填项，前面选择是时填写）")
    private String ai;

}
