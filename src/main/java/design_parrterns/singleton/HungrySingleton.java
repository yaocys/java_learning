package design_parrterns.singleton;

/**
 * 饿汉式的单例模式
 * @author yao 2022/12/8
 */
public class HungrySingleton {
    // 饿汉式在类加载时就实例化对象
    private static HungrySingleton hungrySingleton=new HungrySingleton();

    /**
     * 私有化构造方法，只有类本身可以创建实例
     */
    private HungrySingleton(){}

    /**
     * 公开暴露的方法可以让其他类获取到这个唯一实例
     * @return 本类的唯一实例
     */
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
