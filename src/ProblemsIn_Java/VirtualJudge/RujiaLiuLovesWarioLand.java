package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RujiaLiuLovesWarioLand {
    static int set[];
    static int tesoros[];
    static int module, n, m;
    static ArrayList<Integer> lAdy[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        for (String line; (line = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(line);
            int nodes = Integer.parseInt(st.nextToken());
            int querys = Integer.parseInt(st.nextToken());
            module = Integer.parseInt(st.nextToken());
            tesoros = new int[nodes + 1];
            set = new int[nodes + 1];
            lAdy = new ArrayList[nodes + 1];
            Arrays.fill(set, -1);
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= nodes; tesoros[i] = Integer.parseInt(st.nextToken()), i++) ;
            for (int i = 1; i <= nodes; lAdy[i] = new ArrayList<>(), i++) ;
            for (int i = 0; i < querys; i++) {
                st = new StringTokenizer(in.readLine().trim());
                int op = Integer.parseInt(st.nextToken());
                if (op == 1) {
                    try {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        if (find(x) != find(y)) {
                            union(x, y);
                            lAdy[x].add(y);
                            lAdy[y].add(x);
                        }
                    } catch (Exception e) {
                    }
                } else if (op == 2) {
                    try {
                        int x = Integer.parseInt(st.nextToken());
                        int v = Integer.parseInt(st.nextToken());
                        tesoros[x] = v;
                    } catch (Exception e) {
                    }
                } else if (op == 3) {
                    try {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        int v = Integer.parseInt(st.nextToken());
                        if (find(x) == find(y)) {
                            vis = new boolean[nodes + 1];
                            n = 0;
                            m = 1;
                            dfs(x, y, v, 1, 0);
                            if (n == 0) System.out.println(0);
                            else System.out.println(n + " " + m);
                        } else {
                            System.out.println(0);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }

        out.close();
        in.close();
    }

    static boolean vis[];

    static void dfs(int x, int y, int v, int resp, int islas) {
        if (!vis[x]) {
            vis[x] = true;
            int islas2 = islas;
            int resp2 = resp;
            if (tesoros[x] <= v) {
                islas2++;
                resp2 *= tesoros[x];
            }
            if (x == y) {
                n = islas2;
                m = resp2;
                return;
            }
            for (int b : lAdy[x]) {
                dfs(b, y, v, resp2, islas2);
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;

        int sizex = -(set[x]);
        int sizey = -(set[y]);

        if (sizex < sizey) {
            set[y] = set[y] + set[x];
            set[x] = y;
        } else {
            set[x] = set[x] + set[y];
            set[y] = x;
        }

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
