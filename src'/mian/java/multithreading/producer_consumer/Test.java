package multithreading.producer_consumer;

/**
 * @author yao 2022/10/9
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue(10);
        PutThread putThread = new PutThread(queue);
        GetThread getThread = new GetThread(queue);
        new Thread(putThread).start();
        Thread.sleep(100);
        new Thread(getThread).start();
    }
}
