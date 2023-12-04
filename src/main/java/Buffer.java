import java.util.ArrayList;
import java.util.Queue;

/**
 * @author yaosunique@gmail.com
 * 2023/8/28 13:53
 */
public class Buffer {
    private final int maxCapacity;
    private final int minCapacity;
    Queue<Product> buffer;

    public Buffer(int maxCapacity, int minCapacity, Queue<Product> buffer) {
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.buffer = buffer;
    }

    public synchronized void push(Product product){
        if(buffer.size()==maxCapacity){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        buffer.offer(product);
    }

    public synchronized Product pop(){
        if(buffer.size()<minCapacity){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return buffer.poll();
    }
}
