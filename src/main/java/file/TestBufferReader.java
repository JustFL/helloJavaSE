package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**缓冲字符流
 * FileReader FileWriter是节点(对应的是包装流)流 是最底层的 直接接触数据的字符流
 *
 * */
public class TestBufferReader {
    public static void main(String[] args) throws IOException {

        //创建
        File f = new File("StreamTest.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        //每次读取一行数据 内容结束后为null
        String str;
        while((str = br.readLine()) != null) {
            System.out.println(str);
        }

        //关闭
        br.close();
    }
}
