package base;

/**
 * 接口是一组规则和规范
 * 普通实现类实现接口 必须实现接口中的所有抽象方法
 * 类可以继承多个接口
 * 接口可以继承和多继承
 * @author summerKiss
 *
 */

//三项接头
interface Elec3{
    //接口中的所有成员都是public
    public abstract void charge3();
    default void df() {
        System.out.println(3);
    }
}

//两项接头
interface Elec2{
    //	public abstract void charge2();
    void charge2();
    //	public final int N = 55;
    int N = 55;
    //默认方法
    default void charge2Default() {
        System.out.println("charge default!");
    }
    //静态方法
    static void charge2Static() {
        System.out.println("charge static!");
    }

    default void df() {
        System.out.println(2);
    }
}

//接头继承了三项和两项的 实现了功能的拓展
interface Socket extends Elec2,Elec3{
    void socketCharge();

    //如果继承的接口中有重名的默认方法 需要重写
    default void df() {
        //重写方法时 如果要调用父类接口的默认方法实现时 如下
        Elec2.super.df();
        Elec3.super.df();
    }
}

class Computer implements Socket{

    @Override
    public void charge2() {
        System.out.println("computer use 2 charge!");
    }

    @Override
    public void charge3() {
        System.out.println("computer use 3 charge!");
    }

    @Override
    public void socketCharge() {
        System.out.println("computer use socket charge!");
    }

    public void show() {
        charge2Default();
        //接口中的静态方法 需要使用类名.方法名调用
        Elec2.charge2Static();
    }

}


public class TestInterface {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.charge2();
        computer.charge3();
        computer.socketCharge();
        computer.show();
        computer.charge2Default();

        computer.df();

        //待补充 如果有重名的抽象方法 可以使用匿名内部类分别实现两个接口的抽象方法
    }
}
