package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 扫描类
 * 可以对数据源进行处理
 * */
public class TestScanner {
    public static void main(String[] args) throws IOException {

        //这里的in是System类内部定义的一个InputStream流 是键盘输入流 将键盘输入的数据作为数据源
        Scanner stream = new Scanner(System.in);

        //对数据源进行处理
        if(stream.hasNextInt()) {
            System.out.println("是整数");
        }else
        {
            System.out.println("不是整数");
        }

        stream.close();


        //创建自己的流
        FileInputStream fs = new FileInputStream("StreamTest.txt");

        //利用Scanner类对数据源进行处理 这里将FileInputStream作为数据源
        Scanner superman = new Scanner(fs);

        //通过next系列的方法 获取不同数据类型的数据
        //这里获取了由空格分隔的一个单词
        String word = superman.next();
        System.out.println(word);

        //获取一行
        String line = superman.nextLine();
        System.out.println(line);

        //关闭流
        superman.close();
        fs.close();

    }
}
