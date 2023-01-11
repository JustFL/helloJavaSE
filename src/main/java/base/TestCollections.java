package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合操作的工具类 范围是所有的collection类型的集合
 *
 * */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //向集合中一次性添加多个元素
        Collections.addAll(list, "aa","cc","bb","aa");
        list.forEach(System.out::println);

        System.out.println("------使用比较器进行降序-------");
        Collections.sort(list, (t1,t2)->t2.compareTo(t1));
        list.forEach(System.out::println);

        System.out.println("------自然排序后-------");
        Collections.sort(list);
        list.forEach(System.out::println);

        System.out.println("------二分查找元素在集合中的位置 必须先进行自然升序排序！！！-------");
        System.out.println(Collections.binarySearch(list, "aa"));

        System.out.println("---------查找集合中的最小元素--------------");
        System.out.println(Collections.min(list));

        System.out.println("---------查找集合中的最大元素--------------");
        System.out.println(Collections.max(list));

        System.out.println("---------查找集合中元素的出现次数--------------");
        System.out.println(Collections.frequency(list, "aa"));

        System.out.println("------------反转集合中所有的元素---------");
        Collections.reverse(list);
        list.forEach(System.out::println);

        System.out.println("-------填充元素---------");
        Collections.fill(list, "Hello");
        list.forEach(System.out::println);
    }

}
