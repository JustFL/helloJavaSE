package file;

/**
 * Java相对路径/绝对路径总结
 * @author summerKiss
 *
 */
public class TestPath {
    public static void main(String[] args) {

        //得到的是当前类TestPath.class文件的URI目录 不包括自己
        System.out.println(TestPath.class.getResource(""));

        //得到的是当前的classpath的绝对URI路径 (参见以前的笔记 classpath指的是.class文件的路径)
        System.out.println(TestPath.class.getResource("/"));

        //得到的也是当前ClassPath的绝对URI路径
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

        //得到的也是当前ClassPath的绝对URI路径。
        System.out.println(TestPath.class.getClassLoader().getResource(""));

        System.out.println("用户的账户名称:"+System.getProperty("user.name"));
        System.out.println("用户的主目录:"+System.getProperty("user.home"));
        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));
        System.out.println("当前的classpath的绝对路径的URI表示法:" + Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println("得到的是当前的classpath的绝对URI路径:"+ TestPath.class.getResource("/"));
        System.out.println("得到的是当前类HdfsStream.class文件的URI目录:"+TestPath.class.getResource(""));

        //绝对不要使用硬编码的绝对路径 因为 我们完全可以使用ClassLoader类的getResource("")方法得到当前classpath的绝对路径。
        //使用硬编码的绝对路径是完全没有必要的!它一定会让你死的很难看!程序将无法移植!

        /**
         * java 使用相对路径读取文件
         * 1.java project环境 使用java.io用相对路径读取文件的例子
         * 目录结构
         * note
         * 	|___src
         * 		|___com.decisiontree.SamplesReader.java
         * 	|___resource
         * 		|___train.txt,test.txt
         *
         * SamplesReader.java:
         * String filepath="resource/train.txt";//注意filepath的内容；
         * File file=new File(filepath);
         *
         * 我们留意filepath的内容 java.io默认定位到当前用户目录("user.dir")下 即：工程根目录"D:\note"下
         * 因此 此时的相对路径(以user.dir为基路径的路径)为"resource/train.txt"
         * 这样 JVM就可以根据"user.dir"与"resource/train.txt"得到完整的路径（即绝对路径）"D:\note\resource\train.txt"
         * 从而找到train.txt文件
         * 注意：相对路径的起始处无斜杆"/"
         * 例如 filepath="resource/train.txt";
         * 而不是filepath="/resource/train.txt"; //error!
         */


    }
}
