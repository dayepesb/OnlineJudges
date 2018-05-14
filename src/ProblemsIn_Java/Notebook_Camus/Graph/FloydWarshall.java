package ProblemsIn_Java.Notebook_Camus.Graph;

public void FloydWarshallWithPathReconstruction(int mAdy[][], int start, int end) { // O(V^3)
	int n = mAdy.length; int road[][] = new int[n][n];
	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			if (mAdy[i][k] != Integer.MAX_VALUE / 2) {
				for (int j = 0; j < n; j++) {
					if (mAdy[k][j] != Integer.MAX_VALUE / 2 && mAdy[i][k] + mAdy[k][j] < mAdy[i][j]) {
						mAdy[i][j] = mAdy[i][k] + mAdy[k][j];
						road[i][j] = road[i][k];
					} } } } }
	String path = reConstrucPath(road, start, end); }
public String reConstrucPath(int road[][], int start, int end) {
	StringBuilder sb = new StringBuilder(); sb.append(start);
	do {
		start = road[start][end]; sb.append(start + " ");
	} while (start != end);
	return sb.toString().trim(); }