package multithreading.producer_consumer;

/**
 * @author yao 2022/10/9
 *
 * 通过wait-notify的方式实现生产者-消费者模式
 * 每一次生产/消费后都会退出同步代码块，出让锁，但是并没有退出循环
 * 也就是说，每生产/消费一次后都会重新竞争锁
 * while是必须的，每次拿到锁都检查条件，就算只有一个生产一个消费也很有可能是连续抢到了
 * 如果只有两个线程，那就可以用notify替代notifyAll
 */
public class Test1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static final Object lock = new Object();

    static class Producer implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock){
                    while (count.equals(FULL)){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，目前共有"+count+"件产品");
                    lock.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock){
                    // 可能被其他任意线程唤醒，而这里的生产消费者都不止一个，可能再次被唤醒时仍然不满足条件
                    // 也就是每次被唤醒都检查条件
                    while (count.equals(0)){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费，目前共有"+count+"件产品");
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 其实从这里总共打印的记录数也能够看出其实是接着继续执行的
        Test1 test1 = new Test1();
        new Thread(new Producer(),"生产1").start();
        new Thread(new Consumer(),"消费1").start();
        new Thread(new Producer(),"生产2").start();
        new Thread(new Consumer(),"消费2").start();
        new Thread(new Producer(),"生产3").start();
        new Thread(new Consumer(),"消费3").start();
        new Thread(new Producer(),"生产4").start();
        new Thread(new Consumer(),"消费4").start();
    }
}
