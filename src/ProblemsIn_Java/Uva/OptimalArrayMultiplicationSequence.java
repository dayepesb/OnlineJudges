package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OptimalArrayMultiplicationSequence {
	static int d[], dp[][], prev[][];
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n, caso = 1;
		while (true) {
			n = Integer.parseInt(in.readLine().trim());
			if (n == 0)
				break;
			d = new int[n + 1];
			dp = new int[n + 1][n + 1];
			prev = new int[n + 1][n + 1];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				d[i] = a;
				d[i + 1] = b;
			}

			for (int i = 0; i <= n; Arrays.fill(dp[i], Integer.MAX_VALUE), i++)
				;
			parentizacion(1, n);
			out.printf("Case %d: ", caso++);
			construir(1, n);
			out.printf("\n");

		}

		out.close();
		in.close();
	}

	static void construir(int a, int b) {
		if (a == b)
			out.printf("A%d", a);
		else {
			out.printf("(");
			construir(a, prev[a][b]);
			out.printf(" x ");
			construir(prev[a][b] + 1, b);
			out.printf(")");
		}
	}

	static int parentizacion(int a, int b) {
		int ret = dp[a][b];
		if (ret != Integer.MAX_VALUE)
			return ret;
		if (a == b)
			return ret = 0;
		for (int k = a; k < b; k++) {
			int cost = d[a - 1] * d[k] * d[b] + parentizacion(a, k) + parentizacion(k + 1, b);
			if (ret == Integer.MAX_VALUE || cost < ret) {
				ret = cost;
				prev[a][b] = k;
			}
		}
		return ret;
	}
}
