package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CriticalLinks {

	public static int cnt, ord[], low[];
	public static ArrayList<Integer>[] ady;
	public static int nodos;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int nodo1, nodo2;
		StringTokenizer st;
		String line = in.readLine();
		for (int k = 0; line != null; k++) {

			while (true) {
				if (line.equals(""))
					line = in.readLine();
				else
					break;
			}
			nodos = Integer.parseInt(line.trim());
			ady = new ArrayList[nodos];

			for (int i = 0; i < nodos; i++)
				ady[i] = new ArrayList<>();

			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				nodo1 = Integer.parseInt(st.nextToken());
				st.nextToken();
				while (st.hasMoreTokens()) {
					nodo2 = Integer.parseInt(st.nextToken());
					ady[nodo1].add(nodo2);
//					ady[nodo2].add(nodo1);
				}
			}

			ArrayList<Edge> res = bridges();
			out.printf("%d critical links%n", res.size());
			for (int i = 0; i < res.size(); i++) {
				out.printf("%d - %d%n", res.get(i).a, res.get(i).b);
			}
			out.println();
			line = in.readLine();
		}

		out.close();
		in.close();
	}

	public static ArrayList<Edge> bridges() {
		int n = ady.length;
		ord = new int[n];
		low = new int[n];
		ArrayList<Edge> res = new ArrayList<>();
		for (int v = 0; v < n; v++)
			if (ord[v] == 0) {
				cnt = 1;
				bridges(v, v, res);
			}
		Collections.sort(res, new Comp());
		return res;
	}

	public static void bridges(int v, int w, ArrayList<Edge> res) {
		low[w] = ord[w] = cnt++;
		for (int t : ady[w])
			if (ord[t] == 0) {
				bridges(w, t, res);
				low[w] = Math.min(low[w], low[t]);
				if (low[t] == ord[t]) {
					Edge e = new Edge(w, t);
					res.add(e);
				}

			} else if (t != v)
				low[w] = Math.min(low[w], ord[t]);
	}

	public static class Edge {
		public int a, b;

		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static class Comp implements Comparator<Edge> {
		public int compare(Edge x, Edge y) {
			if (x.a != y.a)
				return x.a - y.a;
			else
				return x.b - y.b;
		}
	}
}
