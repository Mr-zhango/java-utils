package cn.myfreecloud.javautils.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyang2.zhang
 * @since 2021-11-22
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("111,222");
        stringList.add("333,222");


        ArrayList<String> arrayList = new ArrayList();

        for (String s : stringList) {
            arrayList.addAll(Arrays.asList(s.split(",")));
        }

        String collect1 = arrayList.stream().collect(Collectors.joining("','"));
        System.out.println(collect1);
    }
}
