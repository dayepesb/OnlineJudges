package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class InvitationCards {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		long casos = Long.parseLong(in.readLine());

		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			int nodos = Integer.parseInt(st.nextToken());
			int arcos = Integer.parseInt(st.nextToken());

			ArrayList<Edge>[] list = new ArrayList[nodos];
			for (int j = 0; j < list.length; j++) {
				list[j] = new ArrayList<>();
			}
			ArrayList<Edge>[] list2 = new ArrayList[nodos];
			for (int j = 0; j < list2.length; j++) {
				list2[j] = new ArrayList<>();
			}

			for (int j = 0; j < arcos; j++) {
				st = new StringTokenizer(in.readLine());
				int n = Integer.parseInt(st.nextToken()) - 1;
				int m = Integer.parseInt(st.nextToken()) - 1;
				int costo = Integer.parseInt(st.nextToken());
				list[n].add(new Edge(m, costo));
				list2[m].add(new Edge(n, costo));
			}

			long solve[] = new long[nodos];
			Arrays.fill(solve, Long.MAX_VALUE);
			long solve2[] = solve.clone();

			int t = 0;

			long[] solve1 = Dijkstra(0, list, solve);
			long[] solve11 = Dijkstra(0, list2, solve2);

			for (int j = 0; j < solve11.length; j++) {
				t += solve1[j] + solve11[j];
			}
			out.println(t);

		}
		out.close();
		in.close();
	}

	public static long[] Dijkstra(int ini, ArrayList<Edge>[] list, long solve[]) {
		PriorityQueue<Integer> q = new PriorityQueue<>();

		q.add(ini);
		solve[ini] = 0;

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < list[u].size(); i++) {
				if (list[u].get(i).costo + solve[u] < solve[list[u].get(i).nodo]) {
					solve[list[u].get(i).nodo] = list[u].get(i).costo + solve[u];
					q.add(list[u].get(i).nodo);
				}
			}
		}

		return solve;
	}

	public static class Edge implements Comparable<Edge> {

		public int nodo, costo;

		public Edge(int nodo, int costo) {
			this.nodo = nodo;
			this.costo = costo;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.nodo, o.nodo) == 0 ? Integer.compare(this.costo, o.costo)
					: Integer.compare(this.nodo, o.nodo);
		}

		@Override
		public String toString() {
			return String.format("%d %d3", nodo, costo);
		}
	}
}
