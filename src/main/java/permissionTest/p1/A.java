package permissionTest.p1;
/**
 * private修饰符 只能在本类中使用
 * 默认修饰符 可以在本类和同包的类中使用
 * public修饰符 在任何地方都可以使用
 * @author summerKiss
 *
 */
public class A {
    private int a1;
    int a2;
    protected int a3;
    public int a4;

    public void aTest() {
        //本类中都可以使用
        System.out.println(a1+a2+a3+a4);
    }
}
