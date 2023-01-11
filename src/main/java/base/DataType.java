package base;

import java.math.BigDecimal;

public class DataType {
    public static void main(String[] args) {
        /*
         * 基本数据类型 存放值
         * */
        //1 整数类型(长度分别为1，2，4，8byte) 注意:字面值如果是整数的话 就会默认为int类型
        byte a = 15;
        short b = 32000;
        int c = 1000000;
        long d = 1000002222l;
        System.out.println("a=" + a + "\n" + "b=" + b + "\n" + "c=" + c + "\n" + "d=" + d);

        //加0B/0b前缀表示2进制数
        int n1 = 0b101;
        System.out.println(n1);

        //加0表示8进制数
        int n2 = 017;
        System.out.println(n2);

        //加0x/0X表示16进制数
        int n3 = 0X17;
        System.out.println(n3);

        //科学计数法e/E
        double n4 = 1.4E10;
        System.out.println(n4);

        //2 浮点类型(长度分别为4，8byte) 注意:字面值如果是浮点类型的话 就会默认为double类型
        float e = 1.5f;
        double f = 2.12312d;
        System.out.println("e=" + e + "\n" + "f=" + f);

        //相加后不等于0.3
        double n5 = 0.1;
        double n6 = 0.2;
        System.out.println(n5 + n6);

        //准确运算小数
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        System.out.println(num1.add(num2));

        //3 字符类型(2byte) 范围0~65535 每一个数值对应一个字符
        char g = 'a';
        char g2 = '王';
        int g1 = g2;
        System.out.println(g1);
        System.out.println(g);
        //4 布尔类型
        boolean h = true;
        System.out.println(h);

        /*
         * 引用数据类型 存放地址
         * */
        //1 字符串
        //2 类类型
        //3 数组
        //4 接口


    }
}
