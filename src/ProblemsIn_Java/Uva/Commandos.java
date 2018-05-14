package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class Commandos {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine().trim());
		int n, r, s, d;
		int mAdy[][];

		for (int c = 1; c <= casos; c++) {
			out.printf("Case %d: ", c);

			n = Integer.parseInt(in.readLine().trim());
			mAdy = new int[n][n];
			r = Integer.parseInt(in.readLine().trim());

			for (int i = 0; i < mAdy.length; i++) {
				Arrays.fill(mAdy[i], Integer.MAX_VALUE / 3);
				mAdy[i][i]=0;
			}
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(in.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				mAdy[n1][n2] = mAdy[n2][n1] = 1;
			}

			for (int k = 0; k < mAdy.length; k++) {
				for (int i = 0; i < mAdy.length; i++) {
					for (int j = 0; j < mAdy.length; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}

			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			int resMin = 0;

			for (int i = 0; i < mAdy.length; i++) {
				if(mAdy[s][i]!=Integer.MAX_VALUE/3 && mAdy[i][d]!=Integer.MAX_VALUE/3){
					resMin = Math.max(resMin, mAdy[s][i]+mAdy[i][d]);
				}
			}

			out.println(resMin);
		}

		in.close();
		out.close();
	}
}
