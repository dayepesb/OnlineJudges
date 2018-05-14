package ProblemsIn_Java.Notebook_Camus.Mathematics;

public long kadane2D(long[][] mat) { // mayor suma en una matriz
	int m = mat.length, n = m == 0 ? 0 : mat[0].length;
	long r = Long.MIN_VALUE, sumas[][] = new long[m][n], arr[] = new long[n];
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			sumas[i][j] = mat[i][j] + (i > 0 ? sumas[i - 1][j] : 0);
	for (int i1 = 0; i1 < m; i1++)
		for (int i2 = i1; i2 < m; i2++) {
			for (int j = 0; j < n; j++)
				arr[j] = sumas[i2][j] - (i1 > 0 ? sumas[i1 - 1][j] : 0);
			r = Math.max(r, kadane(arr));
		}
	return r;
}
