package cn.myfreecloud.javautils.date;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMapUtils {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("1","1");
        hashMap.put("2","2");
        hashMap.put("3","3");
        hashMap.put("1","2");

        for (String key : hashMap.keySet()) {
            System.out.println(key + hashMap.get(key));
        }

        System.out.println("********************************");
        Set<String> hasSet = new HashSet<>();
        hasSet.add("zhangsan");
        hasSet.add("lisi");
        hasSet.add("wangwu");
        hasSet.add("zhangsan");

        for (String setValue : hasSet) {
            System.out.println(setValue);
        }

    }
}
