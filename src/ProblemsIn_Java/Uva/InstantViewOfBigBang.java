package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class InstantViewOfBigBang {

	static final int INF = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, m;
		ArrayList<Edge> ady[];
		int u, v, w;

		int casos = Integer.parseInt(in.readLine().trim());
		for (int ca = 1; ca <= casos; ca++) {
			out.printf("Case %d :", ca);
			in.readLine();

			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			ady = new ArrayList[n + 1];
			m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < ady.length; ady[i] = new ArrayList<>(), i++)
				;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				ady[u].add(new Edge(v, w));
			}
			for (int i = 0; i < n; i++) {
				ady[n].add(new Edge(i, 1));
			}
			ArrayList<Integer> c = BellmanFord(ady, n);
			if (c.size() == 0)
				out.print("impossible");
			else {
				Collections.sort(c);
				for (int i = 0; i < c.size(); ++i) {
					out.printf( " %d", c.get(i));
				}
			}
			out.printf("\n");
		}

		in.close();
		out.close();
	}

	/**
	 * @param ady
	 * @param n
	 * @return
	 */
	private static ArrayList<Integer> BellmanFord(ArrayList<Edge>[] ady, int s) {

		int n = ady.length;
		int d[] = new int[n], p[] = new int[n];
		boolean vis[] = new boolean[n];
		ArrayList<Integer> inCicle = new ArrayList<>();

		Arrays.fill(d, INF);
		Arrays.fill(p, -1);

		d[s] = 0;
		for (int i = 0; i < n - 1; ++i) {
			for (int u = 0; u < n; ++u) {
				for (int k = 0; k < ady[u].size(); ++k) {
					int v = ady[u].get(k).v, w = ady[u].get(k).w;
					if (d[u] + w < d[v]) {
						d[v] = d[u] + w;
						p[v] = u;
					}
				}
			}
		}

		for (int i = 0; i < n - 1; ++i) {
			for (int u = 0; u < n; ++u) {
				for (int k = 0; k < ady[u].size(); ++k) {
					int v = ady[u].get(k).v, w = ady[u].get(k).w;
					if (d[u] + w < d[v]) {
						dfs(ady, vis, v);
					}
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			if (vis[i])
				inCicle.add(i);
		}
		return inCicle;

	}

	static void dfs(ArrayList<Edge>[] ady, boolean[] vi, int node) {
		if (vi[node])
			return;
		vi[node] = true;
		for (int i = 0; i < ady[node].size(); ++i) {
			dfs(ady, vi, ady[node].get(i).v);
		}
	}

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

}
