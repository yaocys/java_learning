import java.util.*;

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        main.findOrder(4, pre);
    }

    public int numOfPath(int m, int n) {
        // 二维动态规划
        // dp[i][j]表示从左上角到达i行j列位置可能的不同路径数
        // 只能向右或者向下移动，也就是说上一步位置只可能是左边或者上面
        // 也就是dp[i][j-1]和dp[i-1][j]
        // 那么状态转移方程就是：dp[i][j] = dp[i][j-1]+dp[i-1][j]
        // 也就是：到达但钱位置可能的不同路径总数等于到达上方和左边位置的不同路径数之和
        // 然后考虑dp数组的初始化问题
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = 1;
                if (j == 0) dp[i][j] = 1;
                if (i != 0 && j != 0) {
                    // 从1，1位置开始动态规划
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        // 记录了每个节点的入度是多少
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) inDegree[pair[0]]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) queue.offer(i);

        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[index++] = curr;
            // 更新入度以及队列
            for (int[] pair : prerequisites) {
                int to = pair[0];
                int from = pair[1];
                if (curr == from) {
                    inDegree[to]--;
                    if (inDegree[to] == 0) queue.offer(to);
                }
            }
        }
        if (index == numCourses) return res;
        else return new int[0];
    }
}
