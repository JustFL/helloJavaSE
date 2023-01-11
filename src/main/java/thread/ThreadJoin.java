package thread;

/**
 *
 * @author Administrator
 * join t1.join()方法只会使主线程进入等待池并等待t1线程执行完毕后才会被唤醒。并不影响同一时刻处在运行状态的其他线程。
 * join()方法的底层是利用wait()方法实现的。
 * join方法是一个同步方法，当主线程调用t1.join()方法时，主线程先获得了t1对象的锁，随后进入方法，调用了t1对象的wait()方法，使主线程进入了t1对象的等待池，
 *  此时，A线程则还在执行，并且随后的t2.start()还没被执行，
 *  因此，B线程也还没开始。等到A线程执行完毕之后，主线程继续执行，走到了t2.start()，B线程才会开始执行。
 *
 *
 *  另外一种解释:
 *  t1.join()表示t1线程加入 当主线程正在执行的时候 遇到了t1线程的加入 则主线程先停止执行 等待加入的线程t1执行完成后 再继续执行
 */

public class ThreadJoin {
    public static void main(String[] args) {
        ThreadDemo2 t1 = new ThreadDemo2("A");
        ThreadDemo2 t2 = new ThreadDemo2("B");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        System.out.println("主线程结束");
    }
}

class ThreadDemo2 extends Thread {

    public ThreadDemo2(String name) {
        super(name);
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "-" + i);
        }
    }
}