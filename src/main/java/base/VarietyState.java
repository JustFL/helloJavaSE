package base;

/**
 * 多态 同一个引用类型 使用不同的实例而执行不同的操作
 *
 * 特点：
 * 1>必须有继承或实现关系 进行方法重写
 * 2>父类引用指向子类对象
 *   接口引用指向实现类对象
 *
 *   使用多态会屏蔽子类之间的差异 只能调用父类中共同的内容
 *
 *   多态多数用在参数或者返回值
 * @author summerKiss
 *
 */

class Pet{
    private String name;
    Pet(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void eat() {
        System.out.println("Base.Pet "+name+"is eating");
    }
}

class Dog extends Pet{
    Dog(String name){
        super(name);
    }
    public void eat() {
        System.out.println("Base.Dog is eating");
    }
    public void run() {
        System.out.println("Base.Dog is runing");
    }
}

class Cat extends Pet{
    Cat(String name){
        super(name);
    }
    public void eat() {
        System.out.println("Base.Cat is eating");
    }
    public void play() {
        System.out.println("Base.Cat is playing");
    }
}


class PetHospital{
    //参数多态 参数使用父类的引用 可以传入任意的子类对象
    public void treadment(Pet pet) {
        System.out.println(pet.getName()+"的病治好了");
        System.out.println(pet.getClass());
        if (pet instanceof Dog) {
            Dog dog = (Dog)pet;
            dog.run();
        }else {
            Cat cat = (Cat)pet;
            cat.play();
        }
    }
}



public class VarietyState {
    public static void main(String[] args) {
        Dog wangwang = new Dog("旺旺");
        Cat miaomiao = new Cat("喵喵");
        PetHospital p = new PetHospital();
        p.treadment(wangwang);
        p.treadment(miaomiao);
    }
}
