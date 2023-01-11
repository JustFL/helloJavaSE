package thread;

/**
 * 进程：是代码在数据集合上的一次运行活动 是系统进行资源分配和调度的基本单位
 线程：是进程的一个执行路径 一个进程中至少有一个线程 进程中的多个线程共享进程的资源
 虽然系统是把资源分给进程 但是CPU很特殊 是被分配到线程的 所以线程是CPU分配的基本单位
 一个进程中有多个线程 多个线程共享进程的堆和方法区资源 但是每个线程有自己的程序计数器和栈区域

 程序计数器：是一块内存区域 用来记录线程当前要执行的指令地址
 栈：用于存储该线程的局部变量 这些局部变量是该线程私有的 除此之外还用来存放线程的调用栈祯

 堆：是一个进程中最大的一块内存 堆是被进程中的所有线程共享的
 方法区：则用来存放 NM 加载的类 常量及静态变量等信息 也是线程共享的

 线程状态
 1>新建
 2>就绪 调用了start()方法 表示准备好了 等待cpu的调用 就绪状态是运行状态的唯一入口
 3>运行 cpu调用了这个线程
 4>阻塞 正在运行的线程暂停了执行 分为3种阻塞状态
 1>同步synchronized 相当于排队
 2>等待wait
 3>其他sleep
 5>死亡
 */




public class ThreadBase {

    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.run();

        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r, "a");
        Thread t2 = new Thread(r, "b");
        Thread t3 = new Thread(r, "c");
        Thread t4 = new Thread(r, "d");
        Thread t5 = new Thread(r, "f");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

/**
 * java多线程的实现方法
 * 1 继承Thread类 重写run方法 因为是Thread的子类 所以直接可以调用start()方法 并且直接可以使用this关键字使用线程的属性
 * 2 实现Runnable接口 重写run方法 因为不是Thread的子类 所以初始化时需要Thread t1 = new Thread(t, "a"); 并且线程的属性需要使用Thread.currentThread()来使用属性
 */
class MyThread extends Thread{

    //自定义线程类 线程功能写在run()方法里
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + i);
        }
    }

}

class MyRunnable implements Runnable{
    private int count = 5;

    /**
     *  synchronized 的内存语义：
     这个内存语义就可以解决共享变量内存可见性问题
     进入synchronized块的内存语义是把在synchronized块内使用到的变量从线程的工作内存中清除
     这样在synchronized块内使用到该变量时就不会从线程的工作内存中获取，而是直接从主内存中获取
     退出synchronized块的内存语义是把在synchronized块内对共享变量的修改刷新到主内存
     会造成上下文切换的开销 独占锁 降低并发性


     Volatile的理解：
     该关键字可以确保对一个变量的更新对其他线程马上可见
     当一个变量被声明为volatile时 线程在写入变量时不会把值缓存在寄存器或者其他地方 而是会把值刷新回主内存
     当其他线程读取该共享变量时 会从主内存重新获取最新值 而不是使用当前线程的工作内存中的值
     volatile的内存语义和synchronized有相似之处
     具体来说就是 当线程写入了volatile变量值时就等价于线程退出synchronized同步块（把写入工作内存的变量值同步到主内存）
     读取volatile变量值时就相当于进入同步块（先清空本地内存变量值，再从主内存获取最新值）
     但是最重要的是它不能保证原子性
     */
    synchronized public void run() {
        count--;
        System.out.println("当前线程:" + Thread.currentThread().getName() + " count:" + count);
    }
}