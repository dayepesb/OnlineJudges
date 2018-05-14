package ProblemsIn_Java.NoteBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlujoEnRedes {
	class FordFukerson {
		int fordFulkerson(int graph[][], int s, int t) {
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

		boolean bfs(int rGraph[][], int s, int t, int parent[]) {
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

	class EdmonsKarp {
		double edmondsKarp(double[][] capacity, int s, int t) { // residualCapacity=capacity-flow
			int n = capacity.length, lAdy[][] = new int[n][], ants[] = new int[n], queue[] = new int[n], v, u;
			double f = 0d, m, flow[][] = new double[n][n], minCap[] = new double[n];
			List h[] = new List[n];
			for (u = 0; u < n; u++)
				h[u] = new ArrayList<Integer>();
			for (u = 0; u < n; u++)
				for (v = 0; v < n; v++)
					if (capacity[u][v] > 1e-10) {
						h[u].add(v);
						h[v].add(u);
					}
			for (u = 0; u < n; u++)
				lAdy[u] = toArr(h[u]);
			for (; (m = bfsEK(capacity, flow, lAdy, ants, minCap, queue, s, t)) > 1e-10; f += m)
				for (v = t, u = ants[v]; v != s; v = u, u = ants[v]) {
					flow[u][v] += m;
					flow[v][u] -= m;
				}
			return f;
		}

		double bfsEK(double[][] capacity, double[][] flow, int[][] lAdy, int[] ants, double[] minCap, int[] queue,
				int s, int r) {
			int i, t = 0, u;
			double z;
			Arrays.fill(ants, -1);
			ants[s] = -2;
			minCap[s] = Double.POSITIVE_INFINITY;
			for (queue[t++] = s, i = 0; i < t; i++)
				for (int v : lAdy[u = queue[i]])
					if ((z = capacity[u][v] - flow[u][v]) > 1e-10 && ants[v] == -1) {
						ants[v] = u;
						minCap[v] = Math.min(minCap[u], z);
						if (v == r)
							return minCap[r];
						queue[t++] = v;
					}
			return 0d;
		}

		int[] toArr(List<Integer> p) {
			int r[] = new int[p.size()], i = 0;
			for (int x : p)
				r[i++] = x;
			return r;
		}
	}

	class EdmonsKarp2 {

		final double INF = 1e-10;

		double edmondsKarp(double[][] capacity, int v1, int v2) { // residualCapacity=capacity-flow
			int n = capacity.length, lAdy[][] = new int[n][], ants[] = new int[n], queue[] = new int[n], v, u;
			double f = 0d, m, flow[][] = new double[n][n], minCap[] = new double[n];
			List h[] = new List[n];
			for (u = 0; u < n; u++)
				h[u] = new ArrayList<Integer>();
			for (u = 0; u < n; u++)
				for (v = 0; v < n; v++)
					if (capacity[u][v] > INF) {
						h[u].add(v);
						h[v].add(u);
					}
			for (u = 0; u < n; u++)
				lAdy[u] = toArr(h[u]);
			for (; (m = bfsEK(capacity, flow, lAdy, ants, minCap, queue, v1, v2)) > INF; f += m)
				for (v = v2, u = ants[v]; v != v1; v = u, u = ants[v]) {
					flow[u][v] += m;
					flow[v][u] -= m;
				}
			return f;
		}

		double bfsEK(double[][] capacity, double[][] flow, int[][] lAdy, int[] ants, double[] minCap, int[] queue,
				int v1, int v2) {
			int i, t = 0, u;
			double z;
			Arrays.fill(ants, -1);
			ants[v1] = -2;
			minCap[v1] = Double.POSITIVE_INFINITY;
			for (queue[t++] = v1, i = 0; i < t; i++)
				for (int v : lAdy[u = queue[i]])
					if ((z = capacity[u][v] - flow[u][v]) > INF && ants[v] == -1) {
						ants[v] = u;
						minCap[v] = Math.min(minCap[u], z);
						if (v == v2)
							return minCap[v2];
						queue[t++] = v;
					}
			return 0d;
		}

		int[] toArr(List<Integer> p) {
			int r[] = new int[p.size()], i = 0;
			for (int x : p)
				r[i++] = x;
			return r;
		}
	}
	class EdmonsKarp3{
		int [][] matriz;
		int [] pi;
		int flujo(int s, int t){
			int flow = 0;
			int residualN [][]=new int [matriz.length][matriz.length];
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					residualN[i][j] = matriz[i][j];
				}
			}
			pi = new int[matriz.length];
			while(bfs(s,t, residualN)){
				int min_flow = Integer.MAX_VALUE;
				for (int v = t; v != s; v = pi[v]) {
					int u = pi[v];
					min_flow = Math.min(min_flow, residualN[u][v]);
				}			
				
				for (int v = t; v != s; v = pi[v]) {
					int u = pi[v];
					residualN[u][v] -= min_flow;
					residualN[v][u] += min_flow;
				}
				flow += min_flow;
			}
			return flow;
		}

		boolean bfs(int s, int t, int [][] residualN) {
			Arrays.fill(pi, -2);
			Queue<Integer> q = new LinkedList<>();
			q.offer(s);
			pi[s] = -1;
			while(!q.isEmpty()){
				int u = q.poll();
				for (int v = 0; v < residualN[u].length; v++) {
					if((residualN[u][v] > 0) && (pi[v] == -2)){
						q.offer(v);
						pi[v] = u;
					}
				}
			}
			if(pi[t] >= 0){
				return true;
			}
			return false;
		}
	}
}
