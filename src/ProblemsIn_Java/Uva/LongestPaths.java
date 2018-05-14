package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestPaths {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n, start, min = Integer.MIN_VALUE, caso = 0;
		int mAdy[][];
		while (true) {
			n = Integer.parseInt(in.readLine().trim());

			if (n == 0)
				break;

			start = Integer.parseInt(in.readLine().trim());

			mAdy = new int[n + 1][n + 1];

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					mAdy[i][j] = min;
				}
				mAdy[i][i] = 0;
			}

			while (true) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				if (x == y && y == 0)
					break;
				mAdy[x][y] = 1;
			}
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					if (mAdy[i][k] != min) {
						for (int j = 1; j <= n; j++) {
							if (mAdy[k][j] != min)
								mAdy[i][j] = Math.max(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
						}
					}
				}
			}

			int length = 0;
			int finishesAt = 0;

			for (int i = 1; i <= n; i++) {
				if (length < mAdy[start][i]) {
					length = mAdy[start][i];
					finishesAt = i;
				}
			}

			out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n", ++caso, start, length,
					finishesAt);

		}

		out.close();
		in.close();
	}
}
