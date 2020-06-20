package cn.myfreecloud.javautils.collection.map.hashmap;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();

        // 无序
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
