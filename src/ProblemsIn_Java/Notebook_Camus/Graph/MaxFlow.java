package ProblemsIn_Java.Notebook_Camus.Graph;

class MaxFlow {
	int MAXN = 550; int n, S, T;
	int INF = Integer.MAX_VALUE >> 1;
	arista[][] red = new arista[n][n];
	public void agregarArista(int u, int v, double c) {
		red[u][v].c += c; // red[v][u].c+=c; si es no-dirigido 
	}
	int[] pre = new int[MAXN], dist = new int[MAXN];
	double cap[] = new double[MAXN];
	double bfs() {
		Arrays.fill(pre, -1); Arrays.fill(dist, INF);
		dist[S] = 0; cap[S] = INF;
		Queue<Integer> q = new ArrayDeque<>(); q.add(S);
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v = 0; v < red[u].length; v++) {
				if (red[u][v].cr() > 0 && dist[v] == INF) {
					dist[v] = dist[u] + 1; pre[v] = u;
					cap[v] = Math.min(cap[u], red[u][v].cr());
					q.add(v);
					if (v == T) return cap[v];
				} } } return 0.;
	}
	void augment(double cap) {
		for (int v = T; v != S; v = pre[v]) {
			int u = pre[v]; red[v][u].f = -(red[u][v].f += cap);
		} }
	double maxFlow() {
		double cap, res = 0;
		while ((cap = bfs()) > 0) {
			augment(cap); res += cap;
		} return res;
	}
}
class arista {
	double c, f;
	public arista(double c, double f) {
		this.c = c; this.f = f;
	}
	public double cr() { return c - f; } 
}
