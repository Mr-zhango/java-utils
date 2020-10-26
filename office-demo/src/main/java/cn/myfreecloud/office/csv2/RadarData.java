package cn.myfreecloud.office.csv2;

public class RadarData {
    private String code;
    private String short_name;
    private String name;
    private String remark;
    private String parent_id;
    private String type_name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
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

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "RadarData{" +
                "code='" + code + '\'' +
                ", short_name='" + short_name + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
