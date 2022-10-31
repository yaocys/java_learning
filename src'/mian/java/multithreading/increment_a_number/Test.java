package multithreading.increment_a_number;

/**
 * @author yao 2022/10/10
 */
public class Test {

/*    class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println(a);
        }
    }*/

    public static void main(String[] args) {
        int a = 10;
        new Thread(()->{
            System.out.println(a);
        }).start();
    }
}
