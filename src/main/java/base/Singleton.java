package base;

/**
 * 单例模式写法思路
 * 只生成一个实例的话 就不能让其他人调用构造方法 所以第一步先将构造器private
 * 这样之后 所有人除了自己都不能创建实例了 所以需要预先创建好一个实例 将这个实例作为成员变量
 * 然后写一个方法 获得这个实例 但是想要调用方法就必须需要这个类的实例 现在没有构造器无法构建实例 所以将方法置为static 使用类名来直接调用方法
 * 因为方法为static 想要返回这个实例 实例也必须为static 这样通过这个方法中的判断就可以控制只有一个实例
 * 当获得这个实例后 为了保证安全 所以将这个成员变量置为private
 * @author summerKiss
 *
 */

class Hungry{
    private static Hungry h = new Hungry();
    private Hungry() {}
    public static Hungry getInstance() {
        return h;
    }
}

class Lazy{
    private static Lazy l = null;
    private Lazy() {}
    public static Lazy getInstance() {
        if (l == null) {
            l = new Lazy();
        }
        return l;
    }
}

class StandLazy{
    private static StandLazy s = null;
    private StandLazy() {}
    public static StandLazy getInstance() {
        if (s == null) {
            synchronized (s.getClass()) {
                if (s == null) {
                    s = new StandLazy();
                }
            }
        }
        return s;
    }
}

public class Singleton {
    public static void main(String[] args) {
        Hungry h1 = Hungry.getInstance();
        Hungry h2 = Hungry.getInstance();
        Hungry h3 = Hungry.getInstance();
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);

        Lazy l1 = Lazy.getInstance();
        Lazy l2 = Lazy.getInstance();
        Lazy l3 = Lazy.getInstance();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }
}
