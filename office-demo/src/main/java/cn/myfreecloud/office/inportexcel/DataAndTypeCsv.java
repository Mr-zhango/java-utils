package cn.myfreecloud.office.inportexcel;

import com.opencsv.bean.CsvBindByName;

public class DataAndTypeCsv {
    /**
     * 字典代码
     */
    @CsvBindByName(column = "code")
    private String code;

    /**
     * 简写
     */
    @CsvBindByName(column = "short_name")
    private String shortName;

    /**
     * 名称
     */
    @CsvBindByName(column = "name", required = true)  //是否可以为null 否
    private String name;

    /**
     * 拼音或英文描述
     */
    @CsvBindByName(column = "remark")
    private String remark;

    /**
     * 父类型id
     */
    @CsvBindByName(column = "parent_id")
    private String parentId;

    /**
     * 类型名称
     */
    @CsvBindByName(column = "type_name", required = true)  //是否可以为null 否
    private String typeName;

    /**
     * 类型id
     */
    @CsvBindByName(column = "type_id", required = true)  //是否可以为null 否
    private String typeId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
