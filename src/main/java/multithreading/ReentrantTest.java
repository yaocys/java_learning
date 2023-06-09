package multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断测试
 *
 * @author yaosunique@gmail.com
 * 2023/3/31 17:50
 */
public class ReentrantTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args){
        Thread t1 = new Thread(() -> {
            try {
                /*
                如果没有竞争此方法会获取lock对象锁
                有竞争就进入阻塞队列，但是可以被其他线程用interrupt()方法打断
                 */
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("没有获得锁，返回");
                return;
            }
            try {
                System.out.println("获取到锁");
            } finally {
                lock.unlock();
            }
        }, "testThread");

        lock.lock();

        t1.start();
        System.out.println("打断t1");
        t1.interrupt();

    }
}
