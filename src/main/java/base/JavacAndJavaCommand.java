package base;

/**
 * @author zy
 * jdk java开发环境 内置了jre
 * jre java运行环境 其中D:\jdk8\jre1.8.0_112\bin\server\jvm.dll这个文件就是虚拟机
 * 运行过程：
 * 1 编译过程 命令: javac 路径 + .java 形成.class字节码文件
 * 2 解释运行过程 命令: java 主类的名字(注意主类名字必须和主类的文件名字一致) 如果提示找不到或者无法加载主类
 * 这是因为找不到主类文件 需要设置一下classpath 字节码文件路径
 * 命令:java -classpath 主类文件路径 主类名字
 *
 * java命令就是调用虚拟机将字节码文件转化为机器语言  调用过程大概
 * 1 类加载器
 * 2 字节码校验
 * 3 解释器
 */
public class JavacAndJavaCommand {
    public static void main(String[] args) {
        System.out.println("\101");
        System.out.println("\101");
    }
}