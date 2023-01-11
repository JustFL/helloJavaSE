package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TestTcpClient {
    public static void main(String[] args) throws IOException {
        //创建客户端socket
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);
        //创建发送向服务器端的流
        OutputStream out = socket.getOutputStream();
        out.write("DHT-162".getBytes());
        //结束输出
        socket.shutdownOutput();

        //接收服务端回信
        /**
         * 这里的深坑用大篇幅来描述下
         * public int read(byte b[]) 如果这个方法用在从本地文件读取数据时，一般不会遇到问题，但如果是用于网络操作，就经常会遇到一些麻烦。
         * 比如，Socket通讯时，对方明明发来了1000个字节，
         * 但是自己的程序调用available()方法却只得到900，或者100，甚至是0，感觉有点莫名其妙，怎么也找不到原因。
         * 其实，这是因为网络通讯往往是间断性的，一串字节往往分几批进行发送。
         * 本地程序调用available()方法有时得到0，这可能是对方还没有响应，也可能是对方已经响应了，
         * 但是数据还没有送达本地。对方发送了1000个字节给你，也许分成3批到达，
         * 这你就要调用3次available()方法才能将数据总数全部得到。
         * 如果这样写代码：
         * int count = in.available();
         * byte[] b = new byte[count];
         * in.read(b);
         * 在进行网络操作时往往出错，因为你调用available()方法时，
         * 对发发送的数据可能还没有到达，你得到的count是0。
         * 需要改成这样：
         */
        InputStream in = socket.getInputStream();
        int count = 0;
        while (count == 0) {
            count = in.available();
        }

        /**
         * 另外根据大神的经验
         * 关于InputStream.read(byte[] b)和InputStream.read(byte[] b,int off,int len)
         * 这两个方法都是用来从流里读取多个字节的，有经验的程序员就会发现，
         * 这两个方法经常读取不到自己想要读取的个数的字节。
         * 比如第一个方法，程序员往往希望程序能读取到b.length个字节，而实际情况是，系统往往读取不了这么多。
         * 仔细阅读Java的API说明就发现了，这个方法 并不保证能读取这么多个字节，
         * 它只能保证最多读取这么多个字节(最少1个)。因此，如果要让程序读取count个字节，最好用以下代码：
         * byte[] b = new byte[count];
         * int readCount = 0; // 已经成功读取的字节的个数
         * while (readCount < count) {
         * 	     readCount += in.read(bytes, readCount, count - readCount);
         * }
         * 用这段代码可以保证读取count个字节，除非中途遇到IO异常或者到了数据流的结尾(EOFException)
         *
         */

        byte[] b = new byte[count];
        in.read(b);
        System.out.println("server say "+new String(b, "gbk"));

        //关闭
        in.close();
        out.close();
        socket.close();

    }
}
