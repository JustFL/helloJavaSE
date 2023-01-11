package base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * HashMap     线程非安全   效率高
 * HashTable   线程安全     效率低
 * 底层都是hash表
 * LinkedHashMap是HashMap子类  底层是链表  有序是添加元素的顺序
 * TreeMap 底层是二叉树 有序 一般是自然排序 也可以自己指定比较器
 * */

public class TestMap {

    public static void main(String[] args) {
        //HashMap支持空键和空值
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Tony Stark");
        map.put(2, "Steve Rogers");
        map.put(3, "Thor");
        System.out.println(map);

        //key值重复 会覆盖先前的value
        map.put(2, "Bruce Banner");
        System.out.println(map);

        //判断是否存在某个键和某个值
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Thor"));

        //根据某个key取得对应的value
        System.out.println(map.get(2));

        //删除某个键对应的键值对
        map.remove(2);
        System.out.println(map);

        //可以直接访问键的集合 类型Set
        System.out.println(map.keySet());

        //值的集合 类型Collection
        System.out.println(map.values());

        //遍历
        //1 集合的forEach
        map.forEach((k,v)->{System.out.println(k+","+v);});
        //2 Iterator
        System.out.println("-----------将Map转化为Entry键值对类型进行遍历------------");
        map.entrySet().iterator().forEachRemaining(e->System.out.println(e.getKey()+","+e.getValue()));
        //3 Iterator+loop
        Iterator<Entry<Integer,String>> i = map.entrySet().iterator();
        while (i.hasNext()) {
            Entry<Integer,String> e = i.next();
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //清除Map内容 查看Map的大小
        map.clear();
        System.out.println(map.size());

        //TreeMap会自动根据key的值进行排序
        SortedMap<Integer,String> sm = new TreeMap<>();
        sm.put(3, "Thor");
        sm.put(1, "Tony Stark");
        sm.put(2, "Steve Rogers");

        System.out.println(sm);
    }

}
