package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class LongestPalindrome {

    static int memo[][];
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            s = in.readLine().trim();
            if (s.length() == 0) {
                out.println(0);
                continue;
            }
            memo = new int[s.length()][s.length()];
            for (int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i], -1);
            out.println(longestPalin(0, s.length() - 1));
        }

        out.close();
        in.close();
    }

    public static int longestPalin(int l, int r) {
        if (l == r)
            return 1;
        if (l + 1 == r) {
            if (s.charAt(l) == s.charAt(r))
                return 2;
            else
                return 1;
        }
        if (memo[l][r] != -1)
            return memo[l][r];

        if (s.charAt(l) == s.charAt(r))
            return memo[l][r] = 2 + longestPalin(l + 1, r - 1);
        else
            return memo[l][r] = Math.max(longestPalin(l, r - 1), longestPalin(l + 1, r));
    }
}
