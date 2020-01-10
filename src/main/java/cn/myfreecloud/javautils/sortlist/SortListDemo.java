package cn.myfreecloud.javautils.sortlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
class Student {
    String id;
    String year;
    String star;
    Integer order;
}

public class SortListDemo {
    public static void main(String[] args) {

        List<Student> codeSetList = new ArrayList<>();

        codeSetList.add(new Student("1", "2", "3", 1));
        codeSetList.add(new Student("2", "2", "3", null));
        codeSetList.add(new Student("3", "2", "3", 2));
        codeSetList.add(new Student("3", "2", "3", 2));
        codeSetList.add(new Student("4", "2", "3", null));

        /**
         * 针对排序字段可能为空的数据进行自定义排序
         */
        Collections.sort(codeSetList, (o1, o2) -> {
            if (o1.getOrder() != null && o2.getOrder() != null) {
                int diff = o1.getOrder() - o2.getOrder();
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (o1.getOrder() == null && o2.getOrder() == null) {
                return 0;
            } else if (o1.getOrder() != null) {
                return -1;
            } else {
                return 1;
            }
        });

        for (Student student : codeSetList) {
            System.out.println(student.toString());
        }


        /**
         * 多字段排序
         */
        List<Student> codeSetListTwo = new ArrayList<>();

        codeSetListTwo.add(new Student("1", "2020", "1", 1));
        codeSetListTwo.add(new Student("2", "2020", "2", null));
        codeSetListTwo.add(new Student("3", "2020", "3", 2));
        codeSetListTwo.add(new Student("4", "2019", "3", null));
        codeSetListTwo.add(new Student("3", "2019", "2", 2));
        codeSetListTwo.add(new Student("2", "2018", "1", 2));

        codeSetListTwo.sort(Comparator.comparing(Student::getYear, Comparator.reverseOrder()).thenComparing(Student::getStar));

        for (Student student : codeSetListTwo) {
            System.out.println(student.toString());
        }

    }
}

