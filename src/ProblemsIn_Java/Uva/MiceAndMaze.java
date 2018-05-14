package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MiceAndMaze {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine()), nodos, target, tiempo, aristas;
		StringTokenizer st;

		for (int caso = 0; caso < casos; caso++) {
			in.readLine();

			nodos = Integer.parseInt(in.readLine());
			target = Integer.parseInt(in.readLine());
			tiempo = Integer.parseInt(in.readLine());
			aristas = Integer.parseInt(in.readLine());
			nodos++;

			int[][] mAdy = new int[nodos][nodos];
			for (int[] s : mAdy) {
				Arrays.fill(s, 10000);
			}

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				mAdy[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer
						.parseInt(st.nextToken());
			}

			//n dijkstra�s o floyd
			for (int k = 0; k < nodos; k++) {
				for (int i = 0; i < nodos; i++) {
					for (int j = 0; j < nodos; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}

			int count = 0;
			for (int i = 0; i < nodos; i++) {
				if (mAdy[i][target] <= tiempo || i == target) {
					count++;
				}
			}
			out.println(count);

			if (caso < casos - 1) {
				out.println();
			}

		}

		out.close();
		in.close();
	}
}
