package base;

/**
 * 这个类展示类的初始化过程
 * @author summerKiss
 *
 * object-oriented
 * 若类的代码中没有构造器 系统会提供一个默认的无参数的构造器
 * e.g
 * public Base.Fish(){}
 * 若是代码中有构造器 则这个默认构造器消失
 * 若本类的构造器之间相互调用 必须使用this()这种形式
 * e.g
 * public Base.Fish(){
 * }
 * public Base.Fish(int age){
 * 	this();//这是一个无参构造器 必须在其他构造器中使用 并且必须在第一行调用
 *  this.age = age;
 * }
 */

class Fish{

    //成员变量 系统会首先根据类型自动赋予初始值 这叫做默认初始化 null可以赋给所有的引用类型
    String color = "green";
    int age = 10;//声明处初始化

    //构造块中初始化 在创建对象时自动调用 优先构造器调用
    //但是和声明处的初始化看代码顺序
    {
        age = 20;
        color = "red";
    }

    //构造器中初始化
    public Fish() {
        this.age = 40;
        System.out.println("this is father");
    }

    public void setAge(int age) {
        //this表示当前类的对象 谁调用这个方法 那个对象就是this
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Base.Fish [color=" + color + ", age=" + age + "]";
    }
}

class Grass extends Fish{
    //不论子类是否有自定义构造器 都会在构造器中隐式调用super()即父类的无参构造器 如果父类中自定义了其他有参构造器 导致无参数的构造器消失的话 会报错
    //换言之 如果父类中只有自定义的有参构造器 则子类必须显式调用父类的这个有参构造

    public Grass() {
        System.out.println("this is son");
    }
}


public class TestInit {
    public static void main(String[] args) {
        Fish f = new Fish();
        System.out.println(f);
        System.out.println("-------------");

        Grass g = new Grass();
        System.out.println(g);
    }
}
