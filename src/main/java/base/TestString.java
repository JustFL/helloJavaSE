package base;

/**
 *
 * 不可变类
 *
 * @author summerKiss
 *
 */
public class TestString {
    public static void main(String[] args) {
        //使用字面值创建String对象 直接在方法区的常量池中创建String对象 并将地址返回给引用s1
        String s1 = "hello";

        //当常量池中已经有目标字符串时 会将引用直接指向该地址 不会重新创建 节省了内存
        String s2 = "hello";

        //地址相同
        System.out.println(s1 == s2);
        //比较字面值
        System.out.println(s1.equals(s2));

        //使用new关键字 必定会在堆中开辟空间 之后还是会去常量池中查看是否有目标字符串 如果有 将地址存放到堆中开辟的空间中
        //然后再将堆中的地址返回给s3引用
        String s3 = new String("hello");

        System.out.println(s2 == s3);

        //字符串不可变 这里是s4引用指向了拼接后的新字符串 老字符串hello的引用丢失
        //字符串每次改变 其实都是创建了新字符串
        String s4 = "hello";
        s4 = s4.concat(" world");
        System.out.println(s4);

        //字符串长度
        System.out.println(s4.length());

        //字符串比较
        System.out.println(s4.equalsIgnoreCase("HellO WorLd"));

        //大写
        System.out.println(s4.toUpperCase());

        //小写
        System.out.println(s4.toLowerCase());

        //返回参数字符串在当前字符串第一次出现的位置
        System.out.println(s4.indexOf("l"));

        //返回参数字符串在当前字符串最后一次出现的位置 忽略大小写
        System.out.println(s4.lastIndexOf("l"));

        //返回当前索引位置的一个字符
        System.out.println(s4.charAt(0));

        //切割字符串 从开始位置到末尾
        System.out.println(s4.substring(1));

        //[start, end)
        System.out.println(s4.substring(6, 11));

        //去除首尾空格
        System.out.println(s4.trim());

        //用参数2字符串替换参数1字符串
        System.out.println(s4.replace("l", "a"));

        //以xx开头 以xx结尾 忽略大小写
        System.out.println(s4.endsWith("ld"));
        System.out.println(s4.startsWith("h"));

        //比较两个字符串
        String s5 = "abc";
        String s6 = "bcd";
        System.out.println(s5.compareTo(s6));

        //String -> char[]
        char[] charArray = s5.toCharArray();
        for(char c: charArray){
            System.out.println(c);
        }

        //分割字符串
        String s7 = "aa bb c dd efg";
        String[] strings = s7.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }

        //字串是否存在
        boolean b = s7.contains(" bb ");
        System.out.println(b);
    }
}
