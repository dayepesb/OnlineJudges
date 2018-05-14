package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NonStopTravel {
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		ArrayList<edge>[] ady;

		int caso;
		String line;

		Loop: for (int i = 1;; i++) {
			line = in.readLine();
			while (true){
				if(line != null){
					break;
				}
				line = in.readLine();
			}
			caso = Integer.parseInt(line.trim());
			if (caso == 0){
				break Loop;
			}
			ady = new ArrayList[caso + 1];

			for (int j = 0; j < ady.length; j++) {
				ady[j] = new ArrayList<>();
			}

			for (int j = 1; j <= caso; j++) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				while (st.hasMoreTokens()) {
					int nodo = Integer.parseInt(st.nextToken());
					long costo = Long.parseLong(st.nextToken());
					ady[j].add(new edge(nodo, costo));
				}
			}

			st = new StringTokenizer(in.readLine());
			int ini = Integer.parseInt(st.nextToken());
			int fin = Integer.parseInt(st.nextToken());
			out.printf("Case %d: %s%n", i, dijkstra(ady, ini, fin));
		}

		out.close();
		in.close();
	}

	public static String dijkstra(ArrayList<edge>[] ady, int ini, int fin) {
		String camino[] = new String[ady.length];
		long costo[] = new long[ady.length];
		for (int i = 0; i < costo.length; i++) {
			costo[i] = Long.MAX_VALUE;
			camino[i] = "";
		}

		PriorityQueue<edge> pq = new PriorityQueue<>();

		pq.add(new edge(ini, 0));
		camino[ini] += ini;
		costo[ini] = 0;
		while (!pq.isEmpty()) {
			edge e = pq.poll();
			ArrayList<edge> a = ady[e.nodo];
			for (int i = 0; i < a.size(); i++) {
				edge b = a.get(i);
				if (costo[b.nodo] > costo[e.nodo] + b.costo) {
					costo[b.nodo] = costo[e.nodo] + b.costo;
					camino[b.nodo] = camino[e.nodo].trim() + " " + b.nodo;
					pq.add(b);
				}
			}
		}
		return String.format("Path = %s; %d second delay", camino[fin].trim(), costo[fin]);
	}

	public static class edge implements Comparable<edge> {
		public int nodo;
		public long costo;

		public edge(int nodo, long costo) {
			this.nodo = nodo;
			this.costo = costo;
		}

		@Override
		public int compareTo(edge o) {
			return Long.compare(this.costo, o.costo);
		}
	}
}