package design_parrterns.singleton;

/**
 * 懒汉模式单例
 * @author yao 2022/12/8
 */
public class LazySingleton {

    // 懒汉模式不在类初始化时实例化对象
    private static LazySingleton lazySingleton;

    /**
     * 这个写出来其实就只是为了加个private
     * 当然这么说只是因为构造方法没有参数
     */
    private LazySingleton(){}

    public LazySingleton getInstance(){
        // 只有在被调用的时候才会实例化对象，而且只会被实例化一次
        if(lazySingleton==null) lazySingleton = new LazySingleton();
        return lazySingleton;
    }
}
