package multithreading.increment_a_number;

/**
 * @author yao 2022/10/10
 *
 * 由于没法保证线程的执行顺序，即没法保证上一个线程执行完了下一个线程再在上一个进程的结果上继续递增
 * 会导致结果始终小于预期
 */
public class VolatileTest {

     public int num = 0;
     // AtomicInteger num = new AtomicInteger(0);
    public void increase(){
        num++;
        // num.incrementAndGet();
    }

    public static void main(String[] args) {
        final VolatileTest volatileTest= new VolatileTest();
        for(int i = 0;i<100;i++){
            new Thread(()->{
                int a = 0;
                for(int j=0;j<1000;j++) volatileTest.increase();
            }).start();
            // System.out.println(volatileTest.num);
        }
        // System.out.println(Thread.activeCount());
/*        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++)
            System.out.println("线程号：" + i + " = " + lstThreads[i].getName());*/
        while (Thread.activeCount()>1) Thread.yield();
        System.out.println(volatileTest.num);
    }
}
