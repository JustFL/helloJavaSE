package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流
 * 作用是提高效率 它可以提供一个缓冲区存储一批数据
 * */
public class TestBufferStream {

    public static void main(String[] args) throws IOException {
        //作业:将一张图片读出来 写入到另外一个图片文件中
        File f1 = new File("thread.png");
        FileInputStream ins = new FileInputStream(f1);

        File f2 = new File("thread_1.png");
        FileOutputStream outs = new FileOutputStream(f2);

        //取出一个字节 写入一个字节
//		int temp;
//		while((temp = ins.read()) != -1) {
//			outs.write(temp);
//		}

        //创建输入缓冲流和输出缓冲流进行包装  提高读写效率
        BufferedInputStream bins = new BufferedInputStream(ins);
        BufferedOutputStream bouts = new BufferedOutputStream(outs);

        //缓冲流读写
        int temp;
        while((temp = bins.read()) != -1) {
            bouts.write(temp);
        }

        //强制刷新 保证所有的数据都能写入
        bouts.flush();

        //由内向外关闭
        ins.close();
        bins.close();
        outs.close();
        bouts.close();
    }

}
