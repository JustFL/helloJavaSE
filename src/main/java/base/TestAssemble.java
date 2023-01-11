package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 集合
 * 1 可变长度
 * 2 只能存储对象引用 不能存储基本数据类型  可以存放包装类
 *                       Collection(interface)
 *                            |
 *      --------------------------------------------------------------
 *      |                     |                                       |
 *   List(interface)     Set(interface)                        Queue(interface)队列
 *      |                     |                                       |
 *      |                     |---HashSet(Class)底层hash表             |---PriorityQueue(Class)优先队列 排序队列 违背了队列先进先出的原则
 *      |                     |                                       |
 *  ArrayList(底层数组)    SortedSet(interface)有序                 Deque(interface)双端队列
 *  Vector(底层数组)            |                                       |                                                                                          |
 *  LinkedList(链表)      NavigateSet(interface)                   ArrayQueue
 *                            |                                    LinkedList
 *                         TreeSet(Class)二叉树
 *
 *
 *
 *   List有序可重复 Set不允许重复
 *
 Map(interface)----SortedMap(interface)----NavigateMap(interface)----TreeMap(Class)
 *              |
 *              |
 *           HashMap(Class)---LinkedHashMap(子类)
 *           HashTable(Class)---Properties
 *
 *
 *
 *
 *
 * ArrayList
 * Vector底层都是数组 扩容的时候其实是创建一个新的较大的数组来实现的  数组存储在内存中是连续的  所以增删比较慢
 * 和LinkedList相比 ArrayList遍历快 随机访问效率高 LinkedList是增删效率高
 * */
public class TestAssemble {

    public static void main(String[] args) {

        //Collection类的方法
        Collection<String> c = new ArrayList<>();
        //是否为空
        System.out.println(c.isEmpty());

        //添加元素可能返回false
        c.add("aa");

        //返回集合中元素个数
        System.out.println(c.size());

        //<? extends String> 泛型中的通配符  同时设置了上限  表示String和String的子类都可以
        Collection<String> c1 = new ArrayList<String>();
        c1.add("aaaa");
        c1.add("bbbb");

        //增加集合中的所有元素
        c.addAll(c1);

        //removeIf匿名内部类实现
//		System.out.println(c);
//		c.removeIf(new Predicate<String>() {
//
//			@Override
//			public boolean test(String t) {
//				return t.length() == 2;
//			}
//		});
//		System.out.println(c);

        //removeIf lambda实现
        c.removeIf((t)->{return t.length() == 4;});
        System.out.println(c);

        //将数组转化为集合 返回的不是ArrayList顶级类  是Arrays的一个内部类 是定长的 只能用来遍历
        String[] str = new String[]{"aa"};
        List<String> arraytoassemble =  Arrays.asList(str);
        System.out.println(c.containsAll(arraytoassemble));

        //集合转化数组
        Object[] obj = c.toArray();
        System.out.println(Arrays.toString(obj));

        System.out.println("----------------List----------------");
        //List示例
        List<String> l = new ArrayList<String>();
        l.add("aa");
        l.add("bb");
        System.out.println(l);

        //指定位置插入元素 List是有序的  是值插入的顺序
        l.add(1, "xx");
        System.out.println(l);

        //获取某个位置的值
        System.out.println(l.get(2));

        //修改某个位置的值
        l.set(1, "yy");
        System.out.println(l);

        //查找
        l.add("aa");
        System.out.println(l.indexOf("aa"));
        System.out.println(l.lastIndexOf("aa"));

        //取子集 范围是[) 不包括终止位置
        List<String> l1 = l.subList(0, 1);
        System.out.println(l1);

        //排序 传递一个空的比较器 进行自然升序排序
        l.sort(null);
        System.out.println(l);

//		l.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
//			}
//		});

        l.sort((o1,o2)->{return o2.compareTo(o1);});
        System.out.println(l);

    }

}
