package base;

/**
 * static修饰的变量不存在于虚拟机内存的堆和栈中 而是存在于方法区中
 * 在程序创建某个对象之前 需要先将对象的模板 也就是这个类的.class文件加载到方法区中 然后根据这个模板来创建这个类的对象
 * 在虚拟机加载类的字节码文件时 同时会在方法区中创建静态的变量 并且完成初始化
 *
 * static修饰的方法为静态方法 不能使用this super关键字 不能访问非静态成员 非静态方法
 * 实例方法既可以访问实例成员 也可以访问静态成员
 *
 * @author summerKiss
 *
 */
class TS{
    int c1;//实例成员变量 属于每个对象所有
    static int c2;//静态成员变量 属于类 不属于对象 类的所有对象共享 优先于对象存在
    static int c3;

    //静态块 初始化类 给类中的静态成员变量赋值 在加载类的时候自动执行一次
    {
        c3 = 100;
    }

    public void f1() {
        //都可以访问
        System.out.println(c1);
        System.out.println(c2);
        f2();
    }

    public static void f2() {
        //System.out.println(c1);//不能访问非静态成员
        System.out.println(c2);
        //f1();//不能访问非静态成员
    }
}

public class TestStatic {
    public static void main(String[] args) {
        TS ts1 = new TS();
        TS ts2 = new TS();
        ts1.c1++;
        ts2.c1++;
        TS.c2++;//静态变量不属于类 所以使用时 不要ts1. 而是要用类名.
        TS.c2++;
        System.out.println(ts1.c1);
        System.out.println(ts2.c1);
        System.out.println(TS.c2);
        System.out.println(TS.c2);
        System.out.println(TS.c3);
    }

}
