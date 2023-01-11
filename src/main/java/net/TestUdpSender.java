package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUdpSender {
    public static void main(String[] args) throws IOException {
        //创建udp socket
        DatagramSocket socket = new DatagramSocket();
        //打包数据
        byte[] b = "hello receiver".getBytes();
        DatagramPacket packet = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 9999);
        //发送数据
        socket.send(packet);
        //关闭
        socket.close();
    }


}
