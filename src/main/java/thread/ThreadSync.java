package thread;
/**
 * 当多个线程调用同一个对象的同一个方法时
 * 希望一个线程在调用的时候 其他线程不要来打扰
 * 这时可以对对象加一个同步锁 这样只有在一个线程执行完方法时 其他线程才可以执行此方法
 * 两种加锁的方式
 * 1>同步代码块
 * 2>同步方法
 * 两种方法锁的都是对象this
 * */

//实现Runnable有利于资源的共享
class Bank implements Runnable{
    private int money = 0;
    //synchronized public void setMoney(){
    public void setMoney(){
        money += 100;
        System.out.println(Thread.currentThread().getName()+"存了100元，余额为"+money+"元");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            //同步代码块 给当前对象加同步锁
            synchronized (this) {
                setMoney();
            }

        }
    }
}

public class ThreadSync {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread t1 = new Thread(bank,"Tony Stark");
        Thread t2 = new Thread(bank,"Bruse Banner");
        t1.start();
        t2.start();

    }

}
