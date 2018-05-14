package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class InternetBandwidth {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int capacity[][], peso;
		int source, target, adyacencias, nodos, nodo1, nodo2;
		StringTokenizer st;
		int caso = 1;
		for (String line; !(line = in.readLine().trim()).equals("0");) {
			nodos = Integer.parseInt(line);
			capacity = new int[nodos][nodos];
			st = new StringTokenizer(in.readLine());
			source = Integer.parseInt(st.nextToken()) - 1;
			target = Integer.parseInt(st.nextToken()) - 1;
			adyacencias = Integer.parseInt(st.nextToken());
			for (int i = 0; i < adyacencias; i++) {
				st = new StringTokenizer(in.readLine());
				nodo1 = Integer.parseInt(st.nextToken()) - 1;
				nodo2 = Integer.parseInt(st.nextToken()) - 1;
				peso = Integer.parseInt(st.nextToken());
				capacity[nodo1][nodo2] = capacity[nodo2][nodo1] += peso;
			}
			out.printf("Network %d%nThe bandwidth is %d.%n%n", caso++, fordFulkerson(capacity, source, target));
		}

		out.close();
		in.close();
	}

	static int fordFulkerson(int graph[][], int s, int t) {
		int u, v;
		int V = graph.length;
		int rGraph[][] = new int[V][V];

		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];

		int parent[] = new int[V];

		int max_flow = 0; // Flujo inicial

		while (bfs(rGraph, s, t, parent)) {
			int path_flow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}

			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}

			max_flow += path_flow;
		}

		return max_flow;
	}

	static boolean bfs(int rGraph[][], int s, int t, int parent[]) {
		int V = rGraph.length;
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			visited[i] = false;

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1;

		while (queue.size() != 0) {
			int u = queue.poll();

			for (int v = 0; v < V; v++) {
				if (visited[v] == false && rGraph[u][v] > 0) {
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		return (visited[t] == true);
	}
}
