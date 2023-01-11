package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//实现了比较接口
class Tree implements Comparable<Tree>{
    private int age;
    private int height;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Tree(int age, int height) {
        super();
        this.age = age;
        this.height = height;
    }
    @Override
    public String toString() {
        return "Base.Tree [age=" + age + ", height=" + height + "]";
    }
    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }

}

public class TestCompare {
    public static void main(String[] args) {
        Tree t1 = new Tree(60, 20);
        Tree t2 = new Tree(50, 40);
        List<Tree> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);

        Collections.sort(list);
        System.out.println(list);

        //比较器
        Collections.sort(list, new Comparator<Tree>() {

            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.getHeight() - o2.getHeight();
            }
        });
        System.out.println(list);

        //比较器lambda写法
        Collections.sort(list, (o1,o2)->o1.getHeight() - o2.getHeight());
        System.out.println(list);
    }
}
