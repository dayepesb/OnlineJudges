package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SendingEmail {

	public static long solve[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		LinkedList<Edge>[] list;

		int casos = in.nextInt();
		for (int i = 0; i < casos; i++) {
			int nodos = in.nextInt();
			list = new LinkedList[nodos];
			for (int j = 0; j < list.length; j++) {
				list[j] = new LinkedList<>();
			}

			int aristas = in.nextInt();
			int ini = in.nextInt();
			int fin = in.nextInt();

			for (int j = 0; j < aristas; j++) {
				int n = in.nextInt();
				int m = in.nextInt();
				int costo = in.nextInt();
				Edge edge = new Edge(m, costo);
				Edge f = new Edge(n, costo);
				list[n].add(edge);
				list[m].add(f);
			}
			solve = new long[nodos];

			long d = Dijkstra(list, ini, fin);
			if (d != Long.MAX_VALUE) {
				out.printf("Case #%d: %d%n", i + 1, d);
			} else {
				out.printf("Case #%d: unreachable%n", i + 1);
			}
		}

		out.close();
		in.close();
	}

	public static long Dijkstra(LinkedList<Edge> list[], int ini, int fin) {
		Arrays.fill(solve, Long.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();

		q.add(ini);
		solve[ini] = 0;

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < list[u].size(); i++) {
				if (list[u].get(i).costo + solve[u] < solve[list[u].get(i).a]) {
					solve[list[u].get(i).a] = list[u].get(i).costo + solve[u];
					q.add(list[u].get(i).a);
				}
			}
		}

		return solve[fin];
	}

	static class Edge implements Comparable<Edge> {
		int a, costo;

		public Edge(int a, int costo) {
			this.a = a;
			this.costo = costo;
		}

		@Override
		public int compareTo(Edge o) {

			return Long.compare(a, o.a) == 0 ? Long.compare(costo, o.costo) : Long.compare(a, o.a);
		}
	}
}