package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HiddenPassword {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        int tc = in.nextInt();
        while (tc-- > 0) {
            int len = in.nextInt();
            String s = in.next();
            int i = 0, j = 1, k = 0, x, y, tmp;
            while (i < len && j < len && k < len) {
                x = i + k;
                y = j + k;
                if (x >= len) x -= len;
                if (y >= len) y -= len;
                if (s.charAt(x) == s.charAt(y)) {
                    k++;
                } else if (s.charAt(x) > s.charAt(y)) {
                    i = j + 1 > i + k + 1 ? j + 1 : i + k + 1;
                    k = 0;
                    tmp = i;
                    i = j;
                    j = tmp;
                } else {
                    j = i + 1 > j + k + 1 ? i + 1 : j + k + 1;
                    k = 0;
                }
            }
            out.println(i);
        }

        out.close();
        in.close();
    }
}
