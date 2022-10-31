import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yao 2022/10/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashSet<Integer> nums = new HashSet<>();
        int count =0;

        for(int i=0;i<n;i++)nums.add(scanner.nextInt());

        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()){
            int temp = iterator.next();
            iterator.remove();
            if(nums.contains(m-temp)) count++;
        }
        System.out.println(count);
    }
}
