package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTcpServer {
    public static void main(String[] args) throws IOException {
        //创建服务端 并且设置监听端口
        ServerSocket serversocket = new ServerSocket(9999);
        //获取客户端发送过来的socket
        Socket socket = serversocket.accept();
        //利用流读取内容
        InputStream in = socket.getInputStream();
        byte[] b = new byte[in.available()];
        in.read(b);
        System.out.println(socket.getInetAddress().getHostAddress() + " say:"+new String(b, "gbk"));


        //给客户端回信
        OutputStream out = socket.getOutputStream();
        out.write("OPUD-313".getBytes());

        //关闭
        in.close();
        out.close();
        socket.close();
        serversocket.close();

    }
}
