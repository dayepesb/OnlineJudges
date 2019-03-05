package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AntsColony {
    static int n;
    static int level[] = new int[100005];
    static int par[] = new int[100005], distance[] = new int[100005];
    static ArrayList<Integer> g[] = new ArrayList[100005], copy[] = new ArrayList[100005];
    static long sparse_par[][] = new long[100005][20], sparse_sum[][] = new long[100005][20];

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            n = Integer.parseInt(in.readLine().trim());
            if (n == 0) break;
            for (int i = 0; i < 100005; i++) {
                g[i] = new ArrayList<>();
                copy[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                int a, b;
                StringTokenizer st = new StringTokenizer(in.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                g[i].add(a);
                g[a].add(i);
                copy[a].add(b);
                copy[i].add(b);
            }
            distance[0] = 0;
            dfs(0, 0, 0);
            build_table();
            int q;
            q = Integer.parseInt(in.readLine().trim());
            boolean test = true;

            while (q-- > 0) {
                int a, b;
                StringTokenizer st = new StringTokenizer(in.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                long ans = query(a, b);

                if (test) {
                    out.printf("%d", ans);
                    test = false;
                } else
                    out.printf(" %d", ans);
            }
            out.printf("\n");
            for (int i = 0; i <= n; i++) {
                g[i].clear();
                copy[i].clear();
            }
        }
        out.close();
        in.close();
    }

    public static void dfs(int u, int cnt, int from) {
        par[u] = from;
        level[u] = cnt;
        for (int i = 0; i < g[u].size(); i++) {
            int v = g[u].get(i);
            if (v != from) {
                distance[v] = copy[u].get(i);
                dfs(v, cnt + 1, u);
            }
        }
    }

    public static void build_table() {
        for (int i = 0; i < n; i++) {
            sparse_par[i][0] = par[i];
            sparse_sum[i][0] = distance[i];
        }

        for (int j = 1; 1 << j < n; j++)
            for (int i = 0; i < n; i++) {
                sparse_par[i][j] = sparse_par[(int) sparse_par[i][j - 1]][j - 1];
                sparse_sum[i][j] = sparse_sum[i][j - 1] + sparse_sum[(int) sparse_par[i][j - 1]][j - 1];
            }
    }

    public static long query(int p, int q) {
        long ret = 0;
        if (level[p] <= level[q]) {
            int t = p;
            p = q;
            q = t;
        }

        int log = (int) (Math.log(level[p]) / Math.log(2));

        for (int i = log; i >= 0; i--) {
            if (level[p] - (1 << i) >= level[q]) {
                ret += sparse_sum[p][i];
                p = (int) sparse_par[p][i];
            }
        }

        if (p == q) return ret;

        for (int i = log; i >= 0; i--) {
            if (sparse_par[p][i] != sparse_par[q][i]) {
                ret += sparse_sum[p][i];
                ret += sparse_sum[q][i];
                p = (int) sparse_par[p][i];
                q = (int) sparse_par[q][i];
            }
        }
        ret += distance[p];
        ret += distance[q];
        return ret;

    }
}
