package base;

enum Season{
    //下面的东西是Season类型的4个对象
    //相当于private static final javaSE.Base.Season Spring = new Base.Season(); 和单例模式一样在类中直接创建了类的对象
    //在类外无法创建对象
    Spring,Summer,Autumn,Winter;

    //枚举类型可以定义其他的实例变量
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private Season() {
    }

    //可以定义构造器 但是是私有的
    private Season(int n) {
        this.n = n;
    }

    //枚举类型可以定义其他的实例方法
    public void show() {
        System.out.println(this.getN());
    }
}

class Vacation{
    private Season season;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}

public class TestEnum {

    public static void main(String[] args) {
        Vacation v = new Vacation();
        Season.Spring.setN(123);
        v.setSeason(Season.valueOf("Spring"));
        System.out.println(v.getSeason());
        v.getSeason().show();
    }

}
