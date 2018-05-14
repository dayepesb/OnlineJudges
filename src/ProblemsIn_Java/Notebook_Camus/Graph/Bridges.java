package ProblemsIn_Java.Notebook_Camus.Graph;

class Bridges { // O(V+E)
	int cnt, ord[], low[];
	ArrayList<Integer>[] ady;
	ArrayList<Edge> bridges() {
		int n = ady.length; ord = new int[n];
		low = new int[n];
		ArrayList<Edge> res = new ArrayList<>();
		for (int v = 0; v < n; v++)
			if (ord[v] == 0) { cnt = 1;
				bridges(v, v, res); }
		// se organiza los puentes segun el numero de menor a mayor con el
		// comparator
		Collections.sort(res, new Comp());
		return res; }
	void bridges(int v, int w, ArrayList<Edge> res) {
		low[w] = ord[w] = cnt++;
		for (int t : ady[w])
			if (ord[t] == 0) { bridges(w, t, res);
				low[w] = Math.min(low[w], low[t]);
				if (low[t] == ord[t]) {
					Edge e = new Edge(w, t); res.add(e);
				}
			} else if (t != v) low[w] = Math.min(low[w], ord[t]);
	}
	class Comp implements Comparator<Edge> {
		public int compare(Edge x, Edge y) {
			if (x.a != y.a) return x.a - y.a;
			else return x.b - y.b; } }
	class Edge {
		public int a, b;
		public Edge(int a, int b) {
			this.a = a; this.b = b; } } }