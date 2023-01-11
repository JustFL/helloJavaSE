package reflect;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestCglibProxy {

    public static void main(String[] args) {
        //创建被代理对象(目标对象)
        JJ jj = new JJ();
        //创建代理对象类
        Enhancer ehancer = new Enhancer();
        //代理对象继承目标对象 获取目标对象的所有方法
        ehancer.setSuperclass(JJ.class);
        //设置方法的拦截对象 这个对象可以实现各种对代理方法的处理
        ehancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodproxy) throws Throwable {
                System.out.println("化妆");
                Object obj = method.invoke(jj, args);
                System.out.println("回家");
                return obj;
            }
        });

        //创建代理对象
        JJ jjProxy = (JJ)ehancer.create();
        //代理调用代理方法
        jjProxy.Singing();
        jjProxy.Talent();
    }


}
