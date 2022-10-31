package multithreading.producer_consumer;

import collections.List;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author yao 2022/10/9
 *
 * 缓存类
 */
public class Queue {

    final int num;
    final ArrayList<String> list;
    boolean isFull = false;
    boolean isEmpty = true;

    public Queue(int num){
        this.num = num;
        this.list = new ArrayList<>();
    }

    public synchronized void put(String value){
        try {
            if (isFull) {
                System.out.println("队列满了，生产者等待并让出了（队列）锁");
                this.wait();
                System.out.println("生产者被唤醒了，拿到了（队列的）锁");
            }

            list.add(value);
            System.out.println("仓库中添加了：" + value);

            // 修改两个标志位
            if (list.size() >= num) isFull = true;
            if (isEmpty) {
                isEmpty = false;
                System.out.println("仓库不空了，通知消费者消费产品");
                this.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String get(int index){
        try {
            if (isEmpty) {
                System.err.println("仓库是空的，消费者停止并并让出了（队列的）锁");
                this.wait();
                System.err.println("消费者被唤醒了，拿到了（队列的）锁");
            }

            String value = list.get(index);
            System.err.println("消费者消费了" + value);
            list.remove(index);

            // 这里在干嘛？为什么要随机清空仓库？
/*            Random random = new Random();
            int randomInt = random.nextInt(5);
            if (randomInt == 1) {
                System.err.println("随机数等于1， 清空集合");
                list.clear();
            }*/

            if (getSize() < num) {
                if (getSize() == 0) isEmpty = true;
                if (isFull) {
                    isFull = false;
                    System.err.println("消费者通知生产者，有空间可以继续生产了");
                    this.notify();
                }
            }
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSize() {
        return list.size();
    }
}
