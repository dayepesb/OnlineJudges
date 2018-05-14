package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TouristGuide {

	public static ArrayList<Integer> ady[];
	public static int cnt, ord[], low[];
	public static String[] ciudade;
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int nodos, aristas;
		String nodo1, nodo2, ciudad;
		HashMap<String, Integer> ciudades;
		StringTokenizer st;
		nodos = Integer.parseInt(in.readLine());
		for (int k = 1;; k++) {
			ciudades = new HashMap<>();
			ciudade = new String[nodos];
			ady = new ArrayList[nodos];
			for (int i = 0; i < nodos; i++) {
				ciudad = in.readLine().trim();
				ciudades.put(ciudad, i);
				ciudade[i] = ciudad;
				ady[i] = new ArrayList<>();
			}
			aristas = Integer.parseInt(in.readLine());
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				nodo1 = st.nextToken();
				nodo2 = st.nextToken();
				ady[ciudades.get(nodo1)].add(ciudades.get(nodo2));
				ady[ciudades.get(nodo2)].add(ciudades.get(nodo1));
			}
			out.printf("City map #%d: ", k);
			articulationPoints();
			nodos = Integer.parseInt(in.readLine());
			if (nodos == 0)
				break;
			out.println("\n");
		}
		out.println();
		out.close();
		in.close();
	}

	public static void articulationPoints() {
		int nodos = ady.length;
		ord = new int[nodos];
		low = new int[nodos];
		ArrayList<String> res = new ArrayList<>();
		for (int v = 0; v < nodos; v++)
			if (ord[v] == 0) {
				cnt = 1;
				articulationPoints(v, v, res);
			}
		Collections.sort(res);
		out.printf("%d camera(s) found", res.size());
		for (int i = 0; i < res.size(); i++) {
			out.printf("%n%s", res.get(i));
		}
	}

	public static void articulationPoints(int v, int w, ArrayList<String> res) {
		low[w] = ord[w] = cnt++;
		for (int t : ady[w]) {
			if (ord[t] == 0) {
				articulationPoints(w, t, res);
				low[w] = Math.min(low[w], low[t]);
				if ((ord[w] == 1 && ord[t] != 2) || (ord[w] != 1 && low[t] >= ord[w]))
					if (!res.contains(ciudade[w]))
						res.add(ciudade[w]);
			} else if (t != v)
				low[w] = Math.min(low[w], ord[t]);
		}
	}

}
