package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ExpensiveSubway {
	static ArrayList<edge> lAdy;
	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int nodos, aristas, index;
		HashMap<String, Integer> ady;
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			index = 0;
			st = new StringTokenizer(line);
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());
			ady = new HashMap<>();

			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				ady.put(st.nextToken(), index);
				index++;
			}

			lAdy = new ArrayList<>();
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				int a = ady.get(st.nextToken());
				int b = ady.get(st.nextToken());
				int peso = Integer.parseInt(st.nextToken());
				lAdy.add(new edge(a, b, peso));
			}

			Collections.sort(lAdy);
			set = new int[nodos];
			Arrays.fill(set, -1);
			int sum = 0;
			for (int i = 0; i < lAdy.size(); i++) {
				edge w = lAdy.get(i);
				if (find(w.u) != find(w.v)) {
					sum += w.weith;
					union(find(w.u), find(w.v));
				}
			}
			int count = 0;
			for (int i = 0; i < set.length; i++) {
				if (set[i] < 0)
					count++;
			}
			if(count>1){
				out.println("Impossible");
			}else{
				out.println(sum);
			}
			in.readLine();
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
