package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AlmostShortestPath {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int adys = Integer.parseInt(st.nextToken());
			if (n == 0 && adys == 0)
				break;
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			TreeSet<edge>[] mady = new TreeSet[n];
			for (int i = 0; i < mady.length; i++)
				mady[i] = new TreeSet<>();
			for (int i = 0; i < adys; i++) {
				st = new StringTokenizer(in.readLine());
				mady[Integer.parseInt(st.nextToken())]
						.add(new edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			dijkstra(mady, s, d);
			out.println(dijkstra(mady, s, d));
		}
		out.close();
	}

	private static int dijkstra(TreeSet<edge>[] mady, int s, int d) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		int[] mejor = new int[mady.length];
		Arrays.fill(mejor, Integer.MAX_VALUE / 2);
		ArrayList<edge>[] padres = new ArrayList[mady.length];
		for (int i = 0; i < padres.length; i++)
			padres[i] = new ArrayList<>();
		mejor[s] = 0;
		String[] cam = new String[mady.length];
		cam[s] = s + " ";
		while (!q.isEmpty()) {
			int u = q.poll();
			for (edge e : mady[u]) {
				int v = e.nodo;
				if (mejor[v] > mejor[u] + e.costo) {
					mejor[v] = mejor[u] + e.costo;
					q.add(v);
					padres[v] = new ArrayList<>();
					padres[v].add(new edge(u, e.costo));
					cam[v] = cam[u] + v + " ";
				} else if (mejor[v] == mejor[u] + e.costo)
					padres[v].add(new edge(u, e.costo));
			}
		}
		if (cam[d] == null)
			return -1;
		StringTokenizer st = new StringTokenizer(cam[d]);
		while (st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			for (edge e : padres[i])
				mady[e.nodo].remove(new edge(i, e.costo));
		}
		return mejor[d];
	}
}

class edge implements Comparable<edge> {
	int nodo, costo;

	public edge(int nodo, int costo) {
		this.nodo = nodo;
		this.costo = costo;
	}

	@Override
	public String toString() {
		return nodo + " " + costo;
	}

	@Override
	public int compareTo(edge o) {
		return Integer.compare(this.nodo, o.nodo) == 0 ? Integer.compare(this.costo, o.costo)
				: Integer.compare(this.nodo, o.nodo);
	}
}