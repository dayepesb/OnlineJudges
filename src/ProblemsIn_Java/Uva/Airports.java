package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Airports {
    static int airports;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st;
        try {
            int casos = Integer.parseInt(in.readLine().trim());
            for (int k = 1; k <= casos; k++) {
                st = new StringTokenizer(in.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                ArrayList<edge> ady = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(in.readLine());
                    edge e = new edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                            Integer.parseInt(st.nextToken()));
                    ady.add(e);
                }
                Collections.sort(ady);
                int cost = 0;
                int set[] = new int[n];
                airports = n;
                Arrays.fill(set, -1);
                for (int i = 0; i < m && ady.get(i).weith < a; i++) {
                    if (find(ady.get(i).u, set) != find(ady.get(i).v, set)) {
                        set = union(ady.get(i).u, ady.get(i).v, set);
                        cost += ady.get(i).weith;
                        if (airports == 1) {
                            break;
                        }
                    }
                }
                out.printf("Case #%d: %d %d\n", k, cost + a * airports, airports);
            }
        } catch (Exception e) {

        }
        out.close();
        in.close();
    }

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
            return Integer.compare(this.weith, e.weith);
        }
    }

    static int[] union(int x, int y, int[] set) {
        x = find(x, set);
        y = find(y, set);

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
        airports--;
        return set;
    }

    /*
     * Busca el padre o nodo raiz en este arbol
     */
    static int find(int x, int[] set) {
        if (set[x] < 0)
            return x;
        else
            return set[x] = find(set[x], set);
    }

}
