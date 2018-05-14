package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ip_Tv {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		ArrayList<edge> ady;
		HashMap<String, Integer> index;
		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 1; k <= casos; k++) {
			if (k > 1)
				out.println();
			in.readLine();
			int nodos = Integer.parseInt(in.readLine().trim());
			int aristas = Integer.parseInt(in.readLine().trim());
			ady = new ArrayList<>();
			index = new HashMap<>();
			int h = 0;
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				int peso = Integer.parseInt(st.nextToken());
				if (!index.containsKey(a)) {
					index.put(a, h);
					h++;
				}
				if (!index.containsKey(b)) {
					index.put(b, h);
					h++;
				}
				int a1 = index.get(a);
				int b1 = index.get(b);
				ady.add(new edge(a1, b1, peso));
			}
			Collections.sort(ady);
			int cost = 0;
			int set[] = new int[nodos];
			Arrays.fill(set, -1);
			for (int i = 0; i < ady.size(); i++) {
				if (find(ady.get(i).u, set) != find(ady.get(i).v, set)) {
					set = union(ady.get(i).u, ady.get(i).v, set);
					cost += ady.get(i).weith;
				}
			}
			out.println(cost);
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

	static int[] union(int x, int y, int[] set) {
		x = find(x, set);
		y = find(y, set);

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
	static int find(int x, int[] set) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x], set);
	}
}