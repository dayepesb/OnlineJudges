package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Network {

	public static int nodos, cnt, ord[], low[];;
	public static ArrayList<Integer>[] ady;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int nodo1, nodo2;

		while (true) {
			nodos = Integer.parseInt(in.readLine().trim());
			if (nodos == 0) {
				break;
			}

			ady = new ArrayList[nodos];
			for (int i = 0; i < ady.length; i++) {
				ady[i] = new ArrayList<>();
			}
			while (true) {
				st = new StringTokenizer(in.readLine());
				nodo1 = Integer.parseInt(st.nextToken()) - 1;
				if (nodo1 == -1) {
					break;
				}
				while (st.hasMoreTokens()) {
					nodo2 = Integer.parseInt(st.nextToken()) - 1;
					ady[nodo1].add(nodo2);
					ady[nodo2].add(nodo1);
				}
			}
			out.println(articulationPoints());
		}

		out.close();
		in.close();

	}

	public static int articulationPoints() {
		ord = new int[nodos];
		low = new int[nodos];
		boolean[] res = new boolean[nodos];
		for (int v = 0; v < nodos; v++)
			if (ord[v] == 0) {
				cnt = 1;
				articulationPoints(v, v, res);
			}
		int r = 0;
		for (int i = 0; i < res.length; i++) {
			if (res[i])
				r += 1;
		}
		return r;
	}

	public static void articulationPoints(int v, int w, boolean[] res) {
		low[w] = ord[w] = cnt++;
		for (int t : ady[w]) {
			if (ord[t] == 0) {
				articulationPoints(w, t, res);
				low[w] = Math.min(low[w], low[t]);
				if ((ord[w] == 1 && ord[t] != 2) || (ord[w] != 1 && low[t] >= ord[w]))
					res[w] = true;
			} else if (t != v)
				low[w] = Math.min(low[w], ord[t]);
		}
	}

}
