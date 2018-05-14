package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ReConnectingComputerSites {
	static ArrayList<edge> ady;
	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, m, k, peso, caso = 1;
		for (String line; (line = in.readLine()) != null;) {
			if (caso > 1) {
				while (line.equals(""))
					line = in.readLine();
				out.println();
			}
			n = Integer.parseInt(line.trim()) - 1;
			peso = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				st.nextToken();
				peso += Integer.parseInt(st.nextToken());
			}
			out.println(peso);
			k = Integer.parseInt(in.readLine().trim());
			ady = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				ady.add(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			m = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				ady.add(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			Collections.sort(ady);
			int sum = 0;
			set = new int[n + 2];
			Arrays.fill(set, -1);
			for (int i = 0; i < ady.size(); i++) {
				edge e = ady.get(i);
				if (find(e.u) != find(e.v)) {
					sum += e.weith;
					union(find(e.v), find(e.u));
				}
			}

			out.println(sum);
			caso++;
		}

		in.close();
		out.close();
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

	static int[] union(int x, int y) {
		x = find(x);
		y = find(y);

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

		return set;
	}

	static int find(int x) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x]);
	}
}
