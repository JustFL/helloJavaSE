package base;

/**
 * 抽象类 是抽象概念的一种描述 不能创建对象 需要子类继承 子类来创建对象 抽象类是子类的一个模板
 * @author summerKiss
 *
 *
 * 抽象类和接口的区别
 * 抽象类是一个模板 是个半成品 其内部规定的属性或者方法是这个模板的主要功能 子类继承以后可以在此基础上进行拓展
 * 并且子类继承抽象类后 说明子类的主要功能也是和这个模板一样的
 *
 * 接口其实是一组规则规范 是某一项功能 实现类实现接口后 就可以对这项功能进行具体实现
 * 但是实现类的主要功能并不是接口的功能 而是接口功能要为其主要功能服务的
 * 个人观点接口其实就是 假如有很多类想要实现某个功能 如果要在每个类中都声明一次比较麻烦 所以抽取出来一个共同的接口
 * 想要这个功能的实现接口 重写自己的实现逻辑即可
 *
 * 抽象类只能单继承 但是接口可以实现多个
 *
 */

abstract class Traffic{
    private int count;//关于父类的private属性 子类是可以继承的 但是无法访问
    Traffic(int count){
        this.count = count;
    }
    public int getCount() {
        return this.count;
    }
    abstract void run();
}

//子类必须实现抽象类的所有抽象方法
class Bus extends Traffic{

    Bus(int count) {
        //所有子类的构造器默认都会隐式调用父类的无参数构造器 如果不存在会报错
        //这里显式调用父类的有参构造器
        super(count);
    }

    @Override
    void run() {
        System.out.println("car running in road! "+this.getCount());
        System.out.println("car running in road! "+super.getCount());
    }
}


public class TestAbstract {
    public static void main(String[] args) {
        Bus bus = new Bus(4);
        bus.run();
    }
}
