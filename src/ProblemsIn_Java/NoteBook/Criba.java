package ProblemsIn_Java.NoteBook;

import java.util.ArrayList;

public class Criba {

	public static void Criba_1() {
		double s = System.currentTimeMillis();
		int max = 10000000;
		boolean b[] = new boolean[max];
		b[2] = true; // 2 es primo
		for (int i = 3; i < max; i += 2) {
			b[i] = true;
		}
		int I = (int) Math.sqrt(max) + 1;
		for (int i = 3; i <= I; i += 2) {
			if (b[i] == true) {
				for (int j = i * i, bi = 2 * i; j < max; j += bi) {
					b[j] = false;
				}
			}
		}
		ArrayList<Integer> primos = new ArrayList<>();
		for (int i = 3; i < b.length; i++) {
			if (b[i]) {
				primos.add(i);
			}
		}
		System.out.println(primos.size());
		double f = System.currentTimeMillis();
		System.out.println((f - s) / 1000 + "  Segundos");
	}

	public static void Criba_2(int M) {

		boolean b[] = new boolean[M];
		int i, j, k, c = 2;
		for (i = 2; (k = i * i) < M; i++)
			if (!b[i])
				for (j = k; j < M; j += i)
					if (!b[j]) {
						b[j] = true;
						c++;
					}
		long r[] = new long[M - c];
		for (i = 2, j = 0; i < M; i++)
			if (!b[i])
				r[j++] = i;
	}

	public static void Criba_Segmentada(long x1, long x2, long[] primos) { 
		// r es la criba
		int T = (int) (x2 - x1 + 1), c = 0, i, n = primos.length;
		long R = (long) (Math.sqrt(x2) + 1 + 1e-5), p, q;
		boolean b[] = new boolean[T];
		for (i = 0; i < n && (p = primos[i]) <= R; i++)
			for (q = Math.max((x1 + p - 1) / p, 2) * p; q <= x2; q += p)
				if (!b[(int) (q - x1)]) {
					b[(int) (q - x1)] = true;
					c++;
				}
		for (p = x1; p <= R; p++)
			if (!b[(int) (p - x1)])
				for (q = p * p; q <= x2; q += p)
					if (!b[(int) (q - x1)]) {
						b[(int) (q - x1)] = true;
						c++;
					}
		long r[] = new long[T - c];
		for (p = x1, i = 0; p <= x2; p++)
			if (!b[(int) (p - x1)])
				r[i++] = p;
	}
}
