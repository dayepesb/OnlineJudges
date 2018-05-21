package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 2 the 9s
 */
public class TwoOfNines {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        for (String number; !(number = in.readLine().trim()).equals("0"); ) {
            char[] seq;
            StringBuilder sb;
            seq = number.toCharArray();
            int sum = 0;
            for (int i = 0; i < seq.length; i++) {
                sum += Integer.parseInt(seq[i] + "");
            }
            int degree = 1;
            if (ismul(sum)) {
                out.printf("%s is a multiple of 9 and has 9-degree ", number);
                while (sum > 9) {
                    int ans = 0;
                    seq = (sum + "").toCharArray();
                    for (int i = 0; i < seq.length; i++)
                        ans += Integer.parseInt(seq[i] + "");
                    sum = ans;
                    degree++;
                }
                out.println(degree + ".");
            } else out.printf("%s is not a multiple of 9.\n", number);

        }
        out.close();
        in.close();
    }

    private static boolean ismul(int ans) {
        return ans % 9 == 0;
    }
}
