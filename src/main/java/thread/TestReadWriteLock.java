package thread;

/**
 *
 * 这个读写锁 同一时间只能有一把琐
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    static private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static void read() {
        try {
            lock.readLock().lock();
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "正在读" + i + "次");
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    static void write() {
        try {
            lock.writeLock().lock();
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "正在写" + i + "次");
            }
        } finally {
            lock.writeLock().unlock();
        }

    }

    public static void main(String[] args) {

        new Thread("t1") {

            @Override
            public void run() {
                read();
                write();
            }

        }.start();

        new Thread("t2") {

            @Override
            public void run() {
                read();
                write();
            }

        }.start();

    }
}
