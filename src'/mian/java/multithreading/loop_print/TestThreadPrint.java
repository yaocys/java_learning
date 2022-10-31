package multithreading.loop_print;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yao 2022/10/6
 */
public class TestThreadPrint {

    private class RandomPrinter implements Runnable{

        char printChar;

        public RandomPrinter(char printChar){
            this.printChar = printChar;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.print(printChar);
            }
        }
    }

    @Test
    public void testRandomPrinter(){
        Thread threadA = new Thread(new RandomPrinter('A'));
        Thread threadB = new Thread(new RandomPrinter('B'));
        Thread threadC = new Thread(new RandomPrinter('C'));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static class Printer implements Runnable{

        private static final int PRINT_COUNT = 10;

        final Object lock;
        char printChar;

        public Printer(Object lock,char printChar){
            this.printChar = printChar;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
                for(int i=0;i<15;i++){
                    System.out.print(printChar);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Test
    public void test(){
        ReentrantLock lock = new ReentrantLock();

        Thread threadA = new Thread(new Printer(lock,'A'));
        Thread threadB = new Thread(new Printer(lock,'B'));
        Thread threadC = new Thread(new Printer(lock,'C'));
        threadA.start();
        threadB.start();
        // threadC.start();
    }
}
