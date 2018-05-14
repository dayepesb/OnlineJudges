package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 09-01-2018
 * @time 0.355 ms
 */
public class SayCheese {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int x[];
		int y[];
		int z[];
		int r[];
		double graph[][];
		int tc = 1;
		for (int n = Integer.parseInt(in.readLine().trim()); n != -1; n = Integer.parseInt(in.readLine().trim())) {
			x = new int[n + 2];
			y = new int[n + 2];
			z = new int[n + 2];
			r = new int[n + 2];
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(in.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
				z[i] = Integer.parseInt(st.nextToken());
				if (i < n) {
					r[i] = Integer.parseInt(st.nextToken());
				} else
					r[i] = 0;
			}
			n += 2;
			graph = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						graph[i][i] = 0;
					else {
						double dist = Math
								.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2) + Math.pow(z[i] - z[j], 2));
						if (dist <= r[i] + r[j])
							graph[i][j] = 0;
						
						else
							graph[i][j] = dist - (r[i] + r[j]);
					}
				}
			}
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			out.printf("Cheese %d: Travel time = %.0f sec%n", tc++, graph[n - 1][n - 2] * 10);
		}

		in.close();
		out.close();
	}

}
