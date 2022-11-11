import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yao 2022/9/21
 */
public class Test{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = br.read();
        float sum =0;
        for(int i =1;i<=n;i++){
            if(i%2==0)sum-=(float) 1/i;
            else sum+=(float) 1/i;
        }
        System.out.printf("%.5f",sum);
    }
}