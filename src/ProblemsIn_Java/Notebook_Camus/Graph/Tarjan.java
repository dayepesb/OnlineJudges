package ProblemsIn_Java.Notebook_Camus.Graph;

class tarjan{// O(V+E)
	public int nodos, aristas, preCount;
	public int[] low; public boolean[] visited;
	public ArrayList<Integer>[] ady;
	public ArrayList<ArrayList<Integer>> sccComp;
	public Stack<Integer> pila;
	public int tarjan() {
		pila = new Stack<Integer>();
		for (int i = nodos - 1; i >= 0; --i) {
			if (!visited[i]) { dfs(i); } }
		visited = new boolean[nodos];
		int numComp = 0;
		while (!pila.isEmpty()) {
			int x = pila.pop();
			if (!visited[x]) { ++numComp; dfs2(x);
			} }
		return numComp; }
		public void dfs(int u) {
			visited[u] = true;
			for (int v : ady[u]) {
				if (!visited[v]) { dfs(v); } }
			pila.push(u); }
		public void dfs2(int u) {
			visited[u] = true;
			for (int v : ady[u]) {
				if (!visited[v]) { dfs2(v); }
			} } }
