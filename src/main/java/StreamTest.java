import java.util.stream.Stream;

/**
 * @author yaosunique@gmail.com
 * 2023/6/9 16:21
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.filter(str -> str.length() == 3)
                .forEach(System.out::println);
    }

    public int translateNum(int num) {
        int pre = 1, prepre = 1, lastDigit = num % 10;
        num /= 10;

        while (num > 0) {
            int currentDigit = num % 10;
            int combined = currentDigit * 10 + lastDigit;

            if (currentDigit != 0 && combined <= 25) {
                pre += prepre;
                prepre = pre - prepre;
            } else prepre = pre;
            lastDigit = currentDigit;
            num /= 10;
        }
        return pre;
    }
}
