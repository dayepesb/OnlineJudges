package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HowManyNodes {
    static long catalan[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        solve();
        long n;
        while (true) {
            String line = in.readLine();
            if (line == null) break;
            n = Long.parseLong(line.trim());
            for (int i = 1; i < 25; i++) {
                if (n == catalan[i]) {
                    out.printf("%d\n", i);
                    break;
                }
            }
        }

        out.close();
        in.close();
    }

    static void solve() {
        catalan = new long[26];
        catalan[0] = 1;
        int i = 0;
        while (i < 25) {
            catalan[i + 1] = (catalan[i] * (4 * i + 2)) / (i + 2);
            i++;
        }
    }
}
