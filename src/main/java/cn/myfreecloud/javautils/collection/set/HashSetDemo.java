package cn.myfreecloud.javautils.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet：存储的元素无序，不可重复，底层是哈希表
 * 它存储唯一元素并允许空值
 * 它由HashMap支持
 * 它不保持插入顺序
 * 它不是线程安全的
 */
public class HashSetDemo {
    public static void main(String[] args) {

        // 创建了一个set
        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        // 去重的
        hashset.add("Third");
        // 底层是HashMap(允许null值和null键) 允许null值
        hashset.add(null);


        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if ("Second".equals(element))
                itr.remove();
        }

        Iterator<String> itrResult = hashset.iterator();
        while (itrResult.hasNext()) {
            String element = itrResult.next();
            System.out.println(element);
        }
    }
}
