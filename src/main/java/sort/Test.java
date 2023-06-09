package sort;

import design_parrterns.singleton.LazySingleton;

import java.io.ObjectStreamException;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

    static final int MAXN = 200005;
    static int n;
    static List<Integer>[] G = new List[MAXN];
    static int[] s = new int[MAXN], k = new int[MAXN];
    static long tot;

    static void dfs(int u,int fa){
        s[u] =1;
        k[u] =0;
        for(int v:G[u]){
            if(v==fa)continue;
            dfs(v,u);
            s[u]+=s[v];
            k[u]+=k[v]+s[v];
        }
        k[u]+=n-s[u];
        tot+=s[u];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            G[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; ++i) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            G[u].add(v);
            G[v].add(u);
        }
        dfs(1,0);
        long ans = 0;
        for(int u = 1;u<=n;++u){
            ans+=(long)s[u]*(n-s[u]);
        }
        ans-=k[1];
        System.out.println(ans/2);
    }

}
