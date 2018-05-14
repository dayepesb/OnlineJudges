package ProblemsIn_Java.Competencias.camus2510;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadsInTheNorth {

	static ArrayList<edge> lAdy[];
	static int nodes, maxDist;
	static int dist[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;

		String line;
		Loop: while ((line = in.readLine()) != null) {
			while (true) {
				if (line.trim().equals("")) {
					line = in.readLine();
					if (line == null)
						break Loop;
				} else
					break;
			}
			lAdy = new ArrayList[10000];
			for (int i = 0; i < 10000; lAdy[i] = new ArrayList<>(), i++)
				;
			nodes = 0;
			while (line != null && !line.equals("")) {
				st = new StringTokenizer(line);
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				lAdy[u].add(new edge(v, c));
				lAdy[v].add(new edge(u, c));
				nodes = Math.max(nodes, Math.max(u, v));
				line = in.readLine();
			}
			dist = new int[nodes + 1];
			maxDist = nodes;
			largest();
			out.println(largest());

		}

		out.close();
		in.close();
	}

	static int largest() {
		Arrays.fill(dist, -1);
		dist[maxDist] = 0;
		dfs(maxDist);

		return dist[maxDist];
	}

	static void dfs(int u) {
		int v;
		for (int i = 0; i < lAdy[u].size(); i++) {
			v = lAdy[u].get(i).target;
			if (dist[v] == -1) {
				dist[v] = dist[u] + lAdy[u].get(i).width;
				if (dist[maxDist] < dist[v])
					maxDist = v;
				dfs(v);
			}
		}

	}

	static class edge {
		int target, width;

		public edge(int target, int width) {
			this.target = target;
			this.width = width;
		}

		@Override
		public String toString() {
			return target + "-" + width;
		}
	}
}
