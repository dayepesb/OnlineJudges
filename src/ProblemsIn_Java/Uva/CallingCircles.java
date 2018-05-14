package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;

public class CallingCircles {

	public static String nodo1, nodo2;
	public static int nodos, aristas;
	public static int preCount;
	public static HashMap<String, Integer> low = new HashMap<>();
	public static HashMap<String, Boolean> visited = new HashMap<>();
	public static ArrayList<ArrayList<String>> sccComp;
	public static Stack<String> pila = new Stack<>();
	public static HashMap<String, ArrayList<String>> ady = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());
		nodos = Integer.parseInt(st.nextToken());
		aristas = Integer.parseInt(st.nextToken());

		for (int caso = 1;; caso++) {

			ady.clear();
			visited.clear();
			low.clear();
			preCount = 0;
			pila.clear();

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				nodo1 = st.nextToken();
				nodo2 = st.nextToken();
				if (!ady.containsKey(nodo1)) {
					ady.put(nodo1, new ArrayList<>());
				}
				if (!ady.containsKey(nodo2)) {
					ady.put(nodo2, new ArrayList<>());
				}
				ady.get(nodo1).add(nodo2);
				visited.put(nodo1, false);
				visited.put(nodo2, false);
				low.put(nodo1, 0);
				low.put(nodo2, 0);
			}

			out.printf("Calling circles for data set %d:%n", caso);
			ArrayList<ArrayList<String>> sol = Tarjan();
			for (int i = 0; i < sol.size(); i++) {
				String s = sol.get(i).get(0);
				for (int j = 1; j < sol.get(i).size(); j++) {
					s += ", " + sol.get(i).get(j);
				}
				out.println(s);
			}

			st = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());
			if (nodos == aristas && aristas == 0) {
				break;
			} else {
				out.println();
			}
		}

		out.close();
		in.close();
	}

	public static ArrayList<ArrayList<String>> Tarjan() {
		pila = new Stack<String>();
		sccComp = new ArrayList<>();

		for (Entry<String, ArrayList<String>> f : ady.entrySet()) {
			if (!visited.get(f.getKey())) {
				dfs(f.getKey());
			}
		}

		return sccComp;
	}

	public static void dfs(String v) {
		low.put(v, preCount++);
		visited.put(v, true);
		pila.push(v);
		int min = low.get(v);

		ArrayList<String> a = ady.get(v);
		for (String w : a) {
			if (!visited.get(w)) {
				dfs(w);
			}
			if (low.get(w) < min) {
				min = low.get(w);
			}
		}

		if (min < low.get(v)) {
			low.put(v, min);
			return;
		}

		ArrayList<String> component = new ArrayList<>();

		String w;
		do {
			w = pila.pop();
			component.add(w);
			low.put(w, aristas);
		} while (!(w.equals(v)));
		sccComp.add(component);
	}

}
