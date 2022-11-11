import java.util.ArrayList;
import java.util.List;

/**
 * @author yao 2022/9/21
 *
 * java数组中怎么删掉一个元素？
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {

        String temp = "";
        if (strs.length < 2) return temp;

        String minStr = strs[0];
        // 找出最短的字符串长度
        int minLen = minStr.length();

        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
                minStr = s;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            temp = minStr.substring(i, i + 1);
            for (String str : strs) {
                for (int j = 0; j < str.length(); j++) {
                    if (!str.substring(i, i + 1).equals(temp)) return res.toString();
                }
            }
            res.append(temp);
        }
        return res.toString();
    }

    public boolean matches(String string,String pattern,int i,int j){
        if(i==0) return false;
        if(pattern.charAt(j-1)=='.') return true;
        return string.charAt(i-1)==pattern.charAt(j-1);
    }

    public boolean match (String string, String pattern) {
        int m = string.length();
        int n = pattern.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i=0;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(pattern.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    if(matches(string,pattern,i,j-1)) dp[i][j] = dp[i][j]||dp[i-1][j];
                }else{
                    if(matches(string,pattern,i,j)) dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public String getLongestPalindrome (String geneticStr) {
        int length = geneticStr.length();
        if(length<2) return geneticStr;

        int maxLength = 1,begin =0;
        boolean[][] dp = new boolean[length][length];
        for(int i = 0;i<length;i++) dp[i][i] = true;

        char[] chars = geneticStr.toCharArray();

        for(int k = 2;k<=length;k++){
            for(int i = 0;i<length;i++){
                int j = k+i-1;
                if(j>=length) break;
                if(chars[i]!=chars[j]) dp[i][j] = false;
                else{
                    if(j-i<3) dp[i][j] =  true;
                    else dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j]&&j-i+1>maxLength){
                    maxLength = j-i+1;
                    begin = i;
                }
            }
        }
        return geneticStr.substring(begin,begin+maxLength);
    }

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public int cal (int d, int[] array) {
        dfs(0,array);
        int min,max,count=0;
        for(List<Integer> arr:res){
            min = arr.get(0);
            max = arr.get(0);
            for(int i:arr){
                min = Math.min(min,i);
                max = Math.max(max,i);
            }
            if(max-min<=d) count++;
        }
        return count;
    }

    public void dfs(int cur,int[] arr){
        if(temp.size()+(arr.length-cur)<3) return;
        if(temp.size()==3){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(arr[cur]);
        dfs(cur+1,arr);
        temp.remove(temp.size()-1);
        dfs(cur+1,arr);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Solution solution = new Solution();
        solution.cal(5,arr);
    }
}
