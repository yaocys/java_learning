package writen_examination;

/**
 * @author yao 2022/9/21
 *
 * 默认初始化顺序本应是：
 * 1. （静态变量）静态代码块
 * 2. main()
 * 3. 构造代码块
 * 4. 构造方法
 */
public class Demo {
    static int count1 = 0;
    static int count2 = 1;
    static int count3 = 3;

    static {
        System.out.println("静态代码块执行此时count3="+count3);
        count3++;
    }
    private static Demo demo = new Demo();
    private Demo(){
        System.out.println("构造函数执行，此时：");
        System.out.println(count1+" "+count2+" "+count3);
        count1++;
        count2++;
        ++count3;
    }

    static Demo getInstance(){
        return demo;
    }

    public static void main(String[] args) {
        // 在实例化之前。类加载时就分配了所有的静态变量
        // 1,2,5
        Demo demo1 = Demo.getInstance();

        System.out.println("count1="+demo1.count1);
        System.out.println("count2="+demo1.count2);
        System.out.println("count3="+demo1.count3);
    }
}
