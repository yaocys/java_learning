package multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个简单的多线程实验
 * 1. 首先我们复习下Java中怎么创建线程
 *
 * @author yaosunique@gmail.com
 * 2023/3/30 23:52
 */
public class CreateThread {

    private static final ReentrantLock lock = new ReentrantLock();

    static int count = 0;// 一个全局共享变量

    /**
     * 一个线程内部类
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        thread1.join(); // 等待 thread1 执行完成
        thread2.join(); // 等待 thread2 执行完成
        System.out.println(count);
    }
}
