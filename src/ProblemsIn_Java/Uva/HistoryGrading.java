package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HistoryGrading {

    static int a[], b[], num, memo[][];

    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        int n, flag, order, x[] = new int[20], y[] = new int[20];
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            order = in.nextInt();
            order--;
            x[order] = i;
        }
        while (true) {
            flag = 0;
            for (int i = 0; i < n; i++) {
                order = in.nextInt();
                if (order != 1) {
                    flag = 1;
                    break;
                }
                order--;
                y[order] = i;
            }
            if (flag >= 1) break;
            int dp[][] = new int[25][25];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (x[i - 1] == y[j - 1])
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ?
                                dp[i - 1][j] : dp[i][j - 1];
                }
            }
            out.println(dp[n][n]);
        }
        out.println("-------------------");
        out.close();
        in.close();
    }
}