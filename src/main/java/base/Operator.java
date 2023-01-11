package base;

/**
 *
 * @author zy
 *
 */

public class Operator {
    public static void main(String[] args) {
        //++n1 先自增 后赋值 n1++ 先赋值 后自增
        int n1 = 5;
        int n2 = n1++;
        int n3 = ++n1;
        System.out.println(n1 + "-" + n2 + "-" + n3);

        //n4 += 5;比n5 = n5 + 5;多了一步强制类型转换
        short n4 = 5;
        n4 += 5;
        System.out.println(n4);

//		short n5 = 5;
//		n5 = n5 + 5;
        //因为先执行的是n5 + 5 会先将n5强转为int 之后将int赋值给short就会出现编译错误
//		System.out.println(n5);

        //(&&短路) 与 (&非短路)  与 |和||一样的区别
        int n6 = 1;
        System.out.println(5>6 && n6++ == 1);
        System.out.println(n6);
        int n7 = 1;
        System.out.println(5>6 & n7++ == 1);
        System.out.println(n7);
    }

}
