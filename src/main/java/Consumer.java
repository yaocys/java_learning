import java.util.Queue;

/**
 * @author yaosunique@gmail.com
 * 2023/8/28 13:10
 */
public class Consumer implements Runnable {
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i =0;i<200;i++){
            Product product = this.buffer.pop();
            System.out.println("消费了："+product.getName());
        }
    }
}
