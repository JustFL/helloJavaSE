package base;

/**
 * 类中含有内部类的编译结果是 内部类->Base.Outer$Inner.class
 * 外部类Outer.class
 * @author summerKiss
 *
 */

interface Anonymous{
    void show();
}

class Outer{
    int a = 1;
    int b = 2;

    //实例成员内部类
    class Inner{
        int a = 2;
        //内部类中不能声明静态内容
        //static int b;
        public void show() {
            //内部类中访问外部类同名的成员变量
            System.out.println("outer:"+Outer.this.a);
            //内部类中访问外部类变量 可以直接访问
            System.out.println("outer:"+b);
            //内部类访问自己变量
            System.out.println("inner:"+a);
        }
    }
    //静态成员内部类
    static class StaticInner{
        int a = 3;
        public void show () {
            System.out.println(a);
        }
    }


    public void show() {
        //外部类访问内部类的实例变量 需要先创建内部类的对象
        Inner inner = new Inner();
        System.out.println("inner:"+inner.a);

        //局部内部类 在方法中创建
        class PartInner{
            int a = 4;
            public void show() {
                System.out.println(a);
            }
        }

        PartInner partInner = new PartInner();
        partInner.show();
    }
}
public class TestInner {

    public static void main(String[] args) {
        //创建实例成员内部类的对象 并且调用内部类方法
        Outer.Inner inner = new Outer().new Inner();
        inner.show();

        //创建静态内部类的对象
        Outer.StaticInner staticinner = new Outer.StaticInner();
        staticinner.show();

        //验证局部内部类
        Outer outer = new Outer();
        outer.show();

        //匿名内部类 必须实现或者继承一个接口或者类 这里new Base.Anonymous()并不是创建接口对象 而是创建了实现类的对象
        Anonymous a = new Anonymous() {

            @Override
            public void show() {
                System.out.println("----------------");
                System.out.println("123");
            }

        };
        a.show();
    }

}
