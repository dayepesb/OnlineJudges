package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JustABitSorted {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static long[][] dp, sum;

    public static void main(String args[]) throws Exception {
        dp = new long[5005][5005];
        sum = new long[5005][5005];
        dp[0][0] = 1;
        for (int i = 1; i < 5005; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (j + 1) * dp[i - 1][j] + (i - j) * dp[i - 1][j - 1];
                dp[i][j] %= 1e9 + 7;
            }
        }

        for (int i = 0; i < 5005; i++) {
                long t = 0;
            for (int j = 0; j <= i; j++) {
                t += dp[i][j];
                t %= 1e9 + 7;
                sum[i][j] = t;
            }
        }
        int N, Q, K;
        while (true) {
            String line = in.readLine();
            if (line == null || line.equalsIgnoreCase("")) break;
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            ArrayList<Long> ret = new ArrayList<Long>();
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < Q; i++) {
                K = Integer.parseInt(st.nextToken());
                K = Math.min(K, N);
                ret.add(sum[N][K - 1]);
            }
            for (int i = 0; i < ret.size(); i++) {
                if (i != 0) out.print(' ');
                out.printf("%d", ret.get(i));
            }
            out.println();
        }
        out.close();
        in.close();
    }
}
