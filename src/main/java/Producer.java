import java.util.Queue;
import java.util.Random;

/**
 * @author yaosunique@gmail.com
 * 2023/8/28 13:08
 */
public class Producer implements Runnable {
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0;i<200;i++){
            Product product = new Product(String.valueOf(i));
            buffer.push(product);
            System.out.println("生产了："+i);
        }
    }
}
