package base;

/**
 *
 * 可变字符串类
 * StringBuffer  线程安全
 * StringBuilder 线程不安全
 * @author summerKiss
 *
 */
public class TestStringBuffer {
    public static void main(String[] args) {

        //StringBuffer默认16个字符大小 这里给定100个字符的大小
        StringBuffer sb1 = new StringBuffer(100);
        System.out.println(sb1.capacity());

        //拼接字符串
        sb1.append("abc");
        char[] chars = new char[] {'2','3','4'};
        sb1.append(chars);
        System.out.println(sb1);

        //缩短StringBuffer长度到实际的长度
        sb1.trimToSize();
        System.out.println(sb1.capacity());

        //在字符串中插入字符
        sb1.insert(1, 'h');
        System.out.println(sb1);

        //更新字符串
        sb1.setCharAt(1, 'a');
        System.out.println(sb1);

        //删除字符串[)
        sb1.delete(4, 7);

        sb1.deleteCharAt(1);
        System.out.println(sb1);

        //反转
        sb1.reverse();
        System.out.println(sb1);

        //返回指定索引位置的字符
        System.out.println(sb1.charAt(0));

        //返回指定字符串第一次出现和最后一次出现的位置
        System.out.println(sb1.indexOf("b"));
        System.out.println(sb1.lastIndexOf("c"));

    }
}
