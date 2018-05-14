package ProblemsIn_Java.Notebook_Camus.Mathematics;

public void Criba_2(int M) {
	boolean b[] = new boolean[M];
	int i, j, k, c = 2;
	for (i = 2; (k = i * i) < M; i++)
		if (!b[i])
			for (j = k; j < M; j += i)
				if (!b[j]) {
					b[j] = true; c++;
				}
	long r[] = new long[M - c];
	for (i = 2, j = 0; i < M; i++)
		if (!b[i]) r[j++] = i;
}
