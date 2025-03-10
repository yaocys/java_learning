/*
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CollectSubSet {

    public static List<List<T>> subSetList;
    private static List<T> temp;

    */
/**
     * 回溯
     *//*

    private static <T>void backTrace(Collection<T> completesSet, int k, int index) {
        int n = completesSet.size();
        if (temp.size() + n - index + 1 < k) return;
        if (temp.size() == k) {
            subSetList.add(temp);
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(completesSet.);
            backTrace(completesSet, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    */
/**
     * 需要实现的集合取子集算法，穷举出所有子集
     *//*

    public static <T> Collection<List<T>> calculateSubSet(Collection<T> completesSet, int subSetSize) {
        backTrace(completesSet, subSetSize, 1);
        return subSetList;
    }

    public static void main(String[] args) {

        //全集
        List<String> completesSet = new ArrayList<>();
        //初始化全集
        for (int i = 1; i <= 100; i++) {
            completesSet.add(i + "");
        }
        //子集大小
        int subSetSize = 10;

        //todo 编写从全集中生成指定大小的子集算法
        //1、需要输出指定大小的所有子集的可能
        //示例：全集[1,2,3,4,5] 子集大小 3
        //则需输出[1,2,3]、[1,2,4]、[1,2,5]、[2,3,4]、[2、3、4]、[3、4、5]
        //2、方法入参是全集和子集大小，返回值不限制，可自由定义
        //3、算法是穷举法，所以时间复杂度是固定的，不需要优化时间复杂度
        //4、不允许改变入参的全集大小100与子集大小10，并且代码运行不能报错
        //5、结果集输出打印的同时需要考虑可以被后续业务使用

        calculateSubSet(completesSet, subSetSize);
        //todo 如何用System.out.print输出每一个子集需要自己思考

        for (List subSet : sebSetList) {
            System.out.println(subSet);
        }
    }
}
*/
