package permissionTest.p1;

public class C {
    public void cTest() {
        A a = new A();
        //同包中的类不需要import
        //同包中的类的属性 除了private修饰的 其余都可以访问
        //System.out.println(a.a1);
        System.out.println(a.a2);
        System.out.println(a.a3);
        System.out.println(a.a4);
    }
}
