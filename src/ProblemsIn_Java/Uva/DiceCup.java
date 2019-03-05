package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DiceCup {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st;
        String line;
        int i, j, k, tc = 0, mem[];
        while ((line = in.readLine()) != null) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (++tc > 1) out.println();
            mem = new int[21 * 21];
            for (i = 1; i <= m; ++i)
                for (j = 1; j <= n; ++j)
                    ++mem[i + j];
            ArrayList<Integer> list = new ArrayList<>();
            for (k = -1, i = 1; i <= m + n; ++i)
                if (mem[i] > k) {
                    list = new ArrayList<>();
                    list.add(i);
                    k = mem[i];
                } else if (mem[i] == k)
                    list.add(i);
            for (i = 0; i < (int) list.size(); ++i)
                out.printf("%d\n", list.get(i));
        }

        out.close();
        in.close();
    }
}
