package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * 过滤器
 * */
class Avenger{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return name + "," + age;
    }
    public Avenger() {

    }
    public Avenger(int age,String name) {
        this.age = age;
        this.name = name;
    }
}

public class TestPredicate {
    public void check(List<Avenger> list, Predicate<Avenger> p) {
        for (Avenger avenger : list) {
            if (p.test(avenger)) {
                //利用Predicate接口中的test方法进行过滤 满足条件的进行输出
                System.out.println(avenger);
            }
        }
    }

    public static void main(String[] args) {
        Avenger a1 = new Avenger(38, "Tony Stark");
        Avenger a2 = new Avenger(42, "Steve Rogers");
        Avenger a3 = new Avenger(1139, "Thor");
        List<Avenger> list = new ArrayList<>();
        Collections.addAll(list, a1,a2,a3);

        TestPredicate tp = new TestPredicate();
        tp.check(list, a->a.getAge()>=40 && a.getName().contains("T"));
    }

}
