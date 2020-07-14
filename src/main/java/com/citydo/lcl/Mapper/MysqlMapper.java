package com.citydo.lcl.Mapper;

import com.citydo.lcl.Domain.MysqlTb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MysqlMapper {
    @Select("SELECT distinct T.TABLE_NAME  AS  tbName " +
            "FROM information_schema.`TABLES` as T " +
            "LEFT  JOIN  information_schema.`COLUMNS` as C  " +
            "ON  T.TABLE_NAME  =  C.TABLE_NAME AND  " +
            "T.TABLE_SCHEMA  =  C.TABLE_SCHEMA WHERE       " +
            " T.TABLE_SCHEMA  =  #{DBName}  ;")
     List<String> selectTbInfo(String DBName);

    @Select("SELECT T.TABLE_NAME  AS  tbName," +
            "T.TABLE_COMMENT  AS  tbDesc," +
            "C.COLUMN_NAME  AS  `schema`," +
            "C.COLUMN_COMMENT  AS  schemaDesc " +
            "FROM information_schema.`TABLES` as T " +
            "LEFT  JOIN  information_schema.`COLUMNS` as  C  " +
            "ON  T.TABLE_NAME  =  C.TABLE_NAME AND  " +
            "T.TABLE_SCHEMA  =  C.TABLE_SCHEMA WHERE  " +
            "T.TABLE_SCHEMA  =  #{DBName}  AND T.TABLE_NAME=#{TbName};")
     List<MysqlTb> selectSchemaInfo(String DBName, String TbName);

    @Select("SELECT T.TABLE_NAME  AS  tbName," +
            "T.TABLE_COMMENT  AS  tbDesc," +
            "C.COLUMN_NAME  AS  `schema`," +
            "C.COLUMN_COMMENT  AS  schemaDesc " +
            "FROM information_schema.`TABLES` as T " +
            "LEFT  JOIN  information_schema.`COLUMNS` as  C  " +
            "ON  T.TABLE_NAME  =  C.TABLE_NAME AND  " +
            "T.TABLE_SCHEMA  =  C.TABLE_SCHEMA WHERE  " +
            "T.TABLE_SCHEMA  =  #{DBName}  ;")
    List<MysqlTb> selectCatalog(String DBName);
}
