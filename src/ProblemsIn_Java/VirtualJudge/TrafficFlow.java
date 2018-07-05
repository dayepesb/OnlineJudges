package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TrafficFlow {


    static ArrayList<edge> ady;
    static int set[];
    static int INF = 2147383647;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int mAdy[][];
        int tc = Integer.parseInt(in.readLine().trim());
        for (int c = 1; c <= tc; c++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            mAdy = new int[n][n];
            ady = new ArrayList<>();
            set = new int[n];
            Arrays.fill(set, -1);
            for (int ds[] : mAdy) Arrays.fill(ds, INF);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                mAdy[a][b] = mAdy[b][a] = cost;
            }
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    if (mAdy[i][j] != INF) {
                        ady.add(new edge(i, j, mAdy[i][j]));
                    }
            Collections.sort(ady);
            boolean res[][] = new boolean[n][n];
            for (edge e : ady) {
                if (find(e.u) != find(e.v)) {
                    union(e.u, e.v);
                    res[e.u][e.v] = res[e.v][e.u] = true;
                }
            }
            int min = INF;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (res[i][j] && min > mAdy[i][j]) min = mAdy[i][j];
                }
            }
            out.printf("Case #%d: %d%n", c, min);
        }

        out.close();
        in.close();
    }

    // y organiza las adyacencias conforme al peso con un
    // Collections.sort();
    // para unirlas solo se tiene que preguntar que el padre de u sea
    // diferente al padre de v y ya los puede unir
    static class edge implements Comparable<edge> {
        int u, v;
        int weith;

        public edge(int u, int v, int weith) {
            this.u = u;
            this.v = v;
            this.weith = weith;
        }

        @Override
        public int compareTo(edge e) {
            return Integer.compare(e.weith, this.weith);
        }

        @Override
        public String toString() {
            return this.weith + "";
        }
    }

    static int[] union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return set;

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