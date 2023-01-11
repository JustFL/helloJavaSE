package file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据流
 * 提供了不同数据类型的读取和写入
 * */
public class TestDataStream {

    public static void main(String[] args) throws IOException {
        int[] no = {11,22,33};
        String[] name = {"Tony Stark","Thor","Bruce Banner"};

        //创建数据流对象
        DataOutputStream douts = new DataOutputStream(new FileOutputStream("DataStream.txt"));

        //调用不同的写入方法 写入不同类型的数据
        for (int i = 0; i < no.length; i++) {
            douts.writeInt(no[i]);
            douts.writeUTF(name[i]);
        }

        //关闭
        douts.close();

        //-----------------------------------
        //利用数据流读取
        DataInputStream dins = new DataInputStream(new FileInputStream("DataStream.txt"));

        //调用不同的方法 读入不同类型的数据
        for (int i = 0; i < no.length; i++) {
            System.out.println(dins.readInt());
            System.out.println(dins.readUTF());

        }

        //关闭
        dins.close();



    }

}
