package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DigitsCount {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int start, end;
        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            if (start + end == 0) break;
            long ans[] = new long[10], sub[] = new long[10];
            cal(start - 1, sub);
            cal(end, ans);
            int i;
            for (i = 0; i < 10; i++)
                out.printf("%d%c", ans[i] - sub[i], i == 9 ? '\n' : ' ');
        }
        out.close();
        in.close();
    }

    public static void cal(long n, long[] num) {
        long fac = 1;
        while ((n / fac) > 0) {
            long low = n - (n / fac) * fac, now = (n / fac) % 10, high = n / (fac * 10);
            int i;
            for (i = 0; i < 10; i++) {
                if (now < i) num[i] += high * fac;
                else if (now == i) num[i] += high * fac + low + 1;
                else if (now > i) num[i] += (high + 1) * fac;
            }
            fac *= 10;
        }
        while ((fac /= 10) > 0)
            num[0] -= fac;
    }
}
