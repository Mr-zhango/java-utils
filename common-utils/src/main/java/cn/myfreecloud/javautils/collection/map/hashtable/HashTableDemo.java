package cn.myfreecloud.javautils.collection.map.hashtable;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {

        // 线程安全的，性能低 不支持null值和null键
        Hashtable hashtable = new Hashtable();

        hashtable.put("555", 555);
        hashtable.put("444", 444);
        hashtable.put("333", 333);
        hashtable.put("222", 222);
        hashtable.put("111", 111);
        hashtable.put("111", 111);


        hashtable.put(null, null);

    }
}
