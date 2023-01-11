package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 在编译阶段不知道要加载的类
 * 在运行阶段可以获取到类的所有信息
 * 所谓反射就是在运行阶段 可以动态获取不同的类的信息 调用不同的类的方法的机制
 * */

class DC implements Comics{

    @Override
    public void display() {
        System.out.println("This is DC Comics");
    }

}

class Marvel implements Comics{

    public String boss;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public void display() {
        System.out.println("This is Marvel Comics");
    }

    private void issue() {
        System.out.println("Marvel issue Spider");
    }


    private void issue(String name,int edition) {
        System.out.println("Marvel issue "+name+edition);
    }

    public Marvel() {
    }

    public Marvel(String boss,String address) {
        this.address = address;
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Marvel [boss=" + boss + ", address=" + address + "]";
    }


}

interface Comics{
    void display();
}

public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        //1 根据类的全限定名称来获取class对象(主要是读取配置文件 实现动态调用)
        Class<?> mode1 = Class.forName("reflect.DC");
        //2 通过类名.class
        Class<?> mode2 = DC.class;
        //3 对象.getClass()
        DC dc = new DC();
        Class<?> mode3 = dc.getClass();

        //配置文件
        //1 properties 是HashTable的字类
        //2 xml

        //创建配置文件对象
        Properties p = new Properties();
        //读取配置文件列表
        InputStream i = TestReflect.class.getClassLoader().getResourceAsStream("reflect.properties");
        p.load(i);
        //获取value值
        String value = p.getProperty("comics");
        //根据配置文件value创建class对象
        Class<Comics> cla = (Class<Comics>) Class.forName(value);
        //根据class对象调用无参数构造方法创建实例(newInstance过时方法 现在使用构造器创建对象)
        cla.newInstance().display();

        //获取无参构造器
        Constructor<Comics> c1 = cla.getConstructor();
        Comics comics1 = c1.newInstance();
        System.out.println("无参构造器对象 " + comics1);
        //获取有参的构造器
        Constructor<Comics> c2 = cla.getConstructor(String.class,String.class);
        Comics comics2 = c2.newInstance("Stark","Nork");
        System.out.println("有参的构造器 " + comics2);


        System.out.println("------------属性测试----------------");
        //获取public的属性
        Field[] publicfields = cla.getFields();
        for (Field f : publicfields) {
            System.out.println(f.getName());
        }

        //获取所有的属性
        Field[] allfields = cla.getDeclaredFields();
        for (Field f : allfields) {
            System.out.println(f.getName()+"属性的类型是:"+f.getType());
        }

        //获取指定的属性
        Field designatedfield = cla.getField("boss");
        System.out.println(designatedfield);

        Field designatedfield1 = cla.getDeclaredField("address");
        System.out.println(designatedfield1);


        //反射给对象私有属性赋值
        Marvel m = new Marvel();
        designatedfield1.setAccessible(true);
        designatedfield1.set(m, "New York");
        System.out.println(designatedfield1.get(m));

        System.out.println("------------反射获取类的所有方法----------------");
        //反射获取类的所有方法 包含了所有的public的方法和父类的方法
        Method[] allmethods = cla.getMethods();
        for (Method method : allmethods) {
            System.out.println(method);
        }

        System.out.println("------------反射获取自身的方法----------------");
        //反射获取自身类的方法 不包含父类的方法 但是包含自身private的方法
        Method[] declaredMethods = cla.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }


        //获取指定的方法 并且调用(参数有多个)
        Method designatedmethod = cla.getDeclaredMethod("issue", String.class, int.class);
        designatedmethod.setAccessible(true);
        designatedmethod.invoke(c1.newInstance(), "Iron Man",2);

        //获取指定的方法 并且调用(无参数)
        Method designatedmethod1 = cla.getDeclaredMethod("issue");
        designatedmethod1.setAccessible(true);
        designatedmethod1.invoke(c2.newInstance("Stan Lee","New York"));

        i.close();


    }

}
