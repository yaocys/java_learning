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
        /*Buffer buffer = new Buffer(100, 50, new ArrayDeque<>());

        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();*/
        Object object = new Object();
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
}
