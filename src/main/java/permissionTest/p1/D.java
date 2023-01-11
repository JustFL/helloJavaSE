package permissionTest.p1;

public class D extends A{
    public void dTest() {
        //同包中的子类 除了父类的private属性 其他属性都可以访问
        //System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
    }

}
