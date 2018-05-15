package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.000 ms
 */
public class CakeyMcCakeFace {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st;
        long[] A, B;
        int n, m;
        String line;
        while (true) {
            line = in.readLine();
            if (line == null)
                break;
            n = Integer.parseInt(line.trim());
            m = Integer.parseInt(in.readLine().trim());
            A = new long[n];
            B = new long[m];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; A[i] = Integer.parseInt(st.nextToken()), i++) ;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < m; B[i] = Integer.parseInt(st.nextToken()), i++) ;
            HashMap<Long, Long> R = new HashMap<>();
            for (int i = 0, ii = 0; i < n; i++) {
                while (ii < m && B[ii] <= A[i])
                    ii++;
                long v = A[i];
                for (int j = ii; j < m; j++) {
                    if (R.containsKey(B[j] - v))
                        R.put(B[j] - v, R.get(B[j] - v) + 1);
                    else
                        R.put(B[j] - v, (long) 1);
                }
            }
            long mx = 0, ret = 0;
            for (Entry<Long, Long> e : R.entrySet()) {
                if (e.getValue() > mx) {
                    mx = e.getValue();
                    ret = 32767;
                }
                if (e.getValue() == mx)
                    ret = Math.min(ret, e.getKey());
            }
            out.println(ret);
        }
    }
}