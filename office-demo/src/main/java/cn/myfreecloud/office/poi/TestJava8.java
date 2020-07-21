package cn.myfreecloud.office.poi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> collect = list1.stream().map(a -> a + "/str").collect(Collectors.toList());


        collect.forEach(System.out::println);
    }
}
