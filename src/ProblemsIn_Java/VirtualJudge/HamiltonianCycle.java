package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HamiltonianCycle {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int mAdy[][];
        StringTokenizer st;
        for (String line; (line = in.readLine()) != null; ) {
            int n = Integer.parseInt(line.trim());
            mAdy = new int[n][n];
            while (true) {
                if ((line = in.readLine()).equalsIgnoreCase("%")) break;
                st = new StringTokenizer(line);
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                mAdy[a][b] = mAdy[b][a] = 1;
            }
            int lAdy[][] = new int[n][];
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> l = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (mAdy[i][j] == 1) l.add(j);
                }
                int array[] = new int[l.size()];
                for (int j = 0; j < l.size(); j++) array[j] = l.get(j);
                lAdy[i] = array;
            }
            int[] res = hamilton(lAdy);
            if (res == null)
                out.println("N");
            else {
                StringBuilder sb = new StringBuilder();
                for (int a : res) {
                    sb.append((a + 1) + " ");
                }
                out.println(sb.toString().trim());
            }
        }

        out.close();
        in.close();

    }

    static int[] hamilton(int[][] lAdy) {
        int n = lAdy.length, cam[] = new int[n + 1];
        if (!hamilton(lAdy, new boolean[n], cam, 0, 0)) return null;
        return cam;
    }

    static boolean hamilton(int[][] lAdy, boolean[] vis, int[] cam, int t, int v) {
        if (vis[v] && t < cam.length - 1) return false;
        cam[t++] = v;
        if (t == cam.length) return v == cam[0];
        vis[v] = true;
        for (int w : lAdy[v]) if (hamilton(lAdy, vis, cam, t, w)) return true;
        vis[v] = false;
        return false;
    }
}
