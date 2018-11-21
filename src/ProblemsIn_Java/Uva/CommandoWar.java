package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CommandoWar {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        try {
            int n;
            int c = 1;
            while ((n = Integer.parseInt(in.readLine().trim())) != 0) {
                int array[][] = new int[n][2];
                for (int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(in.readLine());
                    array[i][0] = Integer.parseInt(st.nextToken());
                    array[i][1] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(array, (a, b) -> {
                    if (a[1] != b[1]) {
                        return -Integer.compare(a[1], b[1]);
                    }
                    return -Integer.compare(a[1], b[1]);
                });
                int res = 0;
                int terMax = 0;
                for (int a[] : array) {
                    res += a[0];
                    terMax = Math.max(terMax, res + a[1]);
                }
                if (terMax > res) res += terMax - res;
                out.printf("Case %d: %d%n", c++, res);
            }
        } catch (Exception e) {
        }
        out.close();
        in.close();
    }
}