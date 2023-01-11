package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BufferedServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(12000);
        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        //接收客户端信息
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String temp = null;
        StringBuffer sb = new StringBuffer();
        if ((temp = bin.readLine()) != null) {
            sb.append(temp);
        }

        System.out.println("client say:" + sb);

        //回复客户端
        PrintWriter pw = new PrintWriter(out);
        pw.println("yeah... i never forget you");

        pw.close();
        bin.close();
        serverSocket.close();
    }

}
