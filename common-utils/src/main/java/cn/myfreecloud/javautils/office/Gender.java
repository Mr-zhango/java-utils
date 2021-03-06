package cn.myfreecloud.javautils.office;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 用户性别
 */
public enum Gender {


    // 永远不要用 0 作为有意义的值, 因为你永远不知道这个值是用户设置的还是系统默认的.
    UNKNOWN(0, "未知"),
    MALE(1 << 0, "男"),
    FEMALE(1 << 1, "女");

    public final int value;
    public final String desc;

    Gender(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonCreator
    public static Gender of(int value) {
        for (Gender val : Gender.values()) {
            if (val.value == value) {
                return val;
            }
        }
        return UNKNOWN;
    }

    @JsonValue
    public int value() {
        return value;
    }

}
