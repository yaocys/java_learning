package design_parrterns.singleton;

/**
 * @author yao 2022/10/10
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null) instance = new Singleton();
            }
        }
        return instance;
    }
}
