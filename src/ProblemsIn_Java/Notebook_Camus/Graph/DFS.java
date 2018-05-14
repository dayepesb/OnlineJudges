package ProblemsIn_Java.Notebook_Camus.Graph;

class DFS { // O(V+E)
	public void DfsRecursivo(boolean mAdy[][], int origen, boolean visit[]) {
		visit[origen] = true;
		for (int i = 0; i < mAdy[origen].length; i++) {
			if (mAdy[origen][i]) { if (!visit[i]) {
					visit[i] = true; DfsRecursivo(mAdy, i, visit); } } } }
}