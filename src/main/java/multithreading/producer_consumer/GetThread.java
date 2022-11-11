package multithreading.producer_consumer;

/**
 * @author yao 2022/10/9
 */
public class GetThread implements Runnable{
    Queue queue;

    public GetThread(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            for (int i = 0; i < queue.getSize(); i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String value = queue.get(i);
            }
        }
    }
}
