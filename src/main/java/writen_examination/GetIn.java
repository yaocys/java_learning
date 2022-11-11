package writen_examination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BufferedReader替代Scanner
 * 频繁修改StringBuilder替代String
 *
 * @author yao 2022/11/1
 */
public class GetIn {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    /**
     * 读取下一行字符串
     * @return
     * @throws IOException
     */
    static String nextLine() throws IOException{
        return bufferedReader.readLine();
    }

    /**
     * 读取下一个字符串
     * @return
     * @throws IOException
     */
    static String next() throws IOException{
        while (!tokenizer.hasMoreTokens()){
            tokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}
