package base;

public class TestPacking {
    public static void main(String[] args) {
        //包装类 将基本数据类型作为对象来处理
        int n = 55;

        //两种手动装箱方法
        Integer i1 = new Integer(22);
        Integer i2 = Integer.valueOf(2222);
        System.out.println(i1);
        System.out.println(i2);

        //自动装箱
        Integer i3 = n;

        //手动开箱
        n = i3.intValue();

        //自动开箱
        n = i3;

        //除了Float和Double类型之外 其他6种基本类型的包装类都实现了常量池技术 在方法区中有缓存
        //只缓存了-128~127 如果变量字面值在此范围内 就不new对象了 直接将常量池中的地址返回给引用
        Integer num1 = 22;
        Integer num2 = 22;
        //超过缓存范围的数据 相当于Integer num3 = new Integer(222); 在堆中开辟了空间
        Integer num3 = 222;
        Integer num4 = 222;
        System.out.println(num1 == num2);
        System.out.println(num3 == num4);


        //查看上下限
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //String -> int
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.valueOf("234"));
        System.out.println(new Integer("345").intValue());

        //int -> String
        System.out.println(123+"");
        System.out.println(String.valueOf(234));
        System.out.println(Integer.toString(345));

        //进制转换 10转其他进制
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toHexString(12));
        //其他进制转10进制
        System.out.println(Integer.valueOf("101", 2));
        System.out.println(Integer.valueOf("c", 16));

        //测试字符串中有多少个字母 多少个数字 多少个空格
        String str = "hello  12  23 4 ";
        char[] arrays = str.toCharArray();
        int icount = 0,acount = 0,count = 0;
        for(char s:arrays) {
            if(s >= 'a' && s <= 'z' || s >= 'A' && s <= 'Z' ) {
                acount++;
            }else if(s >= '0' && s <= '9') {
                icount++;
            }else {
                count++;
            }
        }
        System.out.println(icount+"个数字 "+acount+"个字母 "+count+"个空格");//还可以使用Character包装类


    }

}
