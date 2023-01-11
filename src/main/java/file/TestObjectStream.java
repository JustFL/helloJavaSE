package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 对象流
 * 序列化 将对象存储到文件中
 * 反序列化 从文件中将对象读取出来
 * */

class Avenger implements Serializable{
    /**
     * 序列化版本号 如果不指定 系统会自动随机分配一个
     * 序列化后如果对象的类发生变化 反序列的时候版本号会发生变化 所以这里手动指定一个 保证正反序列化的正确
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return name + "," + age;
    }
    public Avenger() {

    }
    public Avenger(int age,String name) {
        this.age = age;
        this.name = name;
    }
}

public class TestObjectStream {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Avenger Tony = new Avenger();
        Tony.setAge(39);
        Tony.setName("Tony Stark");

        //--------------序列化-----------------
        //创建对象流
        ObjectOutputStream oouts = new ObjectOutputStream(new FileOutputStream("ObjectStream.txt"));

        //写入对象  文件中的内容是以16进制写的
        oouts.writeObject(Tony);

        //关闭
        oouts.close();

        //--------------反序列化-----------------
        ObjectInputStream oins = new ObjectInputStream(new FileInputStream("ObjectStream.txt"));

        //读取对象
        Avenger p = (Avenger)oins.readObject();
        System.out.println(p);

        //关闭
        oins.close();
    }

}
