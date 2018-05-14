package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class LightingAway {

	public static int nodos, aristas, preCount;
	public static int[] low;
	public static boolean[] visited;
	public static ArrayList<Integer>[] ady;
	public static ArrayList<ArrayList<Integer>> sccComp;
	public static Stack<Integer> pila;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String line;
		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine());

		for (int caso = 1; caso <= casos; caso++) {

			line = in.readLine();
			while (true) {
				if (!line.equals("")) {
					break;
				}
				line = in.readLine();
			}

			st = new StringTokenizer(line);
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());

			preCount = 0;
			low = new int[nodos];
			visited = new boolean[nodos];
			ady = new ArrayList[nodos];
			for (int j = 0; j < ady.length; j++)
				ady[j] = new ArrayList<>();

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				ady[Integer.parseInt(st.nextToken()) - 1].add(Integer.parseInt(st.nextToken()) - 1);
			}
			out.printf("Case %d: %d%n", caso, tarjan());
		}

		out.close();
		in.close();
	}

	public static int tarjan() {
		pila = new Stack<Integer>();

		for (int i = nodos - 1; i >= 0; --i) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		visited = new boolean[nodos];
		int numComp = 0;
		while (!pila.isEmpty()) {
			int x = pila.pop();
			if (!visited[x]) {
				++numComp;
				dfs2(x);
			}
		}
		return numComp;
	}

	public static void dfs(int u) {
		visited[u] = true;

		for (int v : ady[u]) {
			if (!visited[v]) {
				dfs(v);
			}
		}
		pila.push(u);
	}

	public static void dfs2(int u) {
		visited[u] = true;
		for (int v : ady[u]) {
			if (!visited[v]) {
				dfs2(v);
			}
		}
	}
}
