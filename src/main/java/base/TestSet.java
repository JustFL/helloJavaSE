package base;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

class SetItem{
    private int id;
    private String name;
    public SetItem() {

    }
    public SetItem(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Base.SetItem [id=" + id + ", name=" + name + "]";
    }

    //重写hashcode和equals方法让set认为同样的属性值就是同一个对象
    @Override
    public int hashCode() {
        return id+name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        SetItem item = (SetItem)obj;
        return item.id == this.id && item.name.equals(this.name);
    }
}

public class TestSet {

    public static void main(String[] args) {

        /**
         * HashSet存储数据过程 底层是hash表(类似于数组+链表)
         * 先取对象hashcode()的值 如果hashcode()值对应位置上没有数据 直接存放
         * 如果hashcode()值相同 再对对象调用equals方法  看对象是否完全一致
         * 如果hashcode值相同 equals值不相同 则在底层数组的相同hashcode值位置上创建一条链表 进行存储
         * 链表太长的话导致查找太慢 在链表长度超过8的时候 转化为二叉树
         *
         * 下面创建的是TreeSet 底层数据结构是二叉树 每个节点的子节点不超过两个
         * 每个节点包括一个数据域和两个链域 分别指向左节点和右节点 左节点存小的  右边存储大的
         *
         * HashSet NavigableSet TreeSet LinkedHashSet区别
         * HashSet无序但是效率高
         * TreeSet有序 一般是自然升序 也可以自己指定比较器进行排序
         * LinkedHashSet有序  是按照加入的顺序(链表存储)
         *
         *
         * HashSet底层是一个HashMap 没有value 只有key
         * TreeSet底层是一个TreeMap
         * 都是以Key作为值 null作为value
         * */

        //验证重复数据无法加入到set中
        SetItem i1 = new SetItem(1, "zs");
        System.out.println(i1.hashCode());
        SetItem i2 = new SetItem(2, "ls");
        SetItem i3 = new SetItem(1, "zs");
        System.out.println(i3.hashCode());
        HashSet<SetItem> hashSet = new HashSet<SetItem>();
        hashSet.add(i1);
        hashSet.add(i2);
        hashSet.add(i3);
        System.out.println(hashSet);

        //TreeSet是根据CompareTo方法进行去重的... return 0就会被去重 不懂...
        SortedSet<String> set = new TreeSet<>();
        set.add("cc");
        set.add("aa");
        set.add("aa");
        set.add("bb");

        set.forEach(System.out::println);

        //排序后的第一个元素和最后一个元素
        System.out.println("第一个元素："+set.first()+" 最后一个元素："+set.last());

        //subset 取子集 范围同样的[)
        System.out.println(set.subSet("aa", "cc"));

        SetItem d1 = new SetItem(1,"dfs");
        SetItem d2 = new SetItem(2,"ad");

        /*
         * Comparator<Base.SetItem> com = (o1,o2)->o1.getName().compareTo(o2.getName());
         * Comparator<Base.SetItem> com1 = (o1,o2)->{return
         * o1.getName().compareTo(o2.getName());};
         */


        //在构造Set的时候自己指定比较器
        /*
         * 这里需要注意以下几点
         * 1>这里的函数式接口的方法是要返回一个int值的
         * 2>lambda表达式中()->{} 如果省略{} 会默认将表达式的返回值返回 如果不省略{}并且整个表达式含有返回值 请先将return语句写上
         * 否则会出现前面的语句报错 语法不提示 等各种奇葩情况
         */

        //TreeSet<Base.SetItem> treeSet = new TreeSet<Base.SetItem>((o1,o2)->{o1.getName().compareTo(o2.getName());return 0;}) ;
        TreeSet<SetItem> treeSet = new TreeSet<SetItem>((o1,o2)->o1.getName().compareTo(o2.getName())) ;
        treeSet.add(d1);
        treeSet.add(d2);

        System.out.println(treeSet);

        NavigableSet<Integer> treeSet2 = new TreeSet<>();
        treeSet2.add(11);
        treeSet2.add(22);
        treeSet2.add(88);
        treeSet2.add(77);
        treeSet2.forEach(System.out::println);
        //返回小于指定参数的最大整数
        System.out.println(treeSet2.floor(33));
        //返回大于指定参数的最小整数
        System.out.println(treeSet2.ceiling(33));
        //返回一个降序的NavigableSet
        System.out.println("---------降序集合--------");
        treeSet2.descendingSet().forEach(System.out::println);
        //返回一个降序的迭代器
        System.out.println("---------降序迭代器--------");
        treeSet2.descendingIterator().forEachRemaining(System.out::println);
        //移除第一个和最后一个元素
        treeSet2.pollFirst();
        treeSet2.pollLast();
        System.out.println("------移除后--------");
        treeSet2.forEach(System.out::println);
    }
}
