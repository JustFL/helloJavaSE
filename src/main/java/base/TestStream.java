package base;

import java.util.stream.IntStream;

/**
 * 这个流不是文件读取的那个流
 * 是用来做一次性的 临时性的统计的
 * @author summerKiss
 *
 */
public class TestStream {
    public static void main(String[] args) {

        //创建一个流
        IntStream is1 = IntStream.builder().add(10).add(40).add(27).build();
        //末端方法 使用完后 流就被释放掉了 (聚集方法都是末端方法)
        /*
         * max()
         * min()
         * sum()
         * average()
         * count()
         */

        //使用完 流被释放
        System.out.println(is1.max().getAsInt());

        //再次使用 要重新创建
        IntStream is2 = IntStream.builder().add(10).add(40).add(27).build();
        //使用过滤器 测试是否所有元素满足条件
        boolean allMatch = is2.allMatch(value->value>0&&value<100);
        System.out.println(allMatch);

        IntStream is3 = IntStream.builder().add(10).add(40).add(27).build();
        //使用过滤器 测试是否有某个元素满足条件
        boolean anyMatch = is3.anyMatch(value -> value > 20);
        System.out.println(anyMatch);

        IntStream is4 = IntStream.builder().add(10).add(40).add(27).build();
        //中间方法 调用完会返回另外一个流
        is4.filter(value -> value > 20).forEach(System.out::println);


    }
}
