package cn.myfreecloud.javautils.sortlist;

import java.util.*;


public class HashMapSort {

    public static void main(String[] args) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        hashMap.put(1, new User("张三", 31));
        hashMap.put(2, new User("张四", 33));
        hashMap.put(3, new User("王五", 32));

        System.out.println(hashMap);
        //調用sortHashMap()排序并返回新的集合
        HashMap<Integer, User> sort = sortHashMap(hashMap);

        System.out.println(sort);
    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {

        Set<Map.Entry<Integer, User>> entey = map.entrySet();

        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entey);

        Collections.sort(list, (o1, o2) -> {
            //按照age倒叙排列
            return o2.getValue().getAge() - o1.getValue().getAge();
        });

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();

        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
