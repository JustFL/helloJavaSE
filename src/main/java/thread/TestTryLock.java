package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestTryLock {

    static private ReentrantLock baseLock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread("t1") {

            @Override
            public void run() {

                //为true表示获取锁成功
                boolean b = baseLock.tryLock();
                System.out.println(Thread.currentThread().getName() + "--------" +b);

                if (b) {

                    try {
                        System.out.println(Thread.currentThread().getName() + " start ...");
                        for (int i = 0; i < 20; i++) {
                            System.out.println(Thread.currentThread().getName() + "->" + i);
                        }
                    } finally {
                        baseLock.unlock();
                    }
                }
            }

        }.start();


        new Thread("t2") {

            @Override
            public void run() {

                boolean b = baseLock.tryLock();
                System.out.println(Thread.currentThread().getName() + "--------" +b);

                if (b) {


                    try {
                        System.out.println(Thread.currentThread().getName() + " start ...");
                        for (int i = 0; i < 20; i++) {
                            System.out.println(Thread.currentThread().getName() + "->" + i);
                        }
                    } finally {
                        baseLock.unlock();
                    }
                }
            }

        }.start();
    }
}
