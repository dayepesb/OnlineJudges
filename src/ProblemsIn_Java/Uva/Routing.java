package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class Routing {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int nodos, aristas, caso = 1;
		// ArrayList<Integer> lAdy[];
		int g[][];

		for (String line; !(line = in.readLine()).equals("0 0");) {
			st = new StringTokenizer(line);
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());
			g = new int[nodos + 1][nodos + 1];
			for (int i = 1; i <= nodos; i++) {
				for (int j = 1; j <= nodos; j++) {
					g[i][j] = 0xfffffff;
				}
			}
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				g[x][y] = 1;
			}
			for (int k = 1; k <= nodos; k++)
				for (int i = 1; i <= nodos; i++)
					for (int j = 1; j <= nodos; j++)
						g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);

			int dp[][] = new int[nodos + 1][nodos + 1];
			for (int i = 1; i <= nodos; i++)
				for (int j = 1; j <= nodos; j++)
					dp[i][j] = 0xfffffff;
			// queue<int> X, Y;
			int inq[][] = new int[nodos + 1][nodos + 1];
			Queue<Integer> X = new LinkedList<Integer>();
			Queue<Integer> Y = new LinkedList<>();
			X.add(1);
			Y.add(1);
			dp[1][1] = 1;
			int x, y;
			while (!X.isEmpty()) {
				x = X.poll();
				y = Y.poll();
				inq[x][y] = 0;
				// printf("%2d %2d %d\n", x, y, dp[x][y]);
				for (int i = 1; i <= nodos; i++) {
					int cost = (x != i && y != i) ? 1 : 0;
					if (g[x][i] == 1) {
						if (dp[i][y] > dp[x][y] + cost) {
							dp[i][y] = dp[x][y] + cost;
							if (inq[i][y] == 0) {
								inq[i][y] = 1;

								X.add(i);
								Y.add(y);
							}
						}
					}
					if (g[i][y] == 1) {
						if (dp[x][i] > dp[x][y] + cost) {
							dp[x][i] = dp[x][y] + cost;
							if (inq[x][i] == 0) {
								inq[x][i] = 1;
								X.add(x);
								Y.add(i);
							}
						}
					}
				}
				if (x != y) {
					if (dp[y][x] > dp[x][y] + g[x][y] - 1) {
						dp[y][x] = dp[x][y] + g[x][y] - 1;
						if (inq[y][x] == 0) {
							inq[y][x] = 1;
							X.add(y);
							Y.add(x);
						}
					}
				}
			}
			out.printf("Network %d\n", caso++);
			if (dp[2][2] == 0xfffffff)
				out.println("Impossible");
			else
				out.printf("Minimum number of nodes = %d\n", dp[2][2]);
			out.println();
		}

		in.close();
		out.close();
	}
}
