package ProblemsIn_Java.Notebook_Camus.Mathematics;

public long[][] productoMatriz(long[][] s, long[][] l, int modulo) {
	long r[][] = new long[s.length][l.length];
	for (int i = 0; i < r.length; i++) {
		for (int j = 0; j < r.length; j++) {
			for (int k = 0; k < r.length; k++) {
				r[i][j] += ((s[i][k] * l[k][j]) & modulo);
			}
		}
	}
	return r;
}