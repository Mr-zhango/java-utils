package cn.myfreecloud.javautils.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * LinkedHashSet：存储的元素有序，不可重复，底层是哈希表和链表
 * inkedHashSet存储结构是一个双向链表，因此它存储的元素是有序的。
 * <p>
 * LinkedHashSet继承自HashSet，源码更少、更简单，唯一的区别是LinkedHashSet内部使用的是LinkHashMap。
 * 这样做的意义或者好处就是LinkedHashSet中的元素顺序是可以保证的，也就是说遍历序和插入序是一致的。
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            linkedHashSet.add("I" + i);
            hashSet.add("I" + i);
        }

        System.out.println("linkedHashSet遍历：");
        for (String string : linkedHashSet) {
            System.out.print(string + " ");
        }
        System.out.println();

        System.out.println("hashSet遍历：");
        for (String string : hashSet) {
            System.out.print(string + " ");
        }
    }
}
