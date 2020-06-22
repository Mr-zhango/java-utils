package cn.myfreecloud.javautils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Test01 {

    @Test
    public void test1() {


        ArrayList<Integer> stringArrayList = new ArrayList<>();
        stringArrayList.add(1);
        stringArrayList.add(2);
        stringArrayList.add(3);


        List<Integer> integers = stringArrayList.subList(0, 3);

        System.out.println(stringArrayList.size());

        System.out.println("-------------");

        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }
}
