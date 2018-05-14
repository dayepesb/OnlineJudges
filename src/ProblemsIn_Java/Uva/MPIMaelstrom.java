package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class MPIMaelstrom {

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int mAdy[][];
		int nodes;
		while (in.hasNext()) {
			nodes = in.nextInt();
			mAdy = new int[nodes][nodes];
			for (int i = 0; i < nodes; i++) {
				Arrays.fill(mAdy[i], INF);
				mAdy[i][i] = 0;
			}
			for (int i = 1; i < nodes; i++) {
				for (int j = 0; j < i; j++) {
					String n = in.next();
					mAdy[j][i] = mAdy[i][j] = (n.charAt(0) == 'x') ? INF : Integer.parseInt(n);
				}
			}

			for (int k = 0; k < nodes; k++) {
				for (int i = 0; i < nodes; i++) {
					for (int j = 0; j < mAdy.length; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}

			int min = 0;
			for (int i = 1; i < nodes; i++) {
				min = Math.max(min, mAdy[0][i]);
			}

			out.println(min);

		}

		in.close();
		out.close();
	}
}
