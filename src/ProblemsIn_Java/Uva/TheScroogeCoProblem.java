package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class TheScroogeCoProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
//		PrintWriter out = new PrintWriter(new File("debug.txt"));

		StringTokenizer st;
		HashMap<String, Integer> names;
		HashMap<Integer, String> numbers;
		int mAdy[][];
		int road[][];
		int nodes, c = Integer.parseInt(in.readLine().trim());
		for (int l = 0; l < c; l++) {
			names = new HashMap<>();
			numbers = new HashMap<>();
			nodes = Integer.parseInt(in.readLine().trim());
			int index = 0;
			st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) {
				String a = st.nextToken();
				names.put(a, index);
				numbers.put(index, a);
				index++;
			}

			mAdy = new int[nodes][nodes];
			road = new int[nodes][nodes];
			for (int i = 0; i < nodes; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < nodes; j++) {
					int p = Integer.parseInt(st.nextToken());
					mAdy[i][j] = p == -1 ? Integer.MAX_VALUE / 2 : p;
					road[i][j] = j;
				}
			}

			for (int k = 0; k < nodes; k++) {
				for (int i = 0; i < nodes; i++) {
					if (mAdy[i][k] != Integer.MAX_VALUE / 2) {
						for (int j = 0; j < nodes; j++) {
							if (mAdy[k][j] != Integer.MAX_VALUE / 2 && mAdy[i][k] + mAdy[k][j] < mAdy[i][j]) {
								mAdy[i][j] = mAdy[i][k] + mAdy[k][j];
								road[i][j] = road[i][k];
							}
						}
					}
				}
			}

			int query = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < query; i++) {
				st = new StringTokenizer(in.readLine());
				String employe = st.nextToken();
				String start = st.nextToken();
				String end = st.nextToken();
				int node1 = names.get(start);
				int node2 = names.get(end);

				if (mAdy[node1][node2] != Integer.MAX_VALUE / 2) {
					out.printf("Mr %s to go from %s to %s, you will receive %d euros\n", employe, start, end,
							mAdy[node1][node2]);
					// print_path(s, e);
					out.printf("Path:%s", numbers.get(node1));
					do {
						node1 = road[node1][node2];
						out.printf(" %s", numbers.get(node1));
					} while (node1 != node2);
					out.println();
				} else {
					out.printf("Sorry Mr %s you can not go from %s to %s\n", employe, start, end);
				}

			}

		}

		in.close();
		out.close();
	}
}
