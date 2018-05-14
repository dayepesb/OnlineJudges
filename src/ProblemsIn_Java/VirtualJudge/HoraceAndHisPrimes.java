package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 1-08-2017
 * @time 0.980 ms
 */
public class HoraceAndHisPrimes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Criba((int) 1e6 + 1);
		int[] arr = new int[(int) 1e6 + 1];
		int[] sol = new int[(int) 1e6 + 1];
		for (int i = 0; i < primos.length; i++) {
			int x = (int) primos[i];
			while (x < arr.length) {
				arr[x] += primos[i];
				x += primos[i];
			}
			arr[(int) primos[i]] = 1;
		}
		for (int i = 2; i < arr.length; i++)
			sol[i] = sol[arr[i]] + 1;
		int[][] kad = new int[13][arr.length];
		for (int i = 1; i < 13; i++) {
			for (int j = 2; j < kad[0].length; j++) {
				if (sol[j] == i) {
					kad[i][j] = kad[i][j - 1] + 1;
				} else
					kad[i][j] = kad[i][j - 1];
			}
		}
		for (String line; (line = in.readLine()) != null;) {
			int casos = Integer.parseInt(line.trim());
			for (int caso = 0; caso < casos; caso++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (x >= 13)
					out.println(0);
				else {
					out.println(kad[x][b] - kad[x][a - 1]);
				}
			}
		}
		out.close();
	}

	static boolean[] b;
	static long[] primos;

	static long[] Criba(int M) {
		b = new boolean[M];
		int i, j, k, c = 2;
		for (i = 2; (k = i * i) < M; i++) {
			if (!b[i]) {
				for (j = k; j < M; j += i) {
					if (!b[j]) {
						b[j] = true;
						c++;
					}
				}
			}
		}
		primos = new long[M - c];
		for (i = 2, j = 0; i < M; i++) {
			if (!b[i])
				primos[j++] = i;
		}
		return primos;
	}

}
