package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class TrustGroups {
	public static String apellido1, nombre1, apellido2, nombre2;
	public static int nodos, aristas;
	public static int preCount;
	public static HashMap<String, Integer> low;
	public static HashMap<String, Boolean> visited;
	public static ArrayList<ArrayList<String>> sccComp;
	public static Stack<String> pila = new Stack<>();
	public static HashMap<String, ArrayList<String>> ady;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String name1, name2;
		StringTokenizer st = new StringTokenizer(in.readLine());

		while (true) {
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());
			if (nodos == aristas && aristas == 0)
				break;

			ady = new HashMap<>();
			visited = new HashMap<>();
			low = new HashMap<>();
			preCount = 1;
			pila = new Stack<>();

			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine().trim(), ", ");
				apellido1 = st.nextToken();
				nombre1 = st.nextToken();
				name1 = nombre1 + apellido1;
				ady.put(name1, new ArrayList<>());
				visited.put(name1, false);
				low.put(name1, 0);
			}

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine().trim(), ", ");
				apellido1 = st.nextToken();
				nombre1 = st.nextToken();
				name1 = nombre1 + apellido1;

				st = new StringTokenizer(in.readLine().trim(), ", ");
				apellido2 = st.nextToken();
				nombre2 = st.nextToken();
				name2 = nombre2 + apellido2;

				if (ady.containsKey(name1)) {
					ady.get(name1).add(name2);
				}

			}
			out.println(Tarjan());
			st = new StringTokenizer(in.readLine());
		}

		out.close();
		in.close();
	}

	public static int Tarjan() {
		pila = new Stack<String>();
		sccComp = new ArrayList<>();

		for (Entry<String, ArrayList<String>> f : ady.entrySet()) {
			if (!visited.get(f.getKey())) {
				dfs(f.getKey());
			}
		}
		ArrayList<String> s = new ArrayList<>();
		while (!pila.isEmpty()) {
			s.add(pila.pop());
		}
		if (s.size() > 0)
			sccComp.add(s);
		return sccComp.size();
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
