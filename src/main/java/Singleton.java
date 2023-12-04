import java.util.HashMap;
import java.util.Map;

/**
 * @author yaosunique@gmail.com
 * 2023/9/6 14:07
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton() {

    }

    public Singleton getInstance() {

        if(instance==null){
            synchronized (Singleton.class) {
                if (instance == null) instance = new Singleton();
            }
        }
        return instance;
    }

}
