package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BarCodes {

	// PROGRAMACI�N DINAMICA

	static final int max = 50;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long[][][][] dp;

		for (String line; (line = in.readLine()) != null;) {
			int N, K, M;
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new long[2][N][K + 1][M + 1];
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < N; j++)
					for (int l = 0; l <= K; l++)
						Arrays.fill(dp[i][j][l], -1);
			long count = find(1, 1, 1, 1, dp, M);
			out.println(count);
		}
		out.close();
		in.close();
	}

	private static long find(int prev, int place, int count1, int count2, long[][][][] dp, int m) {
		if (count2 > m || count1 > dp[0][0].length - 1)
			return 0;
		if (place == dp[0].length && count1 == dp[0][0].length - 1)
			return 1;
		if (dp[0].length == place)
			return 0;
		if (dp[prev][place][count1][count2] != -1)
			return dp[prev][place][count1][count2];
		else {
			long count = 0;
			count += find(0, place + 1, (prev == 0) ? count1 : count1 + 1, (prev == 0) ? count2 + 1 : 1, dp, m);
			count += find(1, place + 1, (prev == 1) ? count1 : count1 + 1, (prev == 1) ? count2 + 1 : 1, dp, m);
			return dp[prev][place][count1][count2] = count;
		}
	}
}