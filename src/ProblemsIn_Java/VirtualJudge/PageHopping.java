package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 09-01-2018
 * @time 0.805 ms
 */
public class PageHopping {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		long[][] mAdy;
		String line;
		int a, b, tc;
		double nodos, sum;
		tc = 1;
		while (true) {
			line = in.readLine().trim();
			st = new StringTokenizer(line);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a + b == 0)
				break;
			mAdy = new long[101][101];
			for (long[] ls : mAdy)
				Arrays.fill(ls, Integer.MAX_VALUE / 2);
			do {
				mAdy[a][b] = 1;
				mAdy[a][a] = mAdy[b][b] = 0;
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
			} while (a + b != 0);
			for (int k = 1; k < mAdy.length; k++) {
				for (int i = 1; i < mAdy.length; i++) {
					for (int j = 1; j < mAdy.length; j++) {
						if (j != i) {
							mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
						}
					}
				}
			}
			nodos = 0;
			sum = 0;
			for (int i = 1; i < mAdy.length; i++) {
				for (int j = 1; j < mAdy.length; j++) {
					if (i == j && mAdy[i][j] == 0)
						nodos++;
					else if (mAdy[i][j] != Integer.MAX_VALUE / 2)
						sum += mAdy[i][j];
				}
			}
			out.printf("Case %d: average length between pages = %.3f clicks%n", tc++, sum / (nodos * (nodos - 1)));
		}

		in.close();
		out.close();
	}
}
