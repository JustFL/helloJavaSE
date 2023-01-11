package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理 模式为接口+实现类
 * 动态代理 在运行的阶段为每个方法创建代理方法 在运行时创建代理对象*/

public class TestDynamicProxy {
    public static void main(String[] args) {

        //创建目标对象
        JJ jj = new JJ();

        //创建代理对象 三个参数说明
        //loader 目标类的类加载器 因为代理对象需要知道目标类中的所有信息 根据目标对象创建代理对象
        //interfaces 目标类所实现的接口列表(获取目标类的所有方法)
        //InvocationHandler 代理方法里的操作
        Person p = (Person)Proxy.newProxyInstance(JJ.class.getClassLoader(), JJ.class.getInterfaces(), new InvocationHandler() {

            //InvocationHandler接口方法invoke 这个方法代表代理方法的执行  每有一个目标方法执行 就需要有一个代理方法invoke执行
            //假如被代理类有10个方法 就会有10个代理方法 invoke就会执行10次 它是遍历所有方法的
            //参数说明
            //proxy  代理对象
            //method 目标方法的描述对象
            //args   目标方法的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("Singing")) {
                    System.out.println("化妆");
                    method.invoke(jj);
                    System.out.println("回家");
                }
                else if(method.getName().equals("Talent")) {
                    System.out.println("找灵感");
                    method.invoke(jj);
                    System.out.println("休息");
                }


                return null;
            }
        });

        //代理对象调用代理方法
        p.Singing();
        p.Talent();
    }
}
