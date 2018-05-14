package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class HeavyCycleEdges {
	static ArrayList<edge> lAdy;
	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int nodos, aristas;
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			st = new StringTokenizer(line);
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());

			lAdy = new ArrayList<>();
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int peso = Integer.parseInt(st.nextToken());
				lAdy.add(new edge(a, b, peso));
			}

			Collections.sort(lAdy);
			set = new int[nodos];
			Arrays.fill(set, -1);
			ArrayList<Integer> ans = new ArrayList<>();
			for (int i = 0; i < lAdy.size(); i++) {
				edge w = lAdy.get(i);
				if (find(w.u) != find(w.v)) {
					union(find(w.u), find(w.v));
				} else {
					ans.add(w.weith);
				}
			}
			StringBuilder sb = new StringBuilder("");
			if (ans.size() == 0) {
				out.println("forest");
			} else {
				Collections.sort(ans);
				for (int i = 0; i < ans.size(); i++) {
					sb.append(ans.get(i) + " ");
				}
				out.println(sb.toString().trim());
			}
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

	static int find(int x) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x]);
	}
}
