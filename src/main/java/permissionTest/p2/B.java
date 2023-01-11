package permissionTest.p2;

import permissionTest.p1.A;

/**
 * 不同包中的类不能直接使用 两种方法
 * 1 import package.class 或者 import package.*
 * 2 使用类的全限定名称packagename.classname
 * 如果不同包中有同名的类 只能使用全限定名称来使用
 * @author summerKiss
 *
 */

public class B {
    public void bTest() {
        permissionTest.p1.A a = new A();
        //不同包的类的属性 除了public修饰的属性 其余的都不可以访问
        //System.out.println(a.a1);
        //System.out.println(a.a2);
        //System.out.println(a.a3);
        System.out.println(a.a4);
    }
}
