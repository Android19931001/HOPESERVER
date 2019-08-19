package entity;

public class GenEntity {

    private String columName;
    private String columnChName;
    private String typeCode;
    private String remark;

    public GenEntity(String columName, String columnChName, String typeCode, String remark) {
        this.columName = columName;
        this.typeCode = typeCode;
        this.remark = remark;
        this.columnChName = columnChName;
    }

    public String getColumnChName() {
        return columnChName;
    }

    public void setColumnChName(String columnChName) {
        this.columnChName = columnChName;
    }

    public String getColumName() {
        return columName;
    }

    public void setColumName(String columName) {
        this.columName = columName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
