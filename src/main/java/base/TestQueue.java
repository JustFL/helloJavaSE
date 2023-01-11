package base; /**
 * 队列是一组访问受限的线性表
 * 只能在队尾增加 队头删除
 * 先进先出
 * */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class TestQueue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        System.out.println("-----------add会抛出异常 offer不会抛异常-----------------");
        q.add("aa");
        q.add("bb");
        q.offer("cc");
        q.offer("dd");
        q.forEach(System.out::println);

        System.out.println("-----------remove会抛出异常 poll不会抛异常-----------------");
        q.remove();
        q.poll();

        //模拟出队
        while (q.size()>0) {
            System.out.println(q.remove());
        }
        System.out.println(q.size());

        //PriorityQueue 排序队列
        PriorityQueue<String> p = new PriorityQueue<>();
        p.offer("aa");
        p.offer("cc");
        p.offer("bb");
        //注意 队列不能添加null值 会报空指针异常 但是只有LinkedList可以

        System.out.println("想要看到PriorityQueue中的顺序 不能用foreach方法 可以进行循环遍历");
        while (p.size() > 0 ) {
            //这样输出能看到PriorityQueue是经过排序的队列
            System.out.println(p.poll());
        }

        //Deque双端队列
        System.out.println("--------双端队列模拟队列 先进先出---------");
        Deque<String> deque = new LinkedList<>();
        deque.add("aa");
        deque.add("bb");
        deque.addLast("cc");
        deque.addLast("dd");
        while (deque.size() > 0 ) {
//			System.out.println(d.poll());
            System.out.println(deque.pollFirst());
        }

        System.out.println("--------双端队列模拟栈 后进先出--------");
        Deque<String> stack = new ArrayDeque<>();
        stack.addFirst("aa");
        stack.offerFirst("bb");
        stack.addFirst("cc");
        stack.offerFirst("dd");
        while (stack.size() > 0 ) {
            System.out.println(stack.pollFirst());
        }

        System.out.println("--------push pop专门的栈操作--------");
        stack.push("Tony Stark");
        stack.push("Steve Rogers");
        stack.push("Thor");
        stack.push("Bruce Banner");
        stack.push("Natasha Romanoff");
        stack.push("Clint Barton");
        stack.push("Wanda Maximoff");
        while (stack.size() > 0 ) {
            System.out.println(stack.pop());
        }


    }

}
