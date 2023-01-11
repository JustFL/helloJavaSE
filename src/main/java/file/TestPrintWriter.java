package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestPrintWriter {

    public static void main(String[] args) throws IOException {

        //所有实现了AutoCloseable接口的流对象都可以使用try catch语句进行自动自动资源释放

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter("StreamTest.txt");

        String str = null;
        while(true) {
            str = br.readLine();
            if(str.equals("q")) {
                break;
            }
            //直接将内容写入
            pw.println(str);
        }
        br.close();
        pw.close();


    }

}
