package ProblemsIn_Java.Notebook_Camus.Graph;

public double TravelingSalesmanProblem(double[][] mAdy, int v) { // O(V^2+2^E)
	int n = mAdy.length, t = 1 << n;
	double mem[][] = new double[t][n];
	for (double[] arr : mem) {Arrays.fill(arr, -1d); }
	return TravelingSalesmanProblem(mAdy, n, v, v, 1 << v, mem);
}
public double TravelingSalesmanProblem(double[][] mAdy, int n, int v1, int v2, int visitados, double[][] mem) {
	if (mem[visitados][v1] >= 0d) { return mem[visitados][v1]; }
	if (visitados == (1 << n) - 1) {
		return mem[visitados][v1] = mAdy[v1][v2]; }
	double min = Double.POSITIVE_INFINITY, d;
	for (int e = visitados, j = 0; j < n; j++, e >>>= 1) {
		if ((e & 1) == 0 && (d = mAdy[v1][j]) < min) {
			min = Math.min(min, d + TravelingSalesmanProblem(mAdy, n, j, v2, visitados | (1 << j), mem));
		}	}
	return mem[visitados][v1] = min;}