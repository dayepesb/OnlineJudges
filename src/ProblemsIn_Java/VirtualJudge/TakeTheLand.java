package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 29-07-2017
 */
public class TakeTheLand {

	static final int _INF = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, m;
		long A[][];
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			A = new long[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < m; j++) {
					A[i][j] = Integer.parseInt(st.nextToken()) == 0 ? 1 : _INF;
					if (i > 0)
						A[i][j] += A[i - 1][j];
					if (j > 0)
						A[i][j] += A[i][j - 1];
					if (i > 0 && j > 0)
						A[i][j] -= A[i - 1][j - 1];
				}
			}
			long max = Long.MIN_VALUE / 2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = i; k < n; k++) {
						for (int l = j; l < m; l++) {
							long b = A[k][l];
							if (i > 0)
								b -= A[i - 1][l];
							if (j > 0)
								b -= A[k][j - 1];
							if (i > 0 && j > 0)
								b += A[i - 1][j - 1];
							max = Math.max(b, max);
						}
					}
				}
			}
			out.println(Math.max(max, 0));
		}

		in.close();
		out.close();
	}
}
