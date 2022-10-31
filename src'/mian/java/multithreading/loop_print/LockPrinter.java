package multithreading.loop_print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yao 2022/10/10
 */
public class LockPrinter implements Runnable {

    private static final int PRINT_COUNT = 10;

    private final ReentrantLock lock;

    private final Condition thisCondition;
    private final Condition nextCondition;
    private final char printChar;

    public LockPrinter(ReentrantLock lock, Condition thisCondition, Condition nextCondition, char printChar) {
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.print(printChar);
                nextCondition.signal();
                if (i < PRINT_COUNT - 1) {
                    try {
                        thisCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread printerA = new Thread(new LockPrinter(lock, conditionA, conditionB, 'A'));
        Thread printerB = new Thread(new LockPrinter(lock, conditionB, conditionC, 'B'));
        Thread printerC = new Thread(new LockPrinter(lock, conditionC, conditionA, 'C'));

        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();
    }
}