package ProblemsIn_Java.Uva;

import java.io.*;

public class HowDoYouAdd {

	static int N, K;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int MAXN = 105;
		int MAXK = 105;
		memo = new int[MAXN][MAXK];

		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			K = Integer.parseInt(parts[1]);
			if (N == 0 && K == 0)
				break;

			for (int i = 0; i < MAXN; ++i)
				for (int j = 0; j < MAXK; ++j)
					memo[i][j] = -1;

			out.println(solve(0, N));
		}

		in.close();
		out.close();
	}

	public static int solve(int i, int rem) {
		rem %= 1000000;
		if (rem < 0)
			return 0;
		if (i == K && rem == 0)
			return 1;
		if (i == K && rem != 0)
			return 0;

		if (memo[i][rem] != -1)
			return memo[i][rem];

		int ans = 0;
		for (int j = 0; j <= rem; ++j)
			ans += solve(i + 1, rem - j) % 1000000;

		return memo[i][rem] = ans % 1000000;
	}

}