package sort.impl;

import sort.Sort;

import java.util.ArrayList;

/**
 * @author yaocy yaosunique@gmail.com
 * 2023/1/28 17:10
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(ArrayList<Integer> rowNums) {
        int len = rowNums.size();
        // 冒泡排序的核心思想是比较
        if (len == 1) return;
        int num1, num2;
        /*
        外层是从后往前排的，指针用来定位每一轮冒泡结果
        每一轮最大的元素“上浮”到数组末尾，更新待排数组
         */
        for (int i = len - 1; i >= 0; i--) {
            // 这里从第二个元素开始，可以避免空指针
            for (int j = 1; j <= i; j++) {
                num1 = rowNums.get(j - 1);
                num2 = rowNums.get(j);
                if (num1 > num2) {
                    // 交换这两个元素
                    rowNums.set(j, num1);
                    rowNums.set(j - 1, num2);
                }
            }
        }
    }
}
