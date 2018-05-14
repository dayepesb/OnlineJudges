package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdaAndCycle {

	static final int INF = Integer.MAX_VALUE / 2;
	static ArrayList<Integer> lAdy[];
	static int nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			nodes = Integer.parseInt(line.trim());
			lAdy = new ArrayList[nodes];
			for (int i = 0; i < lAdy.length; lAdy[i] = new ArrayList<>(), i++)
				;

			for (int i = 0; i < lAdy.length; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < lAdy.length; j++) {
					int a = Integer.parseInt(st.nextToken());
					if (a == 1) {
						lAdy[i].add(j);
					}
				}
			}

			int ans = 0;
			for (int i = 0; i < nodes; i++) {
				ans = 0;
				if (lAdy[i].size() > 0) {
					ans = bfs(i, 0);
				}
				if (ans == 0) {
					out.println("NO WAY");
				} else {
					out.println(ans);
				}
			}

		}

		out.close();
		in.close();
	}

	static int bfs(int x, int step) {
		Queue<Edge> q = new LinkedList<>();
		Edge cur = new Edge(x, step);

		q.add(cur);
		int vis[] = new int[nodes + 1];
		Arrays.fill(vis, 0);

		int xx;
		while (!q.isEmpty()) {
			cur = q.poll();
			xx = cur.to;
			step = cur.step;

			int tmp = lAdy[xx].size();
			int tmp2;
			for (int i = 0; i < tmp; i++) {
				tmp2 = lAdy[xx].get(i);
				if (vis[tmp2] == 0) {
					if (tmp2 == x)
						return step + 1;
					if (step < nodes) {
						vis[tmp2] = 1;
						q.add(new Edge(tmp2, step + 1));
					}
				}
			}
		}

		return 0;
	}

	static class Edge {
		int to, step;

		public Edge(int to, int step) {
			this.to = to;
			this.step = step;
		}
	}

}
