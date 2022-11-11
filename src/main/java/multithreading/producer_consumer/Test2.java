package multithreading.producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yao 2022/10/10
 *
 * ReentrantLock实现生产者消费者
 */
public class Test2 {
    private static Integer count = 0;
    private static final Integer FULL = 10;

    private Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        // new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        // new Thread(test2.new Consumer()).start();
    }

    class Producer implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //获取锁
            lock.lock();
            try {
                while (count.equals(FULL)) {
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName()
                        + "生产者生产，目前总共有" + count);
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                lock.lock();
                try {
                    while (count.equals(0)) {
                        try {
                            notEmpty.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
