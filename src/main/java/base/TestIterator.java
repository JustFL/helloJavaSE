package base; /**
 *
 * List遍历
 *
 * */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class TestIterator {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        //1 for循环
        //2 增强for循环
        //3 foreach 这个是list的方法
        list.forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

        //lambda和lambda方法引用
        list.forEach((t)->{System.out.println(t);});
        list.forEach(System.out::println);

        //4 迭代器 接口  用途就是遍历集合
        Iterator<String> i = list.iterator();

        //remove()删除最近一次next()访问的元素
        System.out.println("next访问 "+i.next());
        i.remove();
        list.forEach(System.out::println);

        //while
        System.out.println("while循环Iterator");
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        //5 foreachremaining 这个是迭代器的方法
        System.out.println("-----foreachremaining-----");
        //因为迭代器上次用过之后 指针已经指向了最后一个元素 所以第二次遍历就没有任何结果了
        i.forEachRemaining(System.out::println);
        //必须重新获取一个迭代器对象
        Iterator<String> i1 = list.iterator();
        i1.forEachRemaining(System.out::println);


        //6 ListIterator 是迭代器的子接口 只针对list集合
        ListIterator<String> li = list.listIterator();
        System.out.println("------ListIterator------------");
        while (li.hasNext()) {
            System.out.println(li.next());
            li.add("hello");
        }
        System.out.println(list);

        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }

        //7 list stream 这个foreach是stream流的方法
        System.out.println("----------Stream------------");
        list.stream().forEach(System.out::println);
    }

}
