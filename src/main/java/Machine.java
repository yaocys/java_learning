import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yaosunique@gmail.com
 * 2023/8/29 15:41
 */
public class Machine {

    int bandNum;
    int capacity;

    // 品牌，对应一个数组，数组对应了容量
    TreeMap<Integer, ArrayList<Integer>> store;

    public Machine(int bandNum, int capacity) {
        this.bandNum = bandNum;
        this.capacity = capacity;
    }

    public boolean add(int band, int ids[]) {
        // 检查TreeMap的key
        if (store.containsKey(band)) {
            if (store.get(band).size() + ids.length <= capacity) {
                for (int num : ids) {
                    store.get(band).add(num);
                }
                return true;
            }
        } else {
            if (store.keySet().size() < bandNum) {
                // 添加一个新品牌货道
                store.put(band,new ArrayList<>());
                for (int num : ids) {
                    store.get(band).add(num);
                }
            }
        }
        return false;
    }

    public int[] buy(int band, int num) {
        if (store.containsKey(band)) {
            if (store.get(band).size() >= num) {
                int[] res = new int[num];
                // 从数组中删除商品
                for(int i =0;i<num;++i){
                    res[i] = store.get(band).remove(0);
                }
                // 返回一个商品列表
                return res;
            }
        }
        return null;
    }

    public ArrayList<Integer> list() {
        ArrayList<Integer> res = new ArrayList<>();
        // 遍历每一个map元素并返回第一个
        for (int i = 0; i < store.size(); i++) {
            res.add(store.get(i).get(0));
        }
        return res;
    }
}
