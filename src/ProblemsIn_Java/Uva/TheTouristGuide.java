package ProblemsIn_Java.Uva;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TheTouristGuide {

	public static long mAdy[][];

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int aristas, nodos, mAdy[][], source, destination, turist;
		final int INF = Integer.MIN_VALUE;

		for (int caso = 1;; caso++) {
			nodos = in.nextInt();
			aristas = in.nextInt();

			if (nodos == 0 && aristas == 0)
				break;
			mAdy = new int[nodos][nodos];
			for (int i = 0; i < mAdy.length; i++) {
				for (int j = 0; j < mAdy.length; j++) {
					mAdy[i][j] = INF;
				}
			}

			for (int i = 0; i < aristas; i++) {
				int nodo1 = in.nextInt() - 1;
				int nodo2 = in.nextInt() - 1;
				int peso = in.nextInt();
				mAdy[nodo1][nodo2] = mAdy[nodo2][nodo1] = peso;
			}

			source = in.nextInt() - 1;
			destination = in.nextInt() - 1;
			turist = in.nextInt();

			for (int k = 0; k < nodos; k++) {
				for (int i = 0; i < nodos; i++) {
					if (mAdy[i][k] != INF) {
						for (int j = 0; j < nodos; j++) {
							if (mAdy[k][j] != INF && i != j) {
								mAdy[i][j] = Math.max(mAdy[i][j], Math.min(mAdy[i][k], mAdy[k][j]));
							}
						}
					}
				}
			}

			int min = (int) Math.ceil(turist * 1.00 / (mAdy[source][destination] - 1));

			out.println("Scenario #" + caso);
			out.println("Minimum Number of Trips = " + min);
			out.println();
		}

		out.close();
		in.close();
	}
}
