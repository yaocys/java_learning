package multithreading.increment_a_number;

/**
 * @author yao 2022/10/10
 */
public class SynchronizedTest {
    public int num = 0;

    public synchronized void increase(){
        num++;
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        for(int i =0;i<100;i++){
            new Thread(()->{
                for(int j=0;j<100;j++) synchronizedTest.increase();
            }).start();
        }
        while (Thread.activeCount()>1) Thread.yield();
        System.out.println(synchronizedTest.num);
    }
}
