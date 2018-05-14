package ProblemsIn_Java.Notebook_Camus.Graph;

class ArticulationPoints { // O(E+V)
	int cnt, ord[], low[];
	ArrayList<Integer>[] ady;
	ArrayList<Integer> articulationPoints() {
		int n = ady.length; ord = new int[n];
		low = new int[n];
		ArrayList<Integer> res = new ArrayList<>();
		for (int v = 0; v < n; v++)
			if (ord[v] == 0) { cnt = 1;
				articulationPoints(v, v, res); }
		return res; }
	void articulationPoints(int v, int w, ArrayList<Integer> res) {
		low[w] = ord[w] = cnt++;
		for (int t : ady[w]) {
			if (ord[t] == 0) { articulationPoints(w, t, res);
				low[w] = Math.min(low[w], low[t]);
				if ((ord[w] == 1 && ord[t] != 2) || (ord[w] != 1 && low[t] >= ord[w]))
					res.add(w);
			} else if (t != v) low[w] = Math.min(low[w], ord[t]);
		} } }
