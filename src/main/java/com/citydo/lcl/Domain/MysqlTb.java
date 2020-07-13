package com.citydo.lcl.Domain;

public class MysqlTb {
    private String tbName;
    private String tbDesc;
    private String schema;
    private String schemaDesc;

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getTbDesc() {
        return tbDesc;
    }

    public void setTbDesc(String tbDesc) {
        this.tbDesc = tbDesc;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getSchemaDesc() {
        return schemaDesc;
    }

    public void setSchemaDesc(String schemaDesc) {
        this.schemaDesc = schemaDesc;
    }

    @Override
    public String toString() {
        return "MysqlTb{" +
                "tbName='" + tbName + '\'' +
                ", tbDesc='" + tbDesc + '\'' +
                ", schema='" + schema + '\'' +
                ", schemaDesc='" + schemaDesc + '\'' +
                '}';
    }
}
