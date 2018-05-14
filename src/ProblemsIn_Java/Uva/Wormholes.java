package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Wormholes {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		ArrayList<Edge>[] ady;

		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {

			st = new StringTokenizer(in.readLine());
			int sistemas = Integer.parseInt(st.nextToken());
			int agujeros = Integer.parseInt(st.nextToken());

			ady = new ArrayList[sistemas];
			for (int j = 0; j < ady.length; j++) {
				ady[j] = new ArrayList<>();
			}

			for (int j = 0; j < agujeros; j++) {
				st = new StringTokenizer(in.readLine());
				int nodo1 = Integer.parseInt(st.nextToken());
				int nodo2 = Integer.parseInt(st.nextToken());
				int peso = Integer.parseInt(st.nextToken());
				ady[nodo1].add(new Edge(nodo2, peso));
			}

			if (!bellmanFord(ady, sistemas, agujeros)) {
				out.println("possible");
			} else {
				out.println("not possible");
			}
		}

		out.close();
		in.close();
	}

	public static boolean bellmanFord(ArrayList<Edge>[] ady, int sistemas, int agujeros) {

		int mins[] = new int[sistemas];

		for (int i = 0; i < sistemas - 1; i++) {
			for (int u = 0; u < sistemas; u++) {
				for (Edge e : ady[u]) {
					mins[e.dest] = Math.min(mins[e.dest], mins[u] + e.peso);
				}
			}
		}

		boolean res = true;

		for (int u = 0; u < sistemas && res; u++) {
			for (Edge e : ady[u]) {
				if (mins[e.dest] > mins[u] + e.peso) {
					res = false;
					break;
				}
			}
		}

		return res;
	}

	public static class Edge {
		public int dest;
		public int peso;

		public Edge(int dest, int peso) {
			this.peso = peso;
			this.dest = dest;
		}
	}

}
