package thread;

public class ThreadSleep {
    public static void main(String[] args) {

        ThreadDemo1 threadDemo1 = new ThreadDemo1("A");
        threadDemo1.start();

        RunnableDemo1 runnable1 = new RunnableDemo1();
        Thread thread = new Thread(runnable1, "B");
        thread.start();
    }
}

/**
 * sleep方法 从运行状态进入TIMED_WAITING状态(释放CPU, 占用锁)
 */
class ThreadDemo1 extends Thread{

    public ThreadDemo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println(this.getName() + "-" + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableDemo1 implements Runnable{
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread().getName() + "-" + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}