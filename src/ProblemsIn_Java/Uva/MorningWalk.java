package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Scanner;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.820 ms
 */
public class MorningWalk {
	static boolean lAdy[][];
	static BitSet vis;
	static int nodos, aristas;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int degree[];
		for (; in.hasNext();) {
			nodos = in.nextInt();
			aristas = in.nextInt();
			degree = new int[nodos];
			vis = new BitSet();
			lAdy = new boolean[nodos][nodos];
			int u = 0, v = 0;
			for (int i = 0; i < aristas; i++) {
				u = in.nextInt();
				v = in.nextInt();
				degree[u] += 1;
				degree[v] += 1;
				lAdy[u][v] = lAdy[v][u] = true;
				vis.set(u);
				vis.set(v);
			}
			boolean flag = false;
			int df = vis.cardinality();
			vis = new BitSet();

			if (aristas == 0) {
				flag = true;
			} else if (dfs(u) != df) {
				flag = true;

			} else {
				for (int i = 0; i < nodos; i++) {
					if ((degree[i] & 1) > 0) {
						flag = true;
						break;
					}
				}
			}

			if (flag)
				out.println("Not Possible");
			else
				out.println("Possible");
		}

		in.close();
		out.close();
	}

	/**
	 * @param u
	 * @return number of visiting nodes
	 */
	private static int dfs(int u) {
		if (vis.get(u)) {
			return 0;
		}
		vis.set(u);
		;
		int ans = 1;
		for (int i = 0; i < nodos; i++)
			if (lAdy[u][i]) {
				lAdy[u][i] = lAdy[i][u] = false;
				ans += dfs(i);
			}
		return ans;

	}
}
