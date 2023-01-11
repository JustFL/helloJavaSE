package base;

/**
 *
 * @author summerKiss
 * 一个java程序对应一块jvm jvm是一块内存 其中分为堆和栈
 * 栈是一种先进后出的数据结构 当java程序从main方法开始调用时 会先将main方法压入栈中 随后调用的方法会依次进栈
 * 在main方法中定义变量时 如果变量是基本数据类型 会将变量的字面值直接存储在栈中
 * 如果变量是引用类型 在栈中存储的是变量的内存地址 地址会指向堆中 变量的值实际存储在堆中
 */
public class TestArray {
    public static void main(String[] args) {
        //静态初始化
        int[] a = {55};
        int[] b = {66};
        a = b;
        System.out.println(a[0]);
        b[0] = 77;
        System.out.println(a[0]);


        //数组复制
        //创建了指定长度的数组 系统会自动进行初始化 这是动态初始化
        int[] c = new int[10];
        System.arraycopy(a, 0, c, 5, 1);
        for (int i : c) {
            System.out.println(i);
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        int[] d = a.clone();
        System.out.println(d);
        for (int i : d) {
            System.out.println(i);
        }
    }
}
