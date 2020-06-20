package cn.myfreecloud.javautils.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorRemoveTest {
    public static void main(String[] args) {
        String lockKey = "123456";

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("3".equals(item)) {
                iterator.remove();
            }
        }


        for (String item : list) {
            if ("4".equals(item)) {
                list.remove(item);
            }
        }

        list.forEach(System.out::println);

    }
}
