package cn.myfreecloud.javautils.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 【推荐】使用 entrySet 遍历 Map 类集合 KV ，而不是 keySet 方式进行遍历。
 * 说明： keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出 key 所对应的 value 。而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效率更高。如果是 JDK 8，使用 Map . foreach 方法。
 * <p>
 * 正例： values() 返回的是 V 值集合，是一个 list 集合对象 ；keySet() 返回的是 K 值集合，是
 * 一个 Set 集合对象 ；entrySet() 返回的是 K - V 值组合集合。
 */
public class IteratorHashMapDemo {
    public static void main(String[] args) {

        // jdk1.7 方法

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");

        //第一种：普通使用，二次取值(性能差)
        System.out.println("通过Map.keySet遍历key和value：");

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + " Value: " + map.get(key));
        }

        //第二种(性能比第一种好，一次取值)
        System.out.println("通过Map.entrySet使用iterator遍历key和value: ");
        Iterator map1it = map.entrySet().iterator();
        while (map1it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) map1it.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }


        //第四种 单纯获取map的值的时候使用的方法。
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("The value is " + v);
        }

        System.out.println("#######################################");
        // jdk1.8 方法

        // 创建一个Map
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("name", "Zebe");
        infoMap.put("site", "www.zebe.me");
        infoMap.put("email", "zebe@vip.qq.com");
        // 传统的Map迭代方式
        for (Map.Entry<String, Object> entry : infoMap.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }

        System.out.println("6666666666666666666666666666666666");

        // JDK8的迭代方式
        infoMap.forEach((key, value) -> System.out.println(key + "：" + value));

    }

}
