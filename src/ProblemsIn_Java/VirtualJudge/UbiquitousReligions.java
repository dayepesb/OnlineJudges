package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UbiquitousReligions {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tc = 1;
        for (String line; !(line = in.readLine().trim()).equalsIgnoreCase("0 0"); ) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            set = new int[n+1];
            Arrays.fill(set, -1);
            ans = n;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }
            out.printf("Case %d: %d%n", tc++, ans);
        }
        out.close();
        in.close();
    }

    // el set lo llena de menos 1
    static int set[], ans;

    static int[] union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return set;

        ans--;

        int sizex = -(set[x]);
        int sizey = -(set[y]);

        if (sizex < sizey) {
            set[y] = set[y] + set[x];
            set[x] = y;
        } else {
            set[x] = set[x] + set[y];
            set[y] = x;
        }

        return set;
    }

    /*
     * Busca el padre o nodo raiz en este arbol
     */
    static int find(int x) {
        if (set[x] < 0)
            return x;
        else
            return set[x] = find(set[x]);
    }
}
