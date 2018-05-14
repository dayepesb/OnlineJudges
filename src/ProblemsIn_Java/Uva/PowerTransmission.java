package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PowerTransmission {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line = in.readLine(); line != null; line = in.readLine()) {
			int nodos = Integer.parseInt(line.trim());
			int mAdy[][] = new int[nodos * 2 + 2][nodos * 2 + 2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < nodos; i++) {
				mAdy[i][i + nodos] = Integer.parseInt(st.nextToken());
			}
			int aristas = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				int nodo1 = (Integer.parseInt(st.nextToken()) - 1) + nodos;
				int nodo2 = (Integer.parseInt(st.nextToken()) - 1);
				int peso = Integer.parseInt(st.nextToken());
				mAdy[nodo1][nodo2] += peso;
			}
			st = new StringTokenizer(in.readLine());
			int fuente = mAdy.length - 2;
			int sumidero = mAdy.length - 1;
			int fuentes = Integer.parseInt(st.nextToken());
			int sumideros = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < fuentes; i++) {
				mAdy[fuente][Integer.parseInt(st.nextToken()) - 1] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < sumideros; i++) {
				mAdy[Integer.parseInt(st.nextToken()) - 1 + nodos][sumidero] = Integer.MAX_VALUE;
			}
			out.println(fordFulkerson(mAdy, fuente, sumidero));
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

		int max_flow = 0; // There is no flow initially

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
