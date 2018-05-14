package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 15-10-2017
 * @time 0.640 ms
 */
public class CargoTrains {
	private static int n, ma, mb, q, a[][], b[][];
	private static double hsa, hsb;
	private static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			ma = Integer.parseInt(st.nextToken());
			mb = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			if (n + ma + mb + q < 0)
				break;
			init();
			for (int i = 0; i < ma; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				a[u][v] = a[v][u] = w;
			}
			for (int i = 0; i < mb; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				b[u][v] = b[v][u] = w;
			}

			while (q-- > 0) {
				hsa = Double.parseDouble(in.readLine().trim());
				hsb = 1 - hsa;
				out.println((int) dijkstra());
			}

		}

		in.close();
		out.close();
	}

	static double dijkstra() {
		double d[] = new double[n + 2], min, temp;
		int u, v, i;
		boolean free[] = new boolean[n + 2];
		for (u = 0; u < n; u++) {
			d[u] = INF;
			free[u] = true;
		}
		d[0] = 0;
		while (true) {
			u = -1;
			min = INF;
			for (i = 0; i < n; i++)
				if (free[i] && d[i] < min) {
					min = d[i];
					u = i;
				}
			if (u == -1 || u == n - 1)
				break;
			free[u] = false;
			for (v = 0; v < n; v++) {
				if (a[u][v] == INF)
					temp = b[u][v];
				else if (b[u][v] == INF)
					temp = a[u][v];
				else
					temp = hsa * a[u][v] + hsb * b[u][v];

				if (free[v] && d[v] > d[u] + temp) {
					d[v] = d[u] + temp;
				}
			}
		}
		return d[n - 1];
	}

	static void init() {
		a = new int[n][n];
		b = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(a[i], INF);
			Arrays.fill(b[i], INF);
			a[i][i] = b[i][i] = 0;
		}
	}
}
