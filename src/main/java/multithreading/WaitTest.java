package multithreading;

/**
 * @author yao 2022/10/9
 *
 * 测试wait()被重新唤醒后，是否继续执行
 */
public class WaitTest {
    private synchronized void count(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if(i == 5){
                try {
                    System.out.println("进入 wait 状态...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitTest waitTest = new WaitTest();

        new Thread(waitTest::count).start();
        Thread.sleep(2000);

        synchronized (waitTest){
            System.out.println("唤醒线程...");
            waitTest.notifyAll();
        }
    }
}
