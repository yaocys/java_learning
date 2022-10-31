package multithreading.increment_a_number;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yao 2022/10/10
 */
public class LockTest {
    public int num;
    ReentrantLock lock = new ReentrantLock();

    public void increase(){
        lock.lock();
        try {
            num++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        for(int i = 0;i<100;i++){
            new Thread(()->{
                for(int j = 0;j<100;j++) lockTest.increase();
            }).start();
        }
        while (Thread.activeCount()>1) Thread.yield();
        System.out.println(lockTest.num);
    }
}
