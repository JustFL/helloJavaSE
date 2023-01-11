package thread;
/**
 * sleep(时间)放弃cpu使用权 没有放弃锁
 * wait(时间)放弃cpu使用权 也放弃锁
 * wait()可以没有参数 表示一直等待 需要使用notify()去唤醒
 * */
class WaitFunction implements Runnable{
    private int i = 10;
    @Override
    synchronized public void run() {
        for (; i >= 0; i--) {
            if(i == 5 && Thread.currentThread().getName().equals("t1")) {
                try {
                    //Thread.sleep(1000);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i == 3) {
                //唤醒等待池中的任意一个进程 唤醒后进入锁定池中等待获取同步锁
                notify();
                //唤醒所有线程
                //notifyAll();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

}

public class ThreadWait {

    public static void main(String[] args) {
        WaitFunction wf = new WaitFunction();
        Thread t1 = new Thread(wf,"t1");
        Thread t2 = new Thread(wf,"t2");
        t1.start();
        t2.start();

    }

}
