package base;

import java.util.ArrayList;
import java.util.List;

//raw type 原生类型 需要指定泛型的具体类型
//这是一个泛型类
//泛型 <T>就是参数化类型 在调用过程中通过传入的参数的类型 指定目标类型
//并且可以用在设定类型的范围 e.g class Base.Genericity<T extends Number> 但是只能申明上界 不能申明下界
class Genericity<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}


/*
 * 泛型接口
 * */
interface GenericityInterface<I>{
    void display(I arg);
}

/*
 * 泛型接口实现类
 * 第一种类型 泛型接口实现类确定了类型 例如指定了String类型
 * */
class GenericityInterfaceImp1 implements GenericityInterface<String>{

    @Override
    public void display(String arg) {
        System.out.println(arg);
    }

}

/*
 * 第二种类型 泛型接口实现类仍然不确定类型
 * */
class GenericityInterfaceImp2<I> implements GenericityInterface<I>{

    @Override
    public void display(I arg) {
        System.out.println(arg);
    }
}


class GenericityClass{
    //泛型构造器
    public <T> GenericityClass(T arg) {
        System.out.println("this is Base.Genericity constructor");
    }

    //泛型方法 返回一个T类型的对象 传入的参数也是T类型的
    public <T> T show(T arg) {
        return arg;
    }

}

public class TestGenericity {

    //无界通配符 <?> (类型参数) 匹配了泛型类所有的类型 可以设置上下界
    public void show(Genericity<?> g) {
        System.out.println(g.getT());
    }

    //上界设置 表示泛型类型只能是Number或者其子类 其他的类型会在编译阶段就报错
    public void showup(Genericity<? extends Number> g) {
        System.out.println(g.getT());
    }

    //下届设置 表示泛型类型只能是Number的父类
    public void showdown(Genericity<? super Number> g) {
        System.out.println(g.getT());
    }

    public static void main(String[] args) {

        //原生类型 没有指定泛型的具体类型 可以传入object类型的所有子类
        /*
         * Base.Genericity g1 = new Base.Genericity();
         * g1.setT(1);
         */

        //指定了泛型类型 等号右边的<>里可以不写具体类型了  叫做菱形写法
        Genericity<String> g2 = new Genericity<>();
        g2.setT("hello world!");
        System.out.println(g2.getT());

        //在指定了泛型类型之后 例如指定了String
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("aaaa");
        //arrayList.add(100); 后续在传入整形的时候 编译就会报错

        //泛型只在编译阶段有效
        //通过下面的例子可以证明 在编译之后程序会采取去泛型化的措施 也就是说Java中的泛型 只在编译阶段有效
        //在编译过程中 正确检验泛型结果后 会将泛型的相关信息擦出
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<Double> a2 = new ArrayList<Double>();
        System.out.println(a1.getClass());
        System.out.println(a2.getClass());

        System.out.println("-------------无界通配符---------------");
        Genericity<Double> g3 = new Genericity<>();
        g3.setT(432.789);
        TestGenericity t1 = new TestGenericity();
        t1.show(g2);
        t1.show(g3);


        //泛型构造器的使用 传入什么类型 T就是什么类型
        GenericityClass g = new GenericityClass("abc");
        /* 泛型方法的使用
         * 因为方法实现的时候参数类型和返回值都是T类型的
         * 所以当调用的时候 参数传入Integer类型
         * 输出返回值类型也是Integer的
         *
         *  */
        System.out.println(g.show(1).getClass());
        System.out.println(g.show("hello world!").getClass());

        //泛型接口实现类确定了类型 实现类对象调用方法时就可以直接看到参数类型
        GenericityInterfaceImp1 gi1 = new GenericityInterfaceImp1();
        gi1.display("hello world!");

        //泛型接口实现类声明的时候仍不确定类型 则需要在实例化的时候指定类型
        GenericityInterface<Float> gi2 = new GenericityInterfaceImp2<Float>();
        gi2.display(1F);
    }

}
