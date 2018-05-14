package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 07-01-2018
 * @time 0.000 ms
 */
public class FindingSeats {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		long dp[][];
		long cine[][];
		while (true) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (r + c == 0)
				break;
			cine = new long[r][c];
			for (int i = 0; i < r; i++) {
				String line = in.readLine().trim();
				for (int j = 0; j < c; j++) {
					cine[i][j] = (line.charAt(j) == '.' ? 1 : 0);
				}
			}
			dp = new long[r + 1][c + 1];
			for (int i = 0; i < r; ++i)
				for (int j = 0; j < c; ++j)
					dp[i + 1][j + 1] = cine[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];
			int ans = Integer.MAX_VALUE;
			for (int c1 = 0; c1 < c; ++c1) {
				for (int c2 = c1; c2 < c; ++c2) {
					for (int r1 = 0, r2 = 0; r2 < r; ++r2) {
						while (r1 < r2
								&& dp[r2 + 1][c2 + 1] - dp[r1 + 1][c2 + 1] - dp[r2 + 1][c1] + dp[r1 + 1][c1] >= k)
							++r1;

						if (dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1] >= k)
							ans = Math.min(ans, (c2 - c1 + 1) * (r2 - r1 + 1));
					}
				}
			}
			out.println(ans);
		}
		in.close();
		out.close();
	}
}
