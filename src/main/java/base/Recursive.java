package base;

/**
 * 递归
 * @author summerKiss
 *
 */

class RS{

    public void f1(int n) {
        if (n == 0) {
            return;
        }
        f1(n-1);
        System.out.println(n);
    }

    public void f2(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        f2(n-1);
    }

}

public class Recursive {
    public static void main(String[] args) {
        RS rs = new RS();
        rs.f1(3);
        rs.f2(3);
    }
}
