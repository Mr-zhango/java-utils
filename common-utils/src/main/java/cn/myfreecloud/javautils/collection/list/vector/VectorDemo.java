package cn.myfreecloud.javautils.collection.list.vector;

import java.util.Vector;

/**
 * 线程安全的，性能低
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        vector.add("5");


        System.out.println("Vector 的第一个元素是 : " + vector.firstElement());
        System.out.println("Vector 最后一个元素是 : " + vector.lastElement());
    }
}
