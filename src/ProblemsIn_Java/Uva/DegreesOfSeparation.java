package ProblemsIn_Java.Uva;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DegreesOfSeparation {
	public static final int INF = 1000000;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int nodos = in.nextInt(), aristas = in.nextInt(), caso = 1;
		int mAdy[][];
		HashMap<String, Integer> ady = new HashMap<>();
		int index;
		while (nodos != 0 && aristas != 0) {
			mAdy = new int[nodos][nodos];
			ady = new HashMap<>();
			index = 0;
			for (int i = 0; i < mAdy.length; i++) {
				for (int j = 0; j < mAdy.length; j++) {
					mAdy[i][j] = INF;
					mAdy[i][i] = 0;
				}
			}
			for (int i = 0; i < aristas;) {
				String u = in.next(), v = in.next();
				if (!ady.containsKey(u)) {
					ady.put(u, index);
					index++;
				}
				if (!ady.containsKey(v)) {
					ady.put(v, index);
					index++;
				}
				mAdy[ady.get(u)][ady.get(v)] = mAdy[ady.get(v)][ady.get(u)] = 1;
				++i;
			}

			for (int k = 0; k < mAdy.length; k++) {
				for (int i = 0; i < mAdy.length; i++) {
					for (int j = 0; j < mAdy.length; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}
			int res = 0;
			for (int i = 0; i < mAdy.length; i++) {
				for (int j = 0; j < mAdy.length; j++) {
					res = Math.max(res, mAdy[i][j]);
				}
			}
			out.printf("Network %d: %s%n%n", caso, res == INF ? "DISCONNECTED" : res);
			nodos = in.nextInt();
			aristas = in.nextInt();
			caso++;
		}

		out.close();
		in.close();
	}

}