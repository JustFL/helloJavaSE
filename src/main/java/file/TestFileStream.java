package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 流是一种有顺序的 有起点和终点的数据集合
 *
 * 可以有多种分类 按照方向可以分为输入和输出流
 * 按照流的数据类型可以分为字节流和字符流
 * 字符流主要传输文本 字节流可以传输任意格式
 *
 * 字节流分类
 *              FileInputStream
 *                |
 *                |                     DataInputStream
 * InputStream--FilterInputStream------ BufferedInputStream
 *                |
 *                |
 *              ObjectInputStream
 *
 * 输出流都是相对应的 多一个PrintStream
 *
 * @author summerKiss
 *
 */

public class TestFileStream {
    public static void main(String[] args) throws IOException {

        /**
         * 写入
         * */
        File file = new File("StreamTest.txt");
        //创建写入流 可以进行追加写入 public FileOutputStream(File file, boolean append)
        FileOutputStream fo = new FileOutputStream(file);
        //创建字符数组存储要写入的内容
        String str = "(雷神)Thor is 1500 years old";
        byte[] bout = str.getBytes();
        //开始写入
        //还可以public void write(byte b[], int off, int len)
        fo.write(bout);
        //关闭
        fo.close();


        //三种读取方式 后面两种方式可以对付文件中有中文的情况
        /**
         * 1>逐个字节读取
         * fs.read()读取的每个字节返回的是ASCII对应的整型数字 转化为字符查看内容
         * 当内容结束时 会读取-1表示没有内容了
         * 由于中文是两个字节表示一个字符 所以逐个字节读取的时候 汉字的半个字节会显示为？
         * */
        System.out.println("---1---");
        //创建文件字节流
        FileInputStream fi1 = new FileInputStream(file);
        //申明整型变量存放文件字节流读取结果
        int charToInt;
        //逐个字节读取 直到文件末尾-1
        while ((charToInt = fi1.read()) != -1) {
            System.out.print(charToInt + " " + (char)charToInt + "\n");
        }
        //关闭流
        fi1.close();



        /**
         * 2>将所有字节读取到一个字节数组中 然后转化为字符串
         */
        System.out.println("---2---");
        FileInputStream fi2 = new FileInputStream(file);
        //创建一个字节数组 指定大小有两种方式
        //1>(int)file.length() 文件的大小
        //2>fi2.available()    流的长度
        byte[] b = new byte[(int)file.length()];
        //将读取的内容全部存储到字符数组中
        fi2.read(b);
        //读取部分内容存储到数组中
        //第二个参数表示从数组的哪个位置开始存放
        //第三个参数表示读取多少个字节
        //fi2.read(b, 1, 2);
        //将内容转化为字符串 并且指定了编码方式 然后进行输出
        System.out.println(new String(b, "gbk"));
        //关闭流
        fi2.close();

        /**
         * 3>将字节流转化为字符流
         */
        System.out.println("---3---");
        FileInputStream fi3 = new FileInputStream(file);
        //将字节流包装为字符流
        InputStreamReader ir = new InputStreamReader(fi3);

        int tmp;
        //字符流每次读取一个字符
        while ((tmp = ir.read()) != -1) {
            System.out.print((char)tmp);
        }
        //直接关闭外层的流就可以
        ir.close();

        //字符数组写入时第一个字节若为正数 则查询ASCII表
        //若第一个字节为负数 则和第二个字节组成一个字符 查询系统默认的码表(GBK)
        File file1 = new File("PositiveAndNegative.txt");
        FileOutputStream fos = new FileOutputStream(file1);
        //byte[] bytes = {65,66,67};
        byte[] bytes = {-65,66,67};
        fos.write(bytes);

        fos.close();

    }
}
