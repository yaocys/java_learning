package multithreading.loop_print;


import org.junit.jupiter.api.Test;

/**
 * @author yao 2022/10/6
 *
 * 通过一个锁+状态变量实现
 */
public class StateLockPrinter {
    private volatile int state = 0;

    private class Printer implements Runnable{

        private static final int PRINT_COUNT = 10;

        private final Object printLock;

        //打印标志位 和state变量相关
        private final int printFlag;
        //后继线程的线程的打印标志位，state变量相关
        private final int nextPrintFlag;
        //该线程的打印字符
        private final char printChar;
        public Printer(Object printLock, int printFlag,int nextPrintFlag, char printChar) {
            this.printLock = printLock;
            this.printFlag=printFlag;
            this.nextPrintFlag=nextPrintFlag;
            this.printChar = printChar;
        }

        @Override
        public void run() {
            synchronized (printLock){
                for(int i=0;i<PRINT_COUNT;i++){
                    while (state!=printFlag) {
                        try {
                            printLock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.print(printChar);
                    state = nextPrintFlag;
                    printLock.notifyAll();
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException{
        Object lock = new Object();
        Thread threadA = new Thread(new Printer(lock,0,1,'A'));
        Thread threadB = new Thread(new Printer(lock,1,2,'B'));
        Thread threadC = new Thread(new Printer(lock,2,0,'C'));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
