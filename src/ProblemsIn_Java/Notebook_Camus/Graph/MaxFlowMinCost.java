package ProblemsIn_Java.Notebook_Camus.Graph;

public class MaxFlowMinCost {
	static int INF = 1 << 29;
	static class arista {
		int u, v, cap, cost, flow;
		public arista(int u, int v, int cap, int cost, int flow) {
			this.u = u; this.v = v; this.cap = cap;
			this.cost = cost; this.flow = flow; }
		int rem() { return cap - flow; } }
	int MAXN;
	public MaxFlowMinCost(int n) {
		adj = new ArrayList[n];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new ArrayList<>();
		e = new ArrayList<>(); MAXN = n; }
	ArrayList<Integer>[] adj; ArrayList<arista> e;
	void agregarArista(int u, int v, int cap, int cost) {
		adj[u].add(e.size()); e.add(new arista(u, v, cap, cost, 0));
		adj[v].add(e.size()); e.add(new arista(v, u, 0, -cost, 0));
	}
	int[] dist, pre, cap;
	int[] flow(int s, int t) {
		dist = new int[MAXN]; pre = new int[MAXN];
		cap = new int[MAXN]; int[] res = { 0, 0 };
		while (true) {
			Arrays.fill(dist, INF);dist[s] = 0;
			Arrays.fill(pre, -1);Arrays.fill(cap, 0);
			cap[s] = INF;
			while (true) {
				boolean change = false;
				for (int u = 0; u < MAXN; u++) {
					for (int i = 0; i < adj[u].size(); i++) {
						arista E = e.get(adj[u].get(i));
						if (E.rem() > 0 && dist[E.v] > dist[u] + E.cost) {
							change = true;
							dist[E.v] = dist[u] + E.cost;
							pre[E.v] = adj[u].get(i);
							cap[E.v] = Math.min(cap[u], E.rem());
						}
					}
				}
				if (!change)
					break;
			}
			if (pre[t] == -1)
				break;
			res[0] += cap[t]; res[1] += cap[t] * dist[t];
			for (int v = t; v != s; v = e.get(pre[v]).u) {
				e.get(pre[v]).flow += cap[t];
				e.get(pre[v] ^ 1).flow -= cap[t];
			}
		}
		return res;
	}
}
