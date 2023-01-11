package base;

//函数式接口定义 只能有一个抽象方法 其他方法不限 lambda只能使用使用函数式接口
//@FunctionalInterface 是一个注解 表明这是一个函数式接口 并在编译的时候就会进行检查
@FunctionalInterface
interface LambdaInter{
    String sayHello(String name);
    default void func1() {
        System.out.println("函数式接口中其他方法没有限制");
    }
}

//作业使用lambda实现截取字符串  方法为sub(String str,int start,int end)
@FunctionalInterface
interface StrSub{
    String sub(String str, int start, int end);
}


public class TestLambda {
    public static void main(String[] args) {
        //使用lambda实现函数式结构的抽象方法 有参数有返回值
        LambdaInter la = (name)->{
            System.out.println("-----");
            String s = "hello "+name;
            return s;
        };
        String str = la.sayHello("tom");
        System.out.println(str);

        System.out.println("我是华丽的分割线!");

        //使用lambda替换thread使用时的内部类写法
        //首先是匿名内部类写法
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("this is runnable");
            }

        });
        t.start();

        //lambda写法
        new Thread(()-> {System.out.println("this is lambda runnable");}).start();;


        //使用匿名内部类实现字符串截取
        StrSub s1 = new StrSub() {

            @Override
            public String sub(String str, int start, int end) {
                return str.substring(start, end);
            }

        };
        System.out.println(s1.sub("lambda", 0, 2));

        //使用lambda表达式实现字符串截取
        StrSub s2 = (str1,start,end)->{return str1.substring(start, end);};
        System.out.println(s2.sub("lambda", 0, 2));

        //使用lambda方法引用实现字符串截取 lambda引用的使用前提是在lambda中只有一条语句 只有一个方法
        StrSub s3 = String::substring;
        System.out.println(s3.sub("lambda", 0, 2));
    }

}

