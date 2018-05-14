package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HackersCrackdown {

	static int n;
	static int[] solve, c, a;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int iCase = 0;
		while (true) {
			n = Integer.parseInt(in.readLine().trim());
			if (n == 0)
				break;

			a = new int[n];
			c = new int[(int) Math.pow(2, n)];
			solve = new int[(int) Math.pow(2, n)];
			Arrays.fill(solve, -1);

			for (int i = 0; i < n; i++) {
				a[i] = (int) Math.pow(2, i);
				StringTokenizer st = new StringTokenizer(in.readLine());
				st.nextToken();
				while (st.hasMoreTokens()) {
					a[i] += Math.pow(2, Integer.parseInt(st.nextToken()));
				}
			}

			int p = (int) Math.pow(2, n);

			for (int i = 0; i < p; i++) {
				for (int j = 0; j < n; j++) {
					if (((1 << j) & i) == 0) {
						c[(1 << j) ^ i] = c[i] + a[j];
					}
				}
			}

			out.printf("Case %d: %d\n", ++iCase, f(p - 1));
		}
		in.close();
		out.close();
	}

	private static int f(int i) {
		if (solve[i] == -1) {
			solve[i] = 0;
			for (int j = i; j != 0; j = i & (j - 1)) {
				if (c[j] == ((int) Math.pow(2, n)) - 1) {
					solve[i] = Math.max(solve[i], f(i ^ j) + 1);
				}
			}
		}
		return solve[i];
	}

}