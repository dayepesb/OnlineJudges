package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FerryLoading {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int caseNum = Integer.parseInt(in.readLine());


        for (int caseId = 0; caseId < caseNum; caseId++) {
            in.readLine();
            int L = Integer.parseInt(in.readLine());
            L *= 100;
            boolean[][] dp = new boolean[2][L + 1];
            Arrays.fill(dp[0], false);
            dp[0][0] = true;
            int[][] pre = new int[205][L + 1];

            int[] carlen = new int[205];

            boolean done = false;
            int t = 0, pt;
            int i = 0;
            int N = 0;
            int sumlen = 0;
            int lastlen = 0;
            while (true) {
                int curlen = Integer.parseInt(in.readLine());
                if (curlen == 0) break;
                if (done == true)
                    continue;
                pt = t;
                t ^= 1;
                carlen[++i] = curlen;
                sumlen += curlen;
                Arrays.fill(dp[t], false);
                boolean canload = false;
                for (int len = 0; len <= L; len++) {
                    if (dp[pt][len] == false) continue;
                    if (len + curlen <= L && sumlen - (len + curlen) <= L) {
                        dp[t][len + curlen] = true;
                        pre[i][len + curlen] = 0;
                        lastlen = len + curlen;
                        canload = true;
                    }

                    if (sumlen - len <= L) {
                        dp[t][len] = true;
                        pre[i][len] = 1;
                        lastlen = len;
                        canload = true;
                    }
                }
                if (!canload) done = true;
                else N = i;
            }
            out.println(N);
            int[] answer = new int[N + 1];
            for (i = N; i >= 0; i--) {
                if (pre[i][lastlen] == 0) {
                    lastlen -= carlen[i];
                    answer[i] = 0;
                } else if (pre[i][lastlen] == 1) {
                    answer[i] = 1;
                }
            }

            for (i = 1; i <= N; i++) {
                if (answer[i] == 0) out.println("port");
                else if (answer[i] == 1) out.println("starboard");
            }
            if (caseId < caseNum - 1)
                out.println("");
        }
        out.close();
    }
}
