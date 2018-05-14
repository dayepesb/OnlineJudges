package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BallsAndNeedles {
	/**
	 * @author David Yepes Time : 2.930 s
	 */
	static int aristas;
	static boolean visit[];
	static int padres[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		HashMap<String, Integer> nodos3d, nodos2d;
		HashMap<Integer, TreeSet<Integer>> ady2d, ady3d;
		String x1, y1, x2, y2;

		for (String line = in.readLine(); line != null; line = in.readLine()) {
			aristas = Integer.parseInt(line.trim());
			nodos3d = new HashMap<>();
			nodos2d = new HashMap<>();
			ady2d = new HashMap<>();
			ady3d = new HashMap<>();

			int index2d = 0, index3d = 0;

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());

				// contiene al nodo 1 en 2d y 3d
				x1 = st.nextToken() + "," + st.nextToken();
				if (!nodos2d.containsKey(x1)) {
					nodos2d.put(x1, index2d);
					ady2d.put(index2d, new TreeSet<>());
					index2d++;
				}
				y1 = x1 + "," + st.nextToken();
				if (!nodos3d.containsKey(y1)) {
					nodos3d.put(y1, index3d);
					ady3d.put(index3d, new TreeSet<>());
					index3d++;
				}

				// contiene al nodo 2 en 2d y 3d
				x2 = st.nextToken() + "," + st.nextToken();
				if (!nodos2d.containsKey(x2)) {
					nodos2d.put(x2, index2d);
					ady2d.put(index2d, new TreeSet<>());
					index2d++;
				}
				y2 = x2 + "," + st.nextToken();
				if (!nodos3d.containsKey(y2)) {
					nodos3d.put(y2, index3d);
					ady3d.put(index3d, new TreeSet<>());
					index3d++;
				}

				// crea las adyacencias en 3d
				ady3d.get(nodos3d.get(y2)).add(nodos3d.get(y1));
				ady3d.get(nodos3d.get(y1)).add(nodos3d.get(y2));
				// crea adyacencias en 2d
				ady2d.get(nodos2d.get(x1)).add(nodos2d.get(x2));
				ady2d.get(nodos2d.get(x2)).add(nodos2d.get(x1));
			}
			// manda el dfs para 3d
			visit = new boolean[ady3d.size()];
			padres = new int[ady3d.size()];
			Arrays.fill(padres, -1);
			boolean b = false;
			for (int i = 0; i < ady3d.size(); i++) {
				if (!visit[i])
					b = b || dfs(ady3d, i, -1);
				if (b)
					break;
			}
			out.println(b ? "True closed chains" : "No true closed chains");

			// manda el dfs para el 2d
			visit = new boolean[ady2d.size()];
			padres = new int[ady2d.size()];
			Arrays.fill(padres, -1);
			b = false;
			for (int i = 0; i < ady2d.size(); i++) {
				if (!visit[i])
					b = b || dfs(ady2d, i, -1);
				if (b)
					break;
			}

		}

		out.close();
		in.close();
	}

	static boolean dfs(HashMap<Integer, TreeSet<Integer>> grafo, int nodo, int ultimo) {
		visit[nodo] = true;
		padres[nodo] = ultimo;
		boolean b = false;
		TreeSet<Integer> ady = grafo.get(nodo);
		for (Iterator<Integer> it = ady.iterator(); it.hasNext();) {
			int w = it.next();
			if (visit[w] && w != ultimo && nodo != w) {
				b = b || true;
				break;
			} else if (!visit[w]) {
				b = b || dfs(grafo, w, nodo);
			}
		}
		return b;
	}
}