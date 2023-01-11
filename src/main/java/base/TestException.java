package base; /**
 * Throwable分为错误Error和异常Exception
 * Error一般为java虚拟机内部错误 无法解决
 * Exception分为受检异常 这是非运行时异常 这种编译都无法通过 必须处理 包括了Exception和其一部分子类
 * 还有运行时异常 这种可以通过异常处理代码使程序继续运行 不会中断
 *
 * debug模式F5进入方法中 F6不进入方法中 进行下一行代码
 */

import java.util.InputMismatchException;
import java.util.Scanner;

class SelfDefineException extends Exception{

    private static final long serialVersionUID = 1L;

    public SelfDefineException(String str) {

    }
}

public class TestException {

    public static void a() {
        b();
    }

    public static void b() {

        System.out.println("--------以下代码学习try-catch---------------");
        //try-catch
        Scanner superman = new Scanner(System.in);
        System.out.println("请输入两个数字");
        //try可能会出现异常的代码
        try {
            //b=0 java.lang.ArithmeticException
            int a = superman.nextInt();
            int b = superman.nextInt();
            int res = a / b;
            System.out.println(res);
        }
        //catch块没有异常不会执行
        //若出现的异常类型和catch参数异常类型不匹配 不执行catch块代码 程序会中断
        //出现异常并且和catch参数类型相同  执行catch块代码
        catch (ArithmeticException e) {
            System.out.println("除数不能为0");
            //打印异常的堆栈的轨迹信息
            e.printStackTrace();
        }
        catch(InputMismatchException e) {
            System.out.println("输入的类型有问题");
        }
        //注意 多个catch块的时候 是有顺序的  一般常见的，简单的，子类的放上面

        finally {
            //不论是否有异常一定要执行的代码 就算要中断也要执行 除非System.exit(0) 退出虚拟机;
            superman.close();
        }
    }


    //Exception受检异常 必须在代码中进行处理  RuntimeException运行异常 在代码中可以不处理
    //方法中抛出异常对象时 需要在方法头上进行申明要抛出异常throws Exception
    public void f() throws Exception{
        System.out.println("throws关键字进行异常抛出");
        throw new RuntimeException();
    }

    public void f1() throws Exception{
        System.out.println("抛出自定义异常进行处理");
        //throw关键字自己抛出一个异常对象
        throw new SelfDefineException("这是一个自定义异常");
    }

    public static void main(String[] args) {

        /**
         *  展示了方法栈的方法压入顺序 所以抛出异常的时候从最后入栈的方法 依次向最先入栈的方法抛出
         *  如果方法中有异常处理代码 就处理 不再向调用者抛出
         * 	at javaSE.Base.TestException.b(Base.TestException.java:43)
            at javaSE.Base.TestException.a(Base.TestException.java:30)
            at javaSE.Base.TestException.main(Base.TestException.java:67)
         */
        a();

        System.out.println("--------以下代码学习throws---------------");
        TestException t = new TestException();
        //f()方法申明异常后  调用者需要处理  可以继续向自己的调用者抛出异常 或者进行try-catch处理
        try {
            t.f();
        } catch (Exception e) {
            System.out.println("调用者接收到异常 进行处理");
            e.printStackTrace();
        }

        System.out.println("--------以下代码学习自定义异常---------------");
        try {
            t.f1();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("异常后 其他代码继续执行");


    }

}
