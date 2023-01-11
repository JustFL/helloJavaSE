package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 使用PrintWriter自带换行 表示结束输入
 *
 * @author summerKiss
 *
 */
public class PrinterClient {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket("localhost", 12000);

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(out);
        pw.println("long time no see");
        pw.flush();

        InputStream in = socket.getInputStream();
        //接收服务器的回复
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String temp = null;
        StringBuffer sb = new StringBuffer();
        if ((temp = bin.readLine()) != null) {
            sb.append(temp);
        }
        System.out.println("server say:" + sb);

        bin.close();
        pw.close();
        socket.close();
    }
}
