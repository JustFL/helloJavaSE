package file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 *                             Reader
 *                               |
 *  BufferedReader-------InputStreamReader------PrintWriter(输出流多这个)
 *                               |
 *                          FileReader
 *
 * @author summerKiss
 *
 */

public class TestFileReader {
    public static void main(String[] args) throws IOException {
        //创建字符文件流对象
        File f = new File("StreamTest.txt");
        FileReader fr = new FileReader(f);
        //读取 这里每次都读取一个字符
//		int temp;
//		while((temp = fr.read()) != -1) {
//			System.out.print((char)temp);
//		}
        //创建字符数组
        char[] c = new char[(int)f.length()];
        //将文件内容存储到字符数组中
        fr.read(c);
        System.out.println(c);

        //关闭
        fr.close();

        //创建写入流进行写入
        FileWriter fw = new FileWriter(f);
        //进行写入
        fw.write("Tony Stark");
        //关闭
        fw.close();
    }


}
