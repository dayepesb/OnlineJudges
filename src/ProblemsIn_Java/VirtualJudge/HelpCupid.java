package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HelpCupid {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        for (String line; (line = in.readLine()) != null; ) {
            int n = Integer.parseInt(line.trim());
            int time[] = new int[24];
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++) time[11 + Integer.parseInt(st.nextToken())]++;
            for (int i = 0; i < 24; i++)
                time[i] = time[i] & 1;
            int A[] = new int[64], m = 0, ret = Integer.MAX_VALUE;
            for (int i = 0; i < 24; i++)
                if (time[i] > 0) A[m++] = i;
            for (int i = 0; i < m; i++)
                A[i + m] = A[i] + 24;
            if (m == 0) ret = 0;
            for (int i = 0; i < m; i++) {
                int c = 0;
                for (int j = 0; j < m; j += 2)
                    c += A[i + j + 1] - A[i + j];
                ret = Math.min(ret, c);
            }
            System.out.println(ret);
        }

        out.close();
        in.close();
    }

}
