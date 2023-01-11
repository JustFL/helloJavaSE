package base;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {

        //当前时间 是时间 包括了小时分钟秒
        Date date = new Date();
        System.out.println(date);

        //从1970-1-1到现在为止的毫秒数
        long time = date.getTime();
        System.out.println(time);

        //根据毫秒数创建一个时间类型对象 1555315978009
        Date date1 = new Date(1555315978009L);
        System.out.println(date1);

        //子类 java.sql.Date 是一个日期类 不是时间
        java.sql.Date d1 = new java.sql.Date(time);

        //日期转化为字符串
        String str = d1.toString();
        System.out.println("java.sql.Date:"+str);

        //字符串转为日期
        java.sql.Date d2 = java.sql.Date.valueOf(str);

        //java.sql.Time 时间类  只有时分秒
        java.sql.Time t1 = new java.sql.Time(time);
        str = t1.toString();
        System.out.println("java.sql.Time:"+str);

        //java.sql.Timestamp 包含了毫秒

        //---------------------格式化-----------------------
        //java.util.Date类型默认的输出Tue Apr 16 09:39:01 CST 2019 格式不好 调整格式
        System.out.println("------------------Format----------------------");
        //先使用NumberFormat
        //默认环境的默认格式化方式
        NumberFormat instance = NumberFormat.getInstance();
        System.out.println(instance.format(432.778899));

        //默认的货币格式化方式
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.println(currencyInstance.format(432.778899));

        //DecimalFormat
        DecimalFormat decimalFormat = new DecimalFormat("000.0000");
        System.out.println(decimalFormat.format(43.778899));

        //时间格式化DateFormat
        DateFormat df1 = DateFormat.getInstance();
        System.out.println("DateFormat的默认格式化方式"+df1.format(date));

        //使用DateFormat对日期格式化
        DateFormat df2 = DateFormat.getDateInstance();
        System.out.println("DateFormat的日期格式化方式"+df2.format(date));

        DateFormat df3 = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("DateFormat的短日期类型格式化"+df3.format(date));

        //时间格式化
        DateFormat df4 = DateFormat.getTimeInstance();
        System.out.println("DateFormat的默认时间格式化"+df4.format(date));

        //日期+时间的格式化
        DateFormat df5 = DateFormat.getDateTimeInstance();
        System.out.println("默认格式"+df5.format(date));

        DateFormat df6 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        System.out.println("自定义格式"+df6.format(date));

        //SimpleDateFormat 自定义格式化类型
        //yyyy MM dd hh/H mm ss SSS
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd H:mm:ss:SSS");
        System.out.println(sf1.format(date));

        //Calendar
        System.out.println("------------------Calendar----------------------");
        Calendar c1 = Calendar.getInstance();
        System.out.println(df6.format(c1.getTime()));

        c1.add(Calendar.YEAR, 2);
        System.out.println(df5.format(c1.getTime()));

        //当前的年月日 calendar.get()月份的时候需要+1
        System.out.println("当前的年份："+c1.get(Calendar.YEAR)+" 当前的月份："+(c1.get(Calendar.MONTH)+1)+" 当前的日期："+c1.get(Calendar.DATE));

        //Calendar自己设置时间
        Calendar c2 = Calendar.getInstance();
        c2.set(2020, 1, 15);
        System.out.println(df6.format(c2.getTime()));

        //时间比较
        System.out.println(c1.before(c2));


    }

}
