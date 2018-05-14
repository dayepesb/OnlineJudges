package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.StringTokenizer;

public class ArcticNetwork {
	static ArrayList<edge> ady;
	// el set lo llena de menos 1
	static int set[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en","US"));

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine());
		while (casos-- > 0) {
			st = new StringTokenizer(in.readLine());
			int sat = Integer.parseInt(st.nextToken());
			int nodos = Integer.parseInt(st.nextToken());
			Point2D points[] = new Point2D[nodos];
			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				points[i] = new Point2D.Double(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			ady = new ArrayList<>();
			for (int i = 0; i < nodos; i++) {
				for (int j = i + 1; j < nodos; j++) {
					ady.add(new edge(i, j, points[i].distance(points[j])));
				}
			}
			Collections.sort(ady);
			set = new int[nodos];
			Arrays.fill(set, -1);
			double d = 0;
			int cc = nodos;
			int k = ady.size();
			for (int i = 0; i < k && cc != sat; i++) {
				if (find(ady.get(i).u) != find(ady.get(i).v)) {
					d = ady.get(i).weith;
					union(ady.get(i).u, ady.get(i).v);
					cc--;
				}
			}
			out.printf("%.2f\n",d);
		}

		out.close();
		in.close();
	}

	// y organiza las adyacencias conforme al peso con un
	// Collections.sort();
	// para unirlas solo se tiene que preguntar que el padre de u sea
	// diferente al padre de v y ya los puede unir
	static class edge implements Comparable<edge> {
		int u, v;
		double weith;

		public edge(int u, int v, double weith) {
			this.u = u;
			this.v = v;
			this.weith = weith;
		}

		@Override
		public int compareTo(edge e) {
			return Double.compare(this.weith, e.weith);
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
