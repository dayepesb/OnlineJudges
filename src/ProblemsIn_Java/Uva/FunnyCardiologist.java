package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 11-09-2017
 * @time 1.000 ms
 */

// dp
public class FunnyCardiologist {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int x[], y[];
		double dp[][];
		int n, m;
		String line;
		StringTokenizer st;
		while ((line = in.readLine()) != null) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			x = new int[n];
			y = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			dp = new double[n+1][n+1];
			for (int i = 0; i < n; i++) {
				dp[i][1] = i == 0 ? 0 : 1e30;
				for (int j = 2; j <= n - m; j++)
					dp[i][j] = 1e30;
				for (int k = 0; k < i; k++) {
					double dist = Math.hypot(x[i] - x[k], y[i] - y[k]);
					for (int j = 2; j <= n - m; j++)
						dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + dist);
				}
			}
			out.printf("%.3f%n", dp[n - 1][n - m]);
		}

		out.close();
		in.close();
	}
}
