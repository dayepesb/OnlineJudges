package ProblemsIn_Java.Competencias.Round_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class APriklyProblem {
	static int nodes, edges;

	static ArrayList<Integer> lAdy[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int caso =1;
		int cases = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < cases; c++) {
			st = new StringTokenizer(in.readLine());
			nodes = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());

			lAdy = new ArrayList[nodes];
			for (int i = 0; i < lAdy.length; i++) {
				lAdy[i] = new ArrayList<>();
			}
			for (int i = 0; i < edges; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int w = Integer.parseInt(st.nextToken()) - 1;
				lAdy[u].add(w);
				lAdy[w].add(u);
			}
			ArrayList<Integer> bs = new ArrayList<>();
			int vis[] = new int[nodes];
			boolean puede[][] = new boolean[nodes][nodes];
			Arrays.fill(vis, -1);
			// Arrays.fill(puede, true);
			for (int i = 0; i < nodes; i++) {
				if (vis[i] == -1) {
					ArrayList<Integer> camino = new ArrayList<>();
					camino.add(i);
					dfs(i, 0, -1, camino, bs, vis, puede);
				}
			}
			int resp = 1;
			for (Integer b : bs) {
				resp *= (b);
			}
			out.printf("Case #%d: %d%n%n",caso++,resp);
		}

		out.close();
		in.close();
	}

	static void dfs(int i, int level, int padre, ArrayList<Integer> camino, ArrayList<Integer> bs, int[] vis,
			boolean puede[][]) {
		vis[i] = level;
		for (Integer w : lAdy[i]) {
			if (padre != w) {
				if (!puede[w][i]) {
					if (vis[w] != -1) {
						int ans = camino.get(0);
						for (int j = 1; j < camino.size(); j++) {
							int s = camino.get(j);
							puede[ans][s] = puede[s][ans] = true;
							ans = s;
						}
						bs.add(camino.size());
					} else {
						ArrayList<Integer> camino1 = new ArrayList<>();
						camino1.addAll(camino);
						camino1.add(w);
						dfs(w, level + 1, i, camino1, bs, vis, puede);
					}
				}
			}
		}
	}
}
