package permissionTest.p2;

import permissionTest.p1.A;

public class E extends A{
    public void eTest() {
        //不同包的子类 可以访问public和protected修饰符的属性 private和默认修饰符修饰的属性 不能访问
        //System.out.println(a1);
        //System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
    }
}
