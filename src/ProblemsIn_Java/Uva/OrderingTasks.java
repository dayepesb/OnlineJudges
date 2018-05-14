package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class OrderingTasks {

	public static int nodos, aristas;
	public static boolean[] visited;
	public static ArrayList<Integer>[] ady;
	public static Stack<Integer> pila;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine());

		while (true) {
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());

			if (nodos == aristas && aristas == 0)
				break;

			ady = new ArrayList[nodos];
			visited = new boolean[nodos];
			for (int i = 0; i < ady.length; i++)
				ady[i] = new ArrayList<>();
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				ady[Integer.parseInt(st.nextToken()) - 1].add(Integer.parseInt(st.nextToken()) - 1);
			}
			int tp[] = topologicalSort();
			out.print((tp[0] + 1));
			for (int i = 1; i < ady.length; i++)
				out.print(" " + (tp[i] + 1));
			out.println();
			st = new StringTokenizer(in.readLine());
		}

		out.close();
		in.close();
	}

	public static int[] topologicalSort() {
		pila = new Stack<Integer>();

		for (int i = 0; i < nodos; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		int f[] = new int[nodos];
		for (int i = 0; i < f.length; i++) {
			f[i] = pila.pop();
		}
		return f;
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
}
