package multithreading.increment_a_number;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yao 2022/10/10
 */
public class AtomicTest {
    public AtomicInteger num = new AtomicInteger(0);
    public void increase(){
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        for(int i = 0;i<100;i++){
            new Thread(()->{
                for(int j = 0;j<100;j++) atomicTest.increase();
            }).start();
        }
        while (Thread.activeCount()>1) Thread.yield();
        System.out.println(atomicTest.num);
    }
}
