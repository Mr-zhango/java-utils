package cn.myfreecloud.javautils.collection.map.linkedhashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        LinkedHashMap hashMap = new LinkedHashMap();

        // 记录了插入的顺序
        hashMap.put("555", 555);
        hashMap.put("444", 444);


        hashMap.put("111", 111);
        hashMap.put("111", 111);

        hashMap.put("333", 333);
        hashMap.put("222", 222);


        // JDK8的迭代方式
        hashMap.forEach((key, value) -> System.out.println(key + "：" + value));
    }
}
