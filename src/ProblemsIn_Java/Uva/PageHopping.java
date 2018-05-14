package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PageHopping {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int nodo1, nodo2, nodos, max = 65000;
		int[][] mAdy;
		float sum;

		st = new StringTokenizer(in.readLine());

		Loop: for (int caso = 1;; caso++) {
			nodo1 = Integer.parseInt(st.nextToken());
			nodo2 = Integer.parseInt(st.nextToken());

			if (nodo1 == nodo2 && nodo2 == 0) {
				break Loop;
			}

			mAdy = new int[101][101];
			for (int j = 0; j < mAdy.length; j++) {
				for (int k = 0; k < mAdy.length; k++) {
					mAdy[j][k] = max;
				}
			}

			do {
				mAdy[nodo1][nodo2] = 1;
				mAdy[nodo1][nodo1] = mAdy[nodo2][nodo2] = 0;
				nodo1 = Integer.parseInt(st.nextToken());
				nodo2 = Integer.parseInt(st.nextToken());
			} while (nodo1 > 0 && nodo2 > 0);

			mAdy = floyd_Warshall(mAdy);

			sum = 0;
			nodos = 0;
			for (int i = 1; i < 101; i++) {
				for (int j = 1; j < 101; j++) {
					if (i == j && mAdy[i][i] == 0)
						nodos++;
					else if (i != j && mAdy[i][j] != max) {
						sum += mAdy[i][j];
					}
				}
			}
			out.printf("Case %d: average length between pages = %.3f clicks%n", caso, sum / (nodos * (nodos - 1)));
			st = new StringTokenizer(in.readLine());
		}

		out.close();
		in.close();
	}

	public static int[][] floyd_Warshall(int mAdy[][]) {

		for (int k = 1; k < 101; k++)
			for (int i = 1; i < 101; i++)
				for (int j = 1; j < 101; j++) {
					if (j == i) {
						continue;
					}
					if (mAdy[i][j] > mAdy[i][k] + mAdy[k][j]) {
						mAdy[i][j] = mAdy[i][k] + mAdy[k][j];
					}
				}

		return mAdy;
	}

}
