package ProblemsIn_Java.NoteBook;
/**
 * @author david yepes
 *  falta: jhonson,flujpo en redes
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Grafos {
	/*
	 * FloydWarshal de todos a todos los nodos con pesos negativos O(n^3)
	 */
	class FloydWarshall {
		public double[][] floydWarshall(double[][] mAdy) {
			/*
			 * 
			 * Minimax x[i][j]=Math.min(x[i][j],Math.max(x[i][k],x[k][j]))
			 * 
			 * Maximin x[i][j]=Math.max(x[i][j],Math.min(x[i][k],x[k][j]))
			 * 
			 */

			int n = mAdy.length;
			double x[][] = new double[n][n];
			for (int i = 0; i < n; i++) {
				System.arraycopy(mAdy[i], 0, x[i], 0, n);
			}
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						x[i][j] = Math.min(x[i][j], x[i][k] + x[k][j]);
					}
				}
			}
			return x;
		}

		// floydWarshal con el camino recontruido
		public void FloydWarshallWithPathReconstruction(int mAdy[][], int start, int end) {

			// INF = Integer.MAX_VALUE / 2;
			int n = mAdy.length;
			int road[][] = new int[n][n];
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					if (mAdy[i][k] != Integer.MAX_VALUE / 2) {
						for (int j = 0; j < n; j++) {
							if (mAdy[k][j] != Integer.MAX_VALUE / 2 && mAdy[i][k] + mAdy[k][j] < mAdy[i][j]) {
								mAdy[i][j] = mAdy[i][k] + mAdy[k][j];
								road[i][j] = road[i][k];
							}
						}
					}
				}
			}

			String path = reConstrucPath(road, start, end);

		}

		public String reConstrucPath(int road[][], int start, int end) {
			StringBuilder sb = new StringBuilder();
			sb.append(start);
			do {
				start = road[start][end];
				sb.append(start + " ");
			} while (start != end);
			return sb.toString().trim();
		}

	}

	/*
	 * recorrido de un grafo por niveles {O(V+E)}
	 */
	class BFS {
		public void Bfs(boolean mAdy[][], int origen) {
			boolean visit[] = new boolean[10];
			Queue<Integer> cola = new LinkedList<>();
			cola.add(origen);
			visit[origen] = true;
			while (!cola.isEmpty()) {
				int v = cola.poll();
				for (int i = 0; i < mAdy[v].length; i++) {
					if (mAdy[v][i] && (!visit[i])) {
						visit[i] = true;
						cola.add(i);
					}
				}
			}

		}
	}

	/*
	 * recorrido de un grafo a profundidad {O(V+E)}
	 */
	class dfsRecursive {
		public void DfsRecursivo(boolean mAdy[][], int origen, boolean visit[]) {
			visit[origen] = true;
			for (int i = 0; i < mAdy[origen].length; i++) {
				if (mAdy[origen][i]) {
					if (!visit[i]) {
						visit[i] = true;
						DfsRecursivo(mAdy, i, visit);
					}
				}
			}
		}
	}

	/*
	 * dijkstra para grafos con peso positivo n*n
	 */
	class dfsStack {
		public void dfsPila(boolean mAdy[][], int origen, boolean visit[]) {
			Stack<Integer> pila = new Stack<>();
			pila.push(origen);
			visit[origen] = true;
			if (!pila.isEmpty()) {
				int v = pila.pop();
				for (int i = 0; i < mAdy[v].length; i++) {
					if (mAdy[v][i] && (!visit[i])) {
						visit[i] = true;
						pila.push(i);
					}
				}
			}
		}
	}

	class dfsIterative {
		public void dfsIterativo(boolean mAdy[][], int origen, boolean visit[]) {

		}
	}

	class dijkstraPQ {
		public void dijkstra_PriorityQueue(long mAdy[][], long solve[]) {
			PriorityQueue<Integer> q = new PriorityQueue<>();
			q.add(mAdy.length - 2);
			solve[mAdy.length - 2] = 0;
			while (!q.isEmpty()) {
				int u = q.poll();
				for (int i = 0; i < mAdy.length; i++) {
					if (mAdy[u][i] != -1 && (mAdy[u][i] + solve[u]) < solve[i]) {
						solve[i] = mAdy[u][i] + solve[u];
						q.add(i);
					}
				}
			}
		}
	}

	/*
	 * dijstra para grafos con pesos positivos
	 */
	class DijkstraLista {
		public long[] Dijkstra_Lista(int ini, ArrayList<Edge>[] list, long solve[]) {
			PriorityQueue<Integer> q = new PriorityQueue<>();

			q.add(ini);
			solve[ini] = 0;

			while (!q.isEmpty()) {
				int u = q.poll();
				for (int i = 0; i < list[u].size(); i++) {
					if (list[u].get(i).costo + solve[u] < solve[list[u].get(i).nodo]) {
						solve[list[u].get(i).nodo] = list[u].get(i).costo + solve[u];
						q.add(list[u].get(i).nodo);
					}
				}
			}

			return solve;
		}

		public class Edge implements Comparable<Edge> {

			public int nodo, costo;

			public Edge(int nodo, int costo) {
				this.nodo = nodo;
				this.costo = costo;
			}

			@Override
			public int compareTo(Edge o) {
				return Integer.compare(this.nodo, o.nodo) == 0 ? Integer.compare(this.costo, o.costo)
						: Integer.compare(this.nodo, o.nodo);
			}

			@Override
			public String toString() {
				return String.format("%d %d3", nodo, costo);
			}
		}

	}

	/*
	 * Bellman ford para grafos con pesos negativos {O(V*E)}
	 */
	class BellManFord1 {

		public boolean bellmanFord(ArrayList<EdgeF>[] ady, int nodos, int aristas) {

			int mins[] = new int[nodos];

			for (int i = 0; i < nodos - 1; i++) {
				for (int u = 0; u < nodos; u++) {
					for (EdgeF e : ady[u]) {
						mins[e.dest] = Math.min(mins[e.dest], mins[u] + e.peso);
					}
				}
			}

			boolean res = true;

			for (int u = 0; u < nodos && res; u++) {
				for (EdgeF e : ady[u]) {
					if (mins[e.dest] > mins[u] + e.peso) {
						res = false;
						break;
					}
				}
			}

			return res;
		}

		class EdgeF {
			int dest;
			int peso;

			EdgeF(int dest, int peso) {
				this.peso = peso;
				this.dest = dest;
			}
		}
	}

	class BellManFord2 {

		public boolean bellmanFordSimple(ArrayList<EdgeF>[] ady, int nodos, int aristas) {

			int solve[] = new int[nodos];
			String padres[] = new String[nodos];
			for (int i = 0; i < padres.length; i++) {
				solve[i] = Integer.MAX_VALUE;
				padres[i] = "*";
			}
			int nodoIni = 0;
			solve[nodoIni] = 0;
			boolean hayCambios = true;
			for (int padre = 0; padre < padres.length && hayCambios; padre++) {
				hayCambios = false;
				for (EdgeF e : ady[padre]) {
					if (solve[e.dest] > solve[padre] + e.peso) {
						solve[e.dest] = solve[padre] + e.peso;
						padres[e.dest] = padre + ",";
						hayCambios = true;
					}
				}
			}

			return hayCambios;
		}

		class EdgeF {
			int dest;
			int peso;

			EdgeF(int dest, int peso) {
				this.peso = peso;
				this.dest = dest;
			}
		}
	}

	class JhonsonAlgoritmo {
		public void johnson(ArrayList<EdgeF>[] ady, int nodos, int aristas) {
			/*
			 * 
			 * 
			 * 
			 */
		}

		class EdgeF {
			int dest;
			int peso;

			EdgeF(int dest, int peso) {
				this.peso = peso;
				this.dest = dest;
			}
		}

	}

	/*
	 * Kosaraju : Componentes fuertemente conexas {O(V+E)}
	 */

	class Kosaraju { // lista todas las componentes

		public List<Integer>[] graph;
		public List<Integer>[] reverseGraph = GrafoTranspuesto();
		int V = graph.length;
		boolean[] visited = new boolean[V];

		public List<List<Integer>> Kosaraju() {

			List<Integer> order = DFS_GrafoNormal();

			visited = new boolean[V];
			Collections.reverse(order);

			List<List<Integer>> SCComp = new ArrayList<>();
			for (int i = 0; i < order.size(); i++) {
				int v = order.get(i);
				if (!visited[v]) {
					List<Integer> comp = new ArrayList<>();
					DFS(reverseGraph, v, visited, comp);
					SCComp.add(comp);
				}
			}
			return SCComp;
		}

		public List<Integer>[] GrafoTranspuesto() {
			int V = graph.length;
			List<Integer>[] g = new List[V];
			for (int i = 0; i < V; i++)
				g[i] = new ArrayList<Integer>();
			for (int v = 0; v < V; v++)
				for (int i = 0; i < graph[v].size(); i++)
					g[graph[v].get(i)].add(v);
			return g;
		}

		public List<Integer> DFS_GrafoNormal() {
			int V = graph.length;
			List<Integer> order = new ArrayList<Integer>();

			for (int i = 0; i < V; i++)
				if (!visited[i])
					DFS(graph, i, visited, order);
			return order;
		}

		public void DFS(List<Integer>[] graph, int v, boolean[] visited, List<Integer> comp) {
			visited[v] = true;
			for (int i = 0; i < graph[v].size(); i++)
				if (!visited[graph[v].get(i)])
					DFS(graph, graph[v].get(i), visited, comp);
			comp.add(v);
		}

	}

	/*
	 * Tarjan : Componentes fuertemente conexas {O(V+E)}
	 */
	class TarjanAlgoritmo {
		private int vertices;
		private int preCount;
		private int[] low;
		private boolean[] visited;
		private List<Integer>[] ady;
		private List<List<Integer>> sccComp;
		private Stack<Integer> stack;

		public List<List<Integer>> getSCComponents(List<Integer>[] graph) {
			vertices = graph.length;
			this.ady = graph;
			low = new int[vertices];
			visited = new boolean[vertices];
			stack = new Stack<Integer>();
			sccComp = new ArrayList<>();

			for (int v = 0; v < vertices; v++) {
				if (!visited[v]) {
					dfs(v);
				}
			}
			return sccComp;
		}

		public void dfs(int v) {
			low[v] = preCount++;
			visited[v] = true;
			stack.push(v);
			int min = low[v];
			for (int w : ady[v]) {
				if (!visited[w]) {
					dfs(w);
				}
				if (low[w] < min) {
					min = low[w];
				}
			}
			if (min < low[v]) {
				low[v] = min;
				return;
			}
			List<Integer> component = new ArrayList<Integer>();
			int w;
			do {
				w = stack.pop();
				component.add(w);
				low[w] = vertices;
			} while (w != v);
			sccComp.add(component);
		}
	}

	/*
	 * Tarjan #2 : sirve para encontrar cuantos golpes como minimo para llegar a
	 * todos los nodos es una mezcla de orden topoligo y dfs {O(V+E)}
	 */
	class TarjanAlgoritmo_2 {

		public int nodos, aristas;
		public boolean[] visited;
		public ArrayList<Integer>[] ady;
		public Stack<Integer> pila;

		public int tarjan() {
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

		public void dfs(int u) {
			visited[u] = true;

			for (int v : ady[u]) {
				if (!visited[v]) {
					dfs(v);
				}
			}
			pila.push(u);
		}

		public void dfs2(int u) {
			visited[u] = true;
			for (int v : ady[u]) {
				if (!visited[v]) {
					dfs2(v);
				}
			}
		}
	}

	/*
	 * Topological sort o orden topologico : no se puede hacer una tarea si tiene
	 * hijos {O(V+E)}
	 */
	public class Topoligical_Sort_1 {
		int[] topologicalSort(ArrayList<Integer> lAdy[]) {
			// Retorna null si no recibe un DAG
			int n = lAdy.length, state[] = new int[n];
			List<Integer> r = new ArrayList<Integer>();
			for (int v = 0; v < n; v++)
				if (state[v] == 0 && !dfsTS(lAdy, v, state, r))
					return null;
			int t = r.size(), a[] = new int[t], i;
			for (i = 0; i < t; i++)
				a[i] = r.get(t - 1 - i);
			return a;
		}

		boolean dfsTS(ArrayList<Integer> lAdy[], int v, int[] state, List<Integer> r) {
			state[v] = 1;
			for (int w : lAdy[v])
				if (state[w] == 1 || (state[w] == 0 && !dfsTS(lAdy, w, state, r)))
					return false;
			state[v] = 2;
			r.add(v);
			return true;
		}
	}

	public class Topoligical_Sort_2 {

		public int nodos, aristas;
		public boolean[] visited;
		public ArrayList<Integer>[] ady;
		public Stack<Integer> pila;

		public int[] topologicalSort() {
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

		public void dfs(int u) {
			visited[u] = true;

			for (int v : ady[u]) {
				if (!visited[v]) {
					dfs(v);
				}
			}
			pila.push(u);
		}
	}

	//
	// Ordden Topologico de todas las posibles formas
	//

	public class topologicalsort_todos {

		public ArrayList<Integer> ady[];
		public String nodos[], adyacencias[];
		public int map[] = new int[128];
		public int d[], n;
		public char res[], unMap[];

		public void dfs(int l) {
			if (l == 0) {
				System.out.println(new String(res));
			} else {
				for (int i = 0; i < n; i++) {
					if (d[i] == 0) {
						d[i] = -1;
						res[n - l] = unMap[i];
						for (Integer j : ady[i]) {
							d[j]--;
						}
						dfs(l - 1);
						for (Integer j : ady[i]) {
							d[j]++;
						}
						d[i] = 0;
					}
				}
			}
		}

	}

	/*
	 * ARTICULAATION POINTS : vertices que al quitarse desconectan el grafo {O(V+E)}
	 */
	class ArticulationPointsTarjan {
		boolean vis[];
		int time[];
		int low[];
		int padres[];
		BitSet bits = new BitSet();

		private void tarjan(int u, ArrayList<Integer>[] lAdy, int t) {
			vis[u] = true;
			time[u] = t;
			low[u] = t;
			int hijos = 0;
			boolean artic = false;
			for (int v : lAdy[u]) {
				if (!vis[v]) {
					padres[v] = u;
					tarjan(v, lAdy, t + 1);
					hijos++;
					if (low[v] >= time[u])
						artic = true;
					low[u] = Math.min(low[u], low[v]);
				} else {
					if (padres[u] != v)
						low[u] = Math.min(low[u], time[v]);
				}
			}
			if (padres[u] != -1 && artic || padres[u] == -1 && hijos > 1)
				bits.set(u);
		}
	}

	class ArticulationPoints {

		int cnt, ord[], low[];
		ArrayList<Integer>[] ady;

		ArrayList<Integer> articulationPoints() {
			int n = ady.length;
			ord = new int[n];
			low = new int[n];
			ArrayList<Integer> res = new ArrayList<>();
			for (int v = 0; v < n; v++)
				if (ord[v] == 0) {
					cnt = 1;
					articulationPoints(v, v, res);
				}
			return res;
		}

		void articulationPoints(int v, int w, ArrayList<Integer> res) {
			low[w] = ord[w] = cnt++;
			for (int t : ady[w]) {
				if (ord[t] == 0) {
					articulationPoints(w, t, res);
					low[w] = Math.min(low[w], low[t]);
					if ((ord[w] == 1 && ord[t] != 2) || (ord[w] != 1 && low[t] >= ord[w]))
						res.add(w);
				} else if (t != v)
					low[w] = Math.min(low[w], ord[t]);
			}
		}
	}

	/*
	 * Bridges: aristas o puentes que al quitarse desconectan el grafo {O(V+E)}
	 */

	class Bridges {
		int cnt, ord[], low[];
		ArrayList<Integer>[] ady;

		ArrayList<Edge> bridges() {
			int n = ady.length;
			ord = new int[n];
			low = new int[n];
			ArrayList<Edge> res = new ArrayList<>();
			for (int v = 0; v < n; v++)
				if (ord[v] == 0) {
					cnt = 1;
					bridges(v, v, res);
				}
			// se organiza los puentes segun el numero de menor a mayor con el
			// comparator
			Collections.sort(res, new Comp());
			return res;
		}

		void bridges(int v, int w, ArrayList<Edge> res) {
			low[w] = ord[w] = cnt++;
			for (int t : ady[w])
				if (ord[t] == 0) {
					bridges(w, t, res);
					low[w] = Math.min(low[w], low[t]);
					if (low[t] == ord[t]) {
						Edge e = new Edge(w, t);
						res.add(e);
					}

				} else if (t != v)
					low[w] = Math.min(low[w], ord[t]);
		}

		class Comp implements Comparator<Edge> {
			public int compare(Edge x, Edge y) {
				if (x.a != y.a)
					return x.a - y.a;
				else
					return x.b - y.b;
			}
		}

		class Edge {
			public int a, b;

			public Edge(int a, int b) {
				this.a = a;
				this.b = b;
			}
		}
	}

	/*
	 * Algoritmo de prim: arbol de expancion minimal
	 */

	class Prim {
		public boolean[][] prim(int mAdy[][], ArrayList<Integer> lAdy[]) { // parfa
																			// agrafos
																			// no
																			// dirigidos
			int n = mAdy.length, k, i, ie, je;
			boolean res[][] = new boolean[n][n], vis[] = new boolean[n];
			for (vis[0] = true, k = 1; k < n; k++) {
				double me = Double.POSITIVE_INFINITY;
				for (i = 0, ie = je = -1; i < n; i++)
					if (vis[i]) {
						for (int j : lAdy[i]) {
							if (!vis[j] && mAdy[i][j] < me) {
								ie = i;
								je = j;
								me = mAdy[i][j];
							}
						}
					}
				res[ie][je] = res[je][ie] = vis[je] = true;
			}
			return res;
		}
	}

	class PrimPQ { // O(V+E)
		// PriorityQueue

		public ArrayList<edge> lAdy[];

		public boolean[][] primPQ() {
			boolean visit[] = new boolean[lAdy.length];
			PriorityQueue<edge> pq = new PriorityQueue<>();
			boolean res[][] = new boolean[lAdy.length][lAdy.length];
			pq.addAll(lAdy[0]);
			while (!pq.isEmpty()) {
				edge v = pq.poll();
				if (!visit[v.end]) {
					visit[v.start] = true;
					visit[v.end] = true;
					res[v.start][v.end] = res[v.end][v.start] = true;
					pq.addAll(lAdy[v.end]);
				}
			}
			return res;
		}

		class edge implements Comparable<edge> {
			int start, end, with;

			public edge(int start, int end, int with) {
				this.start = start;
				this.end = end;
				this.with = with;
			}

			@Override
			public int compareTo(edge b) {
				return Integer.compare(this.with, b.with);
			}

			@Override
			public String toString() {
				return (this.start) + "," + (this.end) + "," + this.with;
			}
		}

	}

	/*
	 * Algoritmo de kruskall: arbol de expancion minimal
	 */

	class Kruskall {
		// Lista todas las adyacencias
		ArrayList<edge> ady;
		// el set lo llena de menos 1
		int set[];

		// y organiza las adyacencias conforme al peso con un
		// Collections.sort();
		// para unirlas solo se tiene que preguntar que el padre de u sea
		// diferente al padre de v y ya los puede unir
		class edge implements Comparable<edge> {
			int u, v;
			int weith;

			public edge(int u, int v, int weith) {
				this.u = u;
				this.v = v;
				this.weith = weith;
			}

			@Override
			public int compareTo(edge e) {
				return Integer.compare(this.weith, e.weith);
			}
		}

		int[] union(int x, int y) {
			x = find(x);
			y = find(y);

			if (x == y)
				return set;

			int sizex = -(set[x]);
			int sizey = -(set[y]);

			if (sizex < sizey) {
				set[y] = set[y] + set[x];
				set[x] = y;
			} else {
				set[x] = set[x] + set[y];
				set[y] = x;
			}

			return set;
		}

		/*
		 * Busca el padre o nodo raiz en este arbol
		 */
		int find(int x) {
			if (set[x] < 0)
				return x;
			else
				return set[x] = find(set[x]);
		}
	}

	/*
	 * TPS
	 */

	class TPSAlgoritmo {
		public double TravelingSalesmanProblem(double[][] mAdy, int v) { // TPS
			int n = mAdy.length, t = 1 << n;
			double mem[][] = new double[t][n];
			for (double[] arr : mem) {
				Arrays.fill(arr, -1d);
			}
			return TravelingSalesmanProblem(mAdy, n, v, v, 1 << v, mem);
		}

		public double TravelingSalesmanProblem(double[][] mAdy, int n, int v1, int v2, int visitados, double[][] mem) {
			if (mem[visitados][v1] >= 0d) {
				return mem[visitados][v1];
			}
			if (visitados == (1 << n) - 1) {
				return mem[visitados][v1] = mAdy[v1][v2];
			}
			double min = Double.POSITIVE_INFINITY, d;
			for (int e = visitados, j = 0; j < n; j++, e >>>= 1) {
				if ((e & 1) == 0 && (d = mAdy[v1][j]) < min) {
					min = Math.min(min, d + TravelingSalesmanProblem(mAdy, n, j, v2, visitados | (1 << j), mem));
				}
			}
			return mem[visitados][v1] = min;
		}
	}

	class CaminoEulerianoGrafosDirigidos {
		/*
		 * Camino Euleriano : Camino en el grafo que pasa solo una vez por cada arista
		 * Circuito o ciclo euleriano : circuito cerrado en el grafo que contiene a cada
		 * arista una solo vez en su recorrrido
		 * 
		 * Un grafo dirigido G= V,E tiene un ciclo Euleriano si es conexo y todo v�rtice
		 * v cumple que inDegree(v)=outDegree(v). Un grafo dirigido G= V,E tiene un
		 * camino Euleriano si es conexo y todo v�rtice v cumple que
		 * inDegree(v)=outDegree(v), excepto dos v�rtices v1 y v2 para los que se tiene
		 * que inDegree(v1)=outDegree(v1)-1 y inDegree(v2)=outDegree(v2)+1.
		 * 
		 * Complejidad : O(V+E)
		 * 
		 */
		int[] euler(int[][] lAdy, int v) { // Lo encuentra si existe
			List<Integer> r = new ArrayList<Integer>();
			euler(lAdy, new int[lAdy.length], v, r);
			int t = r.size(), a[] = new int[t], i;
			for (i = 0; i < t; i++)
				a[i] = r.get(t - 1 - i);
			return a;
		}

		void euler(int[][] lAdy, int[] tams, int v, List<Integer> r) {
			while (tams[v] < lAdy[v].length)
				euler(lAdy, tams, lAdy[v][tams[v]++], r);
			r.add(v);
		}
	}

	class CaminoEulerianoGrafosNoDirigidos {
		/*
		 * Camino Euleriano : Camino en el grafo que pasa solo una vez por cada arista.
		 * Circuito o ciclo euleriano : circuito cerrado en el grafo que contiene a cada
		 * arista una solo vez en su recorrrido
		 * 
		 * Un grafo no dirigido G= V,E tiene un ciclo Euleriano si es conexo y todo
		 * v�rtice v tiene grado par. Un grafo no dirigido G= V,E tiene un camino
		 * Euleriano si es conexo y todo v�rtice v tiene grado par, excepto dos v�rtices
		 * que tienen grado impar.
		 * 
		 * Complejidad : O(V+E)
		 * 
		 */
		int[] eulerND(int[][] lAdy, int v) { // Lo encuentra si existe
			int n = lAdy.length;
			List<Integer> r = new ArrayList<Integer>();
			eulerND(lAdy, new int[n], new boolean[n][n], v, r);
			int t = r.size(), a[] = new int[t], i;
			for (i = 0; i < t; i++)
				a[i] = r.get(t - 1 - i);
			return a;
		}

		void eulerND(int[][] lAdy, int[] tams, boolean[][] vis, int v, List<Integer> r) {
			for (int x; tams[v] < lAdy[v].length;)
				if (!vis[v][x = lAdy[v][tams[v]++]]) {
					vis[v][x] = vis[x][v] = true;
					eulerND(lAdy, tams, vis, x, r);
				}
			r.add(v);
		}
	}

	class CicloHamiltoniano {
		/*
		 * Camino Hamiltoniano : camino en un grafo que pasa por todos los nodos Ciclo
		 * hamiltoniano : camino en un grafo que pasa por todos ls nodos y aparte el
		 * nodo inicial es igual al nodo final
		 * 
		 * Complejidad : O(E^V)
		 * 
		 */
		int[] hamilton(int[][] lAdy) {
			int n = lAdy.length, cam[] = new int[n + 1];
			if (!hamilton(lAdy, new boolean[n], cam, 0, 0))
				return null;
			return cam;
		}

		boolean hamilton(int[][] lAdy, boolean[] vis, int[] cam, int t, int v) {
			if (vis[v] && t < cam.length - 1)
				return false;
			cam[t++] = v;
			if (t == cam.length)
				return v == cam[0];
			vis[v] = true;
			for (int w : lAdy[v])
				if (hamilton(lAdy, vis, cam, t, w))
					return true;
			vis[v] = false;
			return false;
		}
	}

	class tarjan2 {
		public int nodos, aristas, preCount;
		public int[] low;
		public boolean[] visited;
		public ArrayList<Integer>[] ady;
		public ArrayList<ArrayList<Integer>> sccComp;
		public Stack<Integer> pila;

		public int tarjan() {
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

		public void dfs(int u) {
			visited[u] = true;

			for (int v : ady[u]) {
				if (!visited[v]) {
					dfs(v);
				}
			}
			pila.push(u);
		}

		public void dfs2(int u) {
			visited[u] = true;
			for (int v : ady[u]) {
				if (!visited[v]) {
					dfs2(v);
				}
			}
		}

	}
}
