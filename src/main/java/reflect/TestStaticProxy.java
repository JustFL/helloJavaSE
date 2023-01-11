package reflect;


/**
 * 代理模式实现了目标对象在被访问之前或者访问之后的预处理 过滤等操作 代理实现了对目标的访问控制
 * 静态代理 在编译阶段创建代理类 在代理类中为需要访问的方法设置代理方法 */
interface Person{
    void Singing();
    void Talent();
}

//唱片公司 作为代理
class Warner implements Person{

    //华纳旗下的艺人
    private Person star;

    public Warner(Person p) {
        this.star = p;
    }

    public Person getStar() {
        return star;
    }

    public void setStar(Person star) {
        this.star = star;
    }

    @Override
    public void Singing() {
        System.out.println("化妆");
        star.Singing();
        System.out.println("回家");
    }

    @Override
    public void Talent() {
        System.out.println("找灵感");
        star.Talent();
        System.out.println("休息");
    }

}

class JJ implements Person{

    @Override
    public void Singing() {
        System.out.println("JJ唱曹操");
    }

    @Override
    public void Talent() {
        System.out.println("JJ弹钢琴");

    }

}

class Jay implements Person{

    @Override
    public void Singing() {
        System.out.println("Jay唱世界末日");

    }

    @Override
    public void Talent() {
        System.out.println("Jay作曲");

    }

}

public class TestStaticProxy {
    public static void main(String[] args) {

        JJ jj = new JJ();
        Jay jay = new Jay();
        //为JJ代理
        Warner w = new Warner(jj);
        w.Singing();

        //为Jay代理
        w.setStar(jay);
        w.Talent();

    }
}
