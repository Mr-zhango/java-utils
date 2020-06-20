package cn.myfreecloud.javautils.collection.list.arraylist;


import java.util.ArrayList;

public class ArrayLisyDemo {
    public static void main(String[] args) {
        ArrayList<String> lList = new ArrayList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");

        System.out.println("数组的第一个元素是 : " + lList.get(0));
        System.out.println("数组最后一个元素是 : " + lList.get(lList.size()-1));

        for (String s : lList) {
            System.out.println(s);
        }
    }
}
