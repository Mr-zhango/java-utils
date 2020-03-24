package cn.myfreecloud.javautils.sortlist;


@FunctionalInterface
public interface ParseIntFunc {

    void parseintForSOrt(String string);

    // 默认方法
    public default Integer defaultMethod(String string){
        return Integer.parseInt(string);
    }
}
