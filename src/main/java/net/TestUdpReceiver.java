package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUdpReceiver {
    public static void main(String[] args) throws IOException {
        //服务端根据监听端口创建socket
        DatagramSocket socket = new DatagramSocket(9999);
        //创建接收数据的包
        byte[] b = new byte[1024];
        DatagramPacket packet = new DatagramPacket(b, b.length);
        //接收数据
        socket.receive(packet);
        //读取数据
        System.out.println(new String(packet.getData(), "gbk"));
        //关闭
        socket.close();

    }
}
