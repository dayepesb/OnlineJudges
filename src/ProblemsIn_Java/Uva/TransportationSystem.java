package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TransportationSystem {

	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int nodos, umbral;
		Point2D nodes[];
		ArrayList<edge> lAdy;
		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 1; k <= casos; k++) {
			st = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(st.nextToken());
			umbral = Integer.parseInt(st.nextToken());
			nodes = new Point2D[nodos];
			lAdy = new ArrayList<>();
			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				nodes[i] = new Point2D.Double(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			}
			for (int i = 0; i < nodos; i++) {
				for (int j = i + 1; j < nodos; j++) {
					lAdy.add(new edge(i, j, nodes[i].distance(nodes[j])));
				}
			}

			Collections.sort(lAdy);
			set = new int[nodos];
			Arrays.fill(set, -1);
			double maxCities = 0;
			double maxStates = 0;
			int states = nodos;
			for (int i = 0; i < lAdy.size(); i++) {
				edge v = lAdy.get(i);
				if (v.with <= umbral) {
					int a = find(v.start);
					int b = find(v.end);
					if (a != b) {
						set = union(a, b);
						maxCities = (maxCities + v.with);
						states--;
					}
				} else {
					int a = find(v.start);
					int b = find(v.end);
					if (a != b) {
						set = union(a, b);
						maxStates = (maxStates + v.with);
					}
				}
			}
			out.printf("Case #%d: %d %d %d%n",k, states, Math.round(maxCities), Math.round(maxStates));

		}

		in.close();
		out.close();
	}

	static class edge implements Comparable<edge> {
		int start, end;
		double with;

		public edge(int start, int end, double with) {
			this.start = start;
			this.end = end;
			this.with = with;
		}

		@Override
		public int compareTo(edge o) {
			return Double.compare(this.with, o.with);
		}

		@Override
		public String toString() {
			return start + " " + end + " " + with;
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
