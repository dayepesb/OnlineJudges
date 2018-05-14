package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TripRouting {
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String ciu1, ciu2, route;
		long costo;
		String line;
		HashMap<String, ArrayList<Edge>> ady = new HashMap<>();
		for (; !(line = in.readLine()).equals("");) {
			st = new StringTokenizer(line, ",");
			ciu1 = st.nextToken();
			ciu2 = st.nextToken();
			route = st.nextToken();
			costo = Long.parseLong(st.nextToken());
			if (!ady.containsKey(ciu1)) {
				ady.put(ciu1, new ArrayList<>());
			}
			if (!ady.containsKey(ciu2)) {
				ady.put(ciu2, new ArrayList<>());
			}
			ady.get(ciu1).add(new Edge(ciu2, route, costo));
			ady.get(ciu2).add(new Edge(ciu1, route, costo));
		}
		line = in.readLine();
		while (true) {
			st = new StringTokenizer(line, ",");
			out.printf("%n%n%-20s %-20s %-10s %-5s%n", "From", "To", "Route", "Miles");
			out.println("-------------------- -------------------- ---------- -----");
			Dijkstra(st.nextToken(), st.nextToken(), ady);
			if ((line = in.readLine()) == null) {
				break;
			}
		}

		out.close();
		in.close();
	}

	public static void Dijkstra(String ini, String fin, HashMap<String, ArrayList<Edge>> ady) {
		HashMap<String, Long> solve = new HashMap<>();
		HashMap<String, String> camino = new HashMap<>();
		for (Entry<String, ArrayList<Edge>> f : ady.entrySet()) {
			solve.put(f.getKey(), Long.MAX_VALUE);
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(ini, "", 0));
		camino.put(ini, ini);
		solve.put(ini, 0L);
		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			ArrayList<Edge> a = ady.get(u.nodo);
			for (int i = 0; i < a.size(); i++) {
				Edge v = a.get(i);
				if (solve.get(v.nodo) > solve.get(u.nodo) + v.costo) {
					solve.put(v.nodo, solve.get(u.nodo) + v.costo);
					camino.put(v.nodo, camino.get(u.nodo) + "," + v.route + "," + v.costo + "," + v.nodo);
					pq.add(v);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(camino.get(fin), ",");
		String uno = st.nextToken(), dos, route, peso;
		do {
			route = st.nextToken();
			peso = st.nextToken();
			dos = st.nextToken();
			out.printf("%-20s %-20s %-10s %5s%n", uno, dos, route, peso);
			uno = dos;
		} while (st.hasMoreTokens());
		out.printf("%58s%n", "-----");
		out.printf("%52s %5d%n", "Total     ", solve.get(fin));
	}

	public static class Edge implements Comparable<Edge> {

		String nodo, route;
		long costo;

		public Edge(String nodo, String route, long costo) {
			this.nodo = nodo;
			this.route = route;
			this.costo = costo;
		}

		@Override
		public String toString() {
			return nodo + " " + route + " " + costo;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.costo, o.costo);
		}
	}
}
