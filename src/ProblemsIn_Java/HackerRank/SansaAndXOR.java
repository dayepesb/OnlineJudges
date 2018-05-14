package ProblemsIn_Java.HackerRank;

import java.io.*;
import java.util.StringTokenizer;

public class SansaAndXOR {
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int c = Integer.parseInt(in.readLine().trim()); c > 0; --c) {
			int n = Integer.parseInt(in.readLine());
			int[] array = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; ++i) {
				array[i] = Integer.parseInt(st.nextToken());
			}

			sb.append(solve(array, n)).append("\n");
		}
		System.out.print(sb);
	}

	static int solve(int[] A, int N) {
		int xor = 0;
		if ((N & 1) == 1) {
			for (int i = 0; i < N; i += 2) {
				xor ^= A[i];
			}
		}
		return xor;
	}
}