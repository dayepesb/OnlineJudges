package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FlyingToFredericton {

	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static final int inf = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int res;
		String line;
		StringTokenizer st;
		HashMap<String, Integer> ciudades = new HashMap<>();
		ArrayList<Edge> list[];

		int casos = Integer.parseInt(in.readLine().trim()), nodos, aristas, consultas;

		for (int k = 1; k <= casos; k++) {
			out.printf("Scenario #%d%n", k);
			ciudades.clear();
			line = in.readLine();
			while (true) {
				if (!(line.equals(""))) {
					break;
				}
				line = in.readLine();
			}
			nodos = Integer.parseInt(line.trim());
			for (int i = 0; i < nodos; i++) {
				ciudades.put(in.readLine().trim(), i);
			}
			aristas = Integer.parseInt(in.readLine().trim());
			list = new ArrayList[aristas];
			for (int i = 0; i < aristas; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				list[ciudades.get(st.nextToken())]
						.add(new Edge(ciudades.get(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(in.readLine());
			consultas = Integer.parseInt(st.nextToken());
			int[][] array = Bellman(list, nodos);
			for (int i = 0; i < consultas; i++) {
				res = array[Math.min(Integer.parseInt(st.nextToken()), array.length - 1)][array[0].length - 1];
				out.printf(res == inf ? "No satisfactory flights%n" : "Total cost of flight(s) is $%d%n", res);
			}
			if (k < casos) {
				out.println();
			}
		}

		out.close();
		in.close();
	}

	public static int[][] Bellman(ArrayList<Edge> ady[], int nodos) {
		int array[][] = new int[nodos + 1][nodos];
		for (int i = 0; i < array.length; i++) {
			Arrays.fill(array[i], inf);
		}
		array[0][0] = 0;
		if (ady.length > 0) {
			for (int i = 0; i < ady[0].size(); i++) {
				array[0][ady[0].get(i).nodo] = Math.min(array[0][ady[0].get(i).nodo], ady[0].get(i).peso);
			}
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < ady.length; j++) {
				for (Edge e : ady[j]) {
					array[i][e.nodo] = Math.min(array[i - 1][e.nodo], array[i][e.nodo]);
					array[i][e.nodo] = Math.min(array[i][e.nodo], array[i - 1][j] + e.peso);

				}
			}
		}

		return array;
	}

	static class Edge {
		public int nodo;
		public int peso;

		public Edge(int nodo, int peso) {
			this.nodo = nodo;
			this.peso = peso;
		}

		@Override
		public String toString() {
			return nodo + " " + peso;
		}
	}
}
