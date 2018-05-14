package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class ShippingRoutes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		HashMap<String, Integer> index;
		int mAdy[][];
		String id1, id2;
		int m, n, p, caso = 1;
		int T = Integer.parseInt(in.readLine().trim());
		out.println("SHIPPING ROUTES OUTPUT");
		for (; caso <= T; caso++) {
			out.println("\nDATA SET  " + caso + "\n");
			st = new StringTokenizer(in.readLine());
			// m nodos
			m = Integer.parseInt(st.nextToken());
			// n aristas
			n = Integer.parseInt(st.nextToken());
			// numero de shipping
			p = Integer.parseInt(st.nextToken());
			index = new HashMap<>();

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < m; i++) {
				id1 = st.nextToken();
				index.put(id1, i);
			}

			mAdy = new int[m][m];
			for (int i = 0; i < mAdy.length; i++) {
				Arrays.fill(mAdy[i], Integer.MAX_VALUE / 2);
				mAdy[i][i] = 0;
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				id1 = st.nextToken();
				id2 = st.nextToken();
				int start = index.get(id1), end = index.get(id2);
				mAdy[start][end] = mAdy[end][start] = 1;
			}

			for (int k = 0; k < m; k++) {
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < m; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}

			for (int i = 0; i < p; i++) {
				st = new StringTokenizer(in.readLine());
				int size = Integer.parseInt(st.nextToken());
				id1 = st.nextToken();
				id2 = st.nextToken();
				int start = index.get(id1), end = index.get(id2);
				if (mAdy[start][end] == Integer.MAX_VALUE/2) {
					out.println("NO SHIPMENT POSSIBLE");
				} else {
					out.println("$" + size * mAdy[start][end] * 100);
				}
			}

		}

		out.println("\nEND OF OUTPUT");

		in.close();
		out.close();
	}
}
