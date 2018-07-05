package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ThenEqualsKProblemUVA10025 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        /*
2

12

-3646397

         */
        int tc = in.nextInt();
        int s = 1;
        while (tc-- > 0) {
            int n = Math.abs(in.nextInt());
            int k = 1;
            for (; ; k++) {
                if (k * (k + 1) / 2 >= n && (k * (k + 1) / 2 - n) % 2 == 0)
                    break;
            }
            System.out.println((s > 1 ? "\n" : "") + k);
            s++;
        }

        out.close();
        in.close();
    }
}
