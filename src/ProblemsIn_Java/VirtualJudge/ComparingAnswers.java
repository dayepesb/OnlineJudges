package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ComparingAnswers {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n;
        while (true) {
            n = Integer.parseInt(in.readLine().trim());
            if (n == 0) break;
            int A[][] = new int[n + 1][n + 1];
            int B[][] = new int[n + 1][n + 1];
            int[] C = new int[n + 1], D = new int[n + 1], E = new int[n + 1], F = new int[n + 1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < n; j++)
                    A[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < n; j++)
                    B[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++)
                C[i] = (int) ((Math.random() * 32767) + 1);
            for (int i = 0; i < n; i++) {
                int x = 0, y = 0;
                for (int j = 0; j < n; j++) {
                    x += C[j] * A[i][j];
                    y += C[j] * B[i][j];
                }
                D[i] = x;
                E[i] = y;
            }
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                int x = 0;
                for (int j = 0; j < n; j++)
                    x += D[j] * A[i][j];
                F[i] = x;
                ok &= F[i] == E[i];
            }
            out.println(ok ? "YES" : "NO");
            in.readLine();
        }

        out.close();
        in.close();
    }
}
