package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EasyDijkstraProblem {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 0; k < casos; k++) {
			st = new StringTokenizer(in.readLine());
			int nodos = Integer.parseInt(st.nextToken());
			int aristas = Integer.parseInt(st.nextToken());
			int[][] mAdy = new int[nodos][nodos];
			for (int[] is : mAdy) {
				Arrays.fill(is, -1);
			}

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				mAdy[x][y] = c;
			}
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int target = Integer.parseInt(st.nextToken()) - 1;
			int solve = dijkstra_PriorityQueue(mAdy, start, target);
			out.println(solve == Integer.MAX_VALUE / 2 ? "NO" : solve);
		}

		out.close();
		in.close();
	}

	static int dijkstra_PriorityQueue(int mAdy[][], int start, int target) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int solve[] = new int[mAdy.length];
		Arrays.fill(solve, Integer.MAX_VALUE / 2);

		q.add(start);
		solve[start] = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < mAdy.length; i++) {
				if (mAdy[u][i] != -1 && (mAdy[u][i] + solve[u]) < solve[i]) {
					solve[i] = mAdy[u][i] + solve[u];
					q.add(i);
				}
			}
		}
		return solve[target];
	}
}
