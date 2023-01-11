package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 显式创建和释放同步锁
 * 使用ReentrantLock对象的lock()和unlock()方法*/
class ThreadTicket implements Runnable{
    private int sum = 20;

    //可重入锁
    //公平锁指的是初始化参数true 表示在释放锁的时候 由等待时间最长的线程来获取锁
    private ReentrantLock lock = new ReentrantLock(true);

    //synchronized public void saleTicket(){
    public void saleTicket(){
        try {
            lock.lock();
            sum = sum - 1;
            System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余票数为："+sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }


    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            saleTicket();
        }
    }
}

public class TestReentrantLock {

    public static void main(String[] args) {
        ThreadTicket tt = new ThreadTicket();
        Thread t1 = new Thread(tt,"窗口一");
        Thread t2 = new Thread(tt,"窗口二");
        t1.start();
        t2.start();

    }

}
