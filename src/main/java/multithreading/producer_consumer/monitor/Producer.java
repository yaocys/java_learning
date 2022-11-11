package multithreading.producer_consumer.monitor;

/**
 * @author yao 2022/10/9
 */
public class Producer implements Runnable{
    Container container;
    public Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("生产第 "+i+" 个产品");

        }
    }
}
