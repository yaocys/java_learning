package multithreading.loop_print;

/**
 * @author yao 2022/10/5
 *
 * 基于两个锁实现循环打印a、b、c
 */
public class TwoLockPrinter implements Runnable{
    private static final int PRINT_COUNT =10;

    private final Object frontLock;
    private final Object thisLock;

    private final char printChar;

    public TwoLockPrinter(Object frontLock,Object thisLock,char printChar){
        this.frontLock = frontLock;
        this.thisLock = thisLock;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        for(int i = 0;i<PRINT_COUNT;i++){
            synchronized (frontLock){
                synchronized (thisLock){
                    System.out.print(printChar);
                    // 这里先释放了当前锁，唤醒，再释放了前锁，确保了不会是自己又抢到了
                    thisLock.notify();
                }
                if(i<PRINT_COUNT-1){
                    try {
                        // 这里强制出让，也保证了不会是自己抢到
                        frontLock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();

        Thread threadA = new Thread(new TwoLockPrinter(lockC,lockA,'A'));
        Thread threadB = new Thread(new TwoLockPrinter(lockA,lockB,'B'));
        Thread threadC = new Thread(new TwoLockPrinter(lockB,lockC,'C'));

        threadA.start();
        Thread.sleep(100); // 确保按顺序A、B、C执行
        threadB.start();
        Thread.sleep(100);
        threadC.start();
        Thread.sleep(100);
    }
}
