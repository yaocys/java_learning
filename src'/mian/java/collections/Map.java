package collections;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author yao 2022/9/26
 */
public class Map {

    private static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        // 向hashmap中插入数据，如果key的value值存在就会返回旧值写入新值覆盖
        map.put(1,"测试字符1");
        System.out.println(map.put(1,"覆盖测试字符1"));
        System.out.println(map.get(1));
        // 这个方法如果有旧值则不会覆盖
        map.putIfAbsent(1,"再测试覆盖");
        System.out.println(map.get(1));

        map.put(2,"测试字符2");
        map.put(3,"测试字符3");
        // 会返回被删除的key的value
        System.out.println(map.remove(2));
        // 这样只会返回true/false
        map.remove(3,"测试字符3");

        // 如果没有这个键，返回一个默认值
        System.out.println(map.getOrDefault(4,"#提示信息：没有这个键#"));

        System.out.println("打印集合元素========================");
        // 这里获取的是值集合，其实还可以获得键值对象
        /*for(Map.Entey<Integer,String> entey:map.entrySet()){

        }*/
        // Map.Entry仍然无法解析
        for(String s: map.values()){
            System.out.print(s+" ");
        }

        System.out.println();
        // 判断键值是否存在
        System.out.println(map.containsKey(4));
        System.out.println(map.containsValue("覆盖测试字符1"));

        // 存在的key跟put一样覆盖，不存在啥都不做
        System.out.println(map.replace(1,"测试替代"));
        // 是有迭代器的
        System.out.println("迭代器打印=========================");
        // 这里其实获取的是key的迭代器
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            int key = (Integer) iterator.next();
            System.out.println(key+":"+map.get(key));
        }
        // 还有一种对象的迭代器……好像不太行
        Iterator iterator1 = map.entrySet().iterator();/*
        while (iterator1.hasNext()){
            Map. entry = (Map.Entry) iterator1.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key+"="+value);
        }*/

        System.out.println();
        System.out.println("通过lambda表达式遍历=================");
        map.forEach((k,v)-> System.out.println(k+":"+v));
    }
}
