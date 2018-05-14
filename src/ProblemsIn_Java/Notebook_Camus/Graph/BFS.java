package ProblemsIn_Java.Notebook_Camus.Graph;

class BFS { // O(V+E)
	public void Bfs(boolean mAdy[][], int origen) {
		boolean visit[] = new boolean[10];
		Queue<Integer> cola = new LinkedList<>();
		cola.add(origen); visit[origen] = true;
		while (!cola.isEmpty()) {int v = cola.poll();
			for (int i = 0; i < mAdy[v].length; i++) {
				if (mAdy[v][i] && (!visit[i])) { visit[i] = true; cola.add(i);}
			} } }
}
