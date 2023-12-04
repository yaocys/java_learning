import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yaosunique@gmail.com
 * 2023/6/9 14:24
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("item1","item2","item3");
        list.forEach(System.out::println);
    }
}
