package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Quadtrees {

    static int mat[][];
    static int cnt, idx;
    static char tree[];

    public static void main(String[] arg) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            cnt = 0;
            mat = new int[32][32];
            idx = 0;
            tree = in.readLine().trim().toCharArray();
            sol(0, 0, 32);
            idx = 0;
            tree = in.readLine().trim().toCharArray();
            sol(0, 0, 32);
            for (int[] ds : mat)
                for (int j : ds)
                    cnt += j;
            out.println("There are "+cnt+" black pixels.");
        }
        out.close();
        in.close();
    }

    static void sol(int x, int y, int bit) {
        char c = tree[idx];
        if (c == 'p') {
            idx++;
            sol(x, y + bit / 2, bit / 2);
            sol(x, y, bit / 2);
            sol(x + bit / 2, y, bit / 2);
            sol(x + bit / 2, y + bit / 2, bit / 2);
        } else if (c == 'f') {
            for (int i = x; i < x + bit; i++)
                for (int j = y; j < y + bit; j++)
                    mat[i][j] = 1;
            idx++;
        } else idx++;
    }
}
