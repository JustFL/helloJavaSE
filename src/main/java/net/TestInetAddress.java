package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {

        //获取本机的主机名和IP地址
        InetAddress address = InetAddress.getLocalHost();
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();
        System.out.println(hostName+':'+hostAddress);

        //获取指定的IP信息
        InetAddress address1 = InetAddress.getByName("DESKTOP-E75SN4L");
        System.out.println(address1.getHostAddress());

        //访问对象可能是多台计算机时
        InetAddress[] baidu = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress inetAddress : baidu) {
            System.out.println(inetAddress.getHostAddress());
        }


    }
}
