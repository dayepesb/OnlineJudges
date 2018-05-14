package ProblemsIn_Java.Notebook_Camus.Graph;

public class TopoligicalSort{ // O(V+E)
	int[] topologicalSort(ArrayList<Integer> lAdy[]) {
		// Retorna null si no recibe un DAG
		int n = lAdy.length, state[] = new int[n];
		List<Integer> r = new ArrayList<Integer>();
		for (int v = 0; v < n; v++)
			if (state[v] == 0 && !dfsTS(lAdy, v, state, r)) return null;
		int t = r.size(), a[] = new int[t], i;
		for (i = 0; i < t; i++) a[i] = r.get(t - 1 - i);
		return a;
	}
	boolean dfsTS(ArrayList<Integer> lAdy[], int v, int[] state, List<Integer> r) {
		state[v] = 1;
		for (int w : lAdy[v])
			if (state[w] == 1 || (state[w] == 0 && !dfsTS(lAdy, w, state, r)))
				return false;
		state[v] = 2; r.add(v); return true; }
}
