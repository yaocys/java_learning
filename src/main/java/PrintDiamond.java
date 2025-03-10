/**
 * @author yaosunique@gmail.com
 * 2024/7/21 21:15
 */
public class PrintDiamond {
    public static void main(String[] args) {
        printDiamond(10); // 10为对角线长度
    }

    public static void print(int size) {
        size = size*2-1;

        for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" "); // 输出左上角位置的空白
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*"); // 输出菱形上半部边缘
            }
            System.out.println(); // 换行
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" "); // 输出菱形左下角空白
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                System.out.print("*"); // 输出菱形下半部边缘
            }
            System.out.println(); // 换行
        }
    }

    /**
     * 打印菱形实现方法
     */
    public static void printDiamond(int size) {

        size = (size / 2) * 2; // 菱形对角线两侧的宽度是相同的，所以对角线长度size必定是偶数,(size+1)即为行数和列数

        int center = (size / 2); // 以左上角为坐标点(0,0),菱形中心点坐标(center,center)

        for (int i = 0; i <= size; i++) { // 行
            for (int j = 0; j <= size; j++) { // 列
                if (Math.abs(i - center) + Math.abs(j - center) == center) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
