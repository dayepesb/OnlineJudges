package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumTransportCost {

	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] adsf) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		StringTokenizer st;
		int mAdy[][];
		int costos[];
		int casos = Integer.parseInt(in.readLine().trim());

		line = in.readLine();
		for (int k = 0; k < casos; k++) {
			while (true) {
				if (line.equals("")) {
					line = in.readLine();
				} else {
					break;
				}
			}
			st = new StringTokenizer(line);
			mAdy = new int[st.countTokens()][st.countTokens()];
			costos = new int[st.countTokens()];
			for (int i = 0; i < mAdy.length; i++) {
				for (int j = 0; j < mAdy.length; j++) {
					mAdy[i][j] = Integer.parseInt(st.nextToken());
				}
				st = new StringTokenizer(in.readLine());
			}

			for (int i = 0; i < costos.length; i++) {
				costos[i] = Integer.parseInt(st.nextToken());
			}
			
			
			line = in.readLine();
			Consultas: while (true) {
				st = new StringTokenizer(line);
				Dijkstra(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, mAdy, costos);
				out.println();
				line = in.readLine();
				if (line == null || line.equals("")) {
					break;
				} else {
					out.println();
				}
			}
			if (k < casos-1) {
				out.println();
			}
		}
		out.close();
		in.close();
	}

	public static void Dijkstra(int ini, int fin, int mAdy[][], int costos[]) {
		String[] camino = new String[costos.length];
		int[] solve = new int[costos.length];
		Arrays.fill(solve, Integer.MAX_VALUE);

		PriorityQueue<Integer> q = new PriorityQueue<>();

		q.add(ini);
		solve[ini] = 0;
		camino[ini] = (ini + 1) + "";

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < mAdy.length; i++) {
				if (i == fin) {
					if (mAdy[u][i] != -1 && solve[i] > (solve[u] + mAdy[u][i])) {
						solve[i] = (solve[u] + mAdy[u][i]);
						q.add(i);
						camino[i] = camino[u] + "-->" + (i + 1);
					}
				} else {
					if (mAdy[u][i] != -1 && solve[i] > (solve[u] + mAdy[u][i] + costos[i])) {
						solve[i] = (solve[u] + mAdy[u][i] + costos[i]);
						q.add(i);
						camino[i] = camino[u] + "-->" + (i + 1);
					}

				}
			}
		}

		out.printf("From %d to %d :%n", ini + 1, fin + 1);
		out.printf("Path: %s%n", camino[fin]);
		out.printf("Total cost : %d", solve[fin]);

	}

}