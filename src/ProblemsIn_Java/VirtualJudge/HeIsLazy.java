package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 * @Date 11-07-2017
 */
public class HeIsLazy {
	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			StringTokenizer st = new StringTokenizer(tec.readLine());
			int n = Integer.parseInt(st.nextToken());
			ArrayList<nodo> arr = new ArrayList<>();
			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());
			arr.add(new nodo(x1, y1, 0, false));
			arr.add(new nodo(x2, y2, 0, false));
			if (x1 == -1 && n == -1 && x2 == -1 && y1 == -1 && y2 == -1)
				break;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(tec.readLine());
				arr.add(new nodo(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()),
						Double.parseDouble(st.nextToken()), true));
			}
			// fuente 0 destino 1
			double[][] mat = new double[arr.size()][arr.size()];
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					mat[i][j] = Math.hypot(arr.get(i).x - arr.get(j).x, arr.get(i).y - arr.get(j).y);
					if (i != j) {
						if (arr.get(i).cat) {
							// hay tres casos me paso y me devuelvo
							// sigo
							// camino
							mat[i][j] = Math.min(mat[i][j], Math.abs(mat[i][j] - arr.get(i).dist));
						}
					}
				}
			}
			out.printf("%.2f\n", dijkstra(mat));
		}
		out.close();
	}

	private static double dijkstra(double[][] mat) {
		Queue<Integer> q = new ArrayDeque<>();
		double[] arr = new double[mat.length];
		Arrays.fill(arr, Double.MAX_VALUE / 2);
		arr[0] = 0.;
		q.add(0);
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < arr.length; i++) {
				if (i != u) {
					if (arr[i] > arr[u] + mat[u][i]) {
						q.add(i);
						arr[i] = arr[u] + mat[u][i];
					}
				}
			}
		}
		return arr[1];
	}

	static class nodo {
		double x, y, dist;
		boolean cat;

		public nodo(double x, double y, double dist, boolean cat) {
			this.x = x;
			this.y = y;
			this.cat = cat;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return x + " " + y + " " + dist;
		}
	}
}