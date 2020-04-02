package cn.myfreecloud.javautils.collection.map.treemap;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {

        TreeMap hashMap = new TreeMap();

        // 能够按照键值进行排序，默认是升序排列
        hashMap.put("555", 555);
        hashMap.put("444", 444);
        hashMap.put("333", 333);
        hashMap.put("222", 222);
        hashMap.put("111", 111);
        hashMap.put("111", 111);


        // JDK8的迭代方式
        hashMap.forEach((key, value) -> System.out.println(key + "：" + value));

    }
}
