package multithreading.increment_a_number;

/**
 * @author yao 2022/10/10
 */
public class RowTest {
    public int num =0;

    public void increase(){
        num++;
    }

    public static void main(String[] args) {
        final RowTest rowTest = new RowTest();
        for(int i = 0;i<100;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++) rowTest.increase();
            }).start();
        }
        while (Thread.activeCount()>1) Thread.yield();
        System.out.println(rowTest.num);
    }
}
