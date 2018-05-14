package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Dominos {

	public static boolean[] visited;
	public static ArrayList<Integer>[] ady;
	public static Stack<Integer> pila;
	public static int nodos, aristas;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int casos = Integer.parseInt(in.readLine()), nodo1, nodo2;
		StringTokenizer st;

		for (int k = 0; k < casos; k++) {
			st = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());

			ady = new ArrayList[nodos];
			for (int i = 0; i < nodos; ++i)
				ady[i] = new ArrayList<>();

			for (int i = 0; i < aristas; ++i) {
				st = new StringTokenizer(in.readLine());
				nodo1 = Integer.parseInt(st.nextToken()) - 1;
				nodo2 = Integer.parseInt(st.nextToken()) - 1;
				ady[nodo1].add(nodo2);
			}
			out.println(tarjan());
		}

		out.close();
		in.close();
	}

		public static int tarjan() {
			visited = new boolean[nodos];
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
