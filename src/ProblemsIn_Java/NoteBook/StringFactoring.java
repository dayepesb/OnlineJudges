package ProblemsIn_Java.NoteBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class StringFactoring {

    static long memo[][];
    static char [] s;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        memo = new long[110][110];
        String line;
        while (true) {
            if ((line = in.readLine().trim()).equals("*")) break;
            int len = line.length();
            s = new char[len];
            for (int i = 0 ; i < len ; i++)s[i]=line.charAt(i);
            for (int i = 0; i < 85; i++) {
                Arrays.fill(memo[i],0);
            }
            out.println(dfs(0, len-1));
        }

        out.close();
        in.close();
    }

    static long dfs(int l, int r) {
        if(l == r)
            return 1;
        if(memo[l][r]>0)
            return memo[l][r];
        int i, j, k;
        long ret = memo[l][r];
        ret = 0xfffffff;
        for(i = l; i < r; i++)
            ret = Math.min(ret, dfs(l, i) + dfs(i+1, r));
        int sublen = r-l+1;
        for(i = 1; i <= sublen; i++) {
            if(sublen%i == 0) {
                for(k = l, j = 0; k <= r; k++) {
                    if(s[k] != s[j+l])
                        break;
                    j++;
                    if(j >= i)  j = 0;
                }
                if(k == r+1 && r != l+i-1)
                    ret = Math.min(ret, dfs(l, l+i-1));
            }
        }
        return ret;
    }
}
