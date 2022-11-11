package multithreading.producer_consumer;

/**
 * @author yao 2022/10/9
 */
public class PutThread implements Runnable{
    Queue queue;

    public PutThread(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            queue.put(i+"号");
        }
    }
}
