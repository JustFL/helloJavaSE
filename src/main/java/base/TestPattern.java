package base;
/**
 * 正则表达式
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) {

        Scanner superman = new Scanner(System.in);
        System.out.println("请输入一个邮政编码");
        String str = superman.next();

        //电话号码 只能由数字 由1开头 "1\\d{10}"
        //密码 只能有数字和字母 长度4-10 "\\w{4,10}"
        //用户名 以英文开头 只能有数字和字母 长度4-16 "[a-zA-Z]\\w{3,15}"

        //设置要匹配的正则表达式
        Pattern p = Pattern.compile("[a-zA-Z]\\w{3,15}");
        //设置要验证的字符串
        Matcher m = p.matcher(str);
        //验证
        System.out.println(m.matches());

        superman.close();
    }
}
