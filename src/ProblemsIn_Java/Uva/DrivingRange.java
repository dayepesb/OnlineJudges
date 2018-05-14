package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DrivingRange {

	static ArrayList<edge> lAdy;
	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int nodes, edges;
		for (String line; !(line = in.readLine().trim()).endsWith("0 0");) {
			st = new StringTokenizer(line);
			nodes = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());
			lAdy = new ArrayList<>();

			for (int i = 0; i < edges; i++) {
				st = new StringTokenizer(in.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				int with = Integer.parseInt(st.nextToken());
				lAdy.add(new edge(node1, node2, with));
				lAdy.add(new edge(node2, node1, with));
			}

			int res = -1;

			set = new int[nodes];
			Arrays.fill(set, -1);

			Collections.sort(lAdy);
			for (int i = 0; i < lAdy.size(); i++) {
				if (find(lAdy.get(i).start) != find(lAdy.get(i).end)) {
					set = union(find(lAdy.get(i).start), find(lAdy.get(i).end));
					res = Math.max(res, lAdy.get(i).with);
				}
			}

			for (int i = 0; i < set.length; i++) {
				if (set[i] == -1) {
					res = -1;
					continue;
				}
			}
			if (res == -1) {
				out.println("IMPOSSIBLE");
			} else {
				out.printf("%d%n", res);
			}

		}

		out.close();
		in.close();
	}

	static class edge implements Comparable<edge> {
		int start, end;
		int with;

		public edge(int start, int end, int with) {
			this.start = start;
			this.end = end;
			this.with = with;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(this.with, o.with);
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
