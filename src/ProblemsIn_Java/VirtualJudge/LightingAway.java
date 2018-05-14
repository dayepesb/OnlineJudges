package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 18-02-2018
 * @time 0.000 ms
 */
public class LightingAway {
	static ArrayList<Integer> graph[], array;
	static int node, edge, visit[], cont;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int tc = Integer.parseInt(in.readLine().trim());
		for (int c = 1; c <= tc; c++) {
			String s = in.readLine().trim();
			while (s.equals(""))
				s = in.readLine().trim();
			st = new StringTokenizer(s);
			node = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			graph = new ArrayList[node + 1];
			array = new ArrayList();
			cont = 0;
			for (int i = 0; i <= node; i++)
				graph[i] = new ArrayList();
			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(in.readLine());
				graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			dfs();dfsCheck();
			out.printf("Case %d: %d%n", c, cont);
		}

		in.close();
		out.close();
	}

	static void dfsVis(int u) {
		visit[u] = 1;
		for (int i = 0; i < graph[u].size(); i++) {
			int v = graph[u].get(i);
			if (visit[v] == 0)
				dfsVis(v);
		}
		array.add(u);
	}

	static void dfs() {
		int i, j;
		visit = new int[node + 1];
		for (i = 1; i <= node; i++)
			if (visit[i] == 0) {
				dfsVis(i);
			}
	}

	static void dfsCheck() {
		visit = new int[node + 1];
		int size = array.size() - 1;
		for (int i = size; i >= 0; i--)
			if (visit[array.get(i)] == 0) {
				dfsVis(array.get(i));
				cont++;
			}
	}
}
