package base;

class To{

    //对象被释放前调用此方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this + " say: i am died");
    }

    @Override
    public String toString() {
        //可以将属性通过重写toString方法直接输出
        return "i love study";
    }

}

public class TestObject {
    public static void main(String[] args) {
        To to = new To();
        //对象创建时 虚拟机先将对象的.class文件加载到方法区 然后在堆中创建一个字节码文件对象 所有的实例对象按照这个字节码文件对象为模板进行创建
        //.getClass方法就是获取这个字节码文件对象
        System.out.println(to.getClass());
        System.out.println(to.getClass().getName());

        //直接输出对象引用名称 等同于System.out.println(to.toString()); 调用了toString方法
        System.out.println(to);

        //将hashCode方法传回的整形转化为16进制 就是对象地址
        System.out.println(Integer.toHexString(to.hashCode()));

        to = null;
        //通知垃圾回收器进行垃圾回收
        System.gc();
    }
}
