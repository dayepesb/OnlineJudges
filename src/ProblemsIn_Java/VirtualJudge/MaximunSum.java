package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.140 ms
 */
public class MaximunSum {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		long[][] mat;
		for (String line; (line = in.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			mat = new long[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int t = 0;
				while (st.hasMoreTokens()) {
					mat[i][t++] = Integer.parseInt(st.nextToken());
				}
			}
			out.println(kadane2D(mat));
		}

		in.close();
		out.close();
	}

	static long kadane2D(long[][] mat) {
		int m = mat.length, n = m == 0 ? 0 : mat[0].length;
		long r = Long.MIN_VALUE, sumas[][] = new long[m][n], arr[] = new long[n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				sumas[i][j] = mat[i][j] + (i > 0 ? sumas[i - 1][j] : 0);
		for (int i1 = 0; i1 < m; i1++)
			for (int i2 = i1; i2 < m; i2++) {
				for (int j = 0; j < n; j++)
					arr[j] = sumas[i2][j] - (i1 > 0 ? sumas[i1 - 1][j] : 0);
				r = Math.max(r, kadane(arr));
			}
		return r;
	}

	static long kadane(long[] arr) {
		long act = 0, r = Long.MIN_VALUE;
		for (long v : arr) {
			act += v;
			if (act > r)
				r = act;
			if (act < 0)
				act = 0;
		}
		return r;
	}
}
