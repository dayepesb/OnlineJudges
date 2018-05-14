package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BankRobery {
	static int mAdy[][];
	static final int INF = Integer.MAX_VALUE;
	static int N, M, B, P;
	static ArrayList<Integer> Banks;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			mAdy = new int[N + 1][N + 1];
			for (int[] is : mAdy) {
				Arrays.fill(is, INF);
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				mAdy[u][v] = mAdy[v][u] = t;
			}

			Banks = new ArrayList<>();
			if (B != 0)
				st = new StringTokenizer(in.readLine());
			for (int i = 0; i < B; i++) {
				Banks.add(Integer.parseInt(st.nextToken()));
			}

			if (P != 0)
				st = new StringTokenizer(in.readLine());
			for (int i = 0; i < P; i++) {
				int p = Integer.parseInt(st.nextToken());
				mAdy[N][p] = mAdy[p][N] = 0;
			}

			int solve[] = Dijkstra();

			int max = -1;
			for (int bank : Banks) {
				max = Math.max(solve[bank], max);
			}

			ArrayList<Integer> answer = new ArrayList<>();
			for (int bank : Banks) {
				if (solve[bank] == max)
					answer.add(bank);
			}

			out.printf("%d %s%n", answer.size(), (max == INF ? "*" : max + ""));
			Collections.sort(answer);
			for (int i = 0; i < answer.size(); i++) {
				if (i == answer.size() - 1)
					out.print(answer.get(i));
				else
					out.print(answer.get(i) + " ");
			}
			out.println();

		}

		in.close();
		out.close();
	}

	static int[] Dijkstra() {
		Deque<Integer> pq = new ArrayDeque<>();
		int solve[] = new int[N + 1];
		Arrays.fill(solve, INF);

		solve[N] = 0;
		pq.addLast(N);
		while (!pq.isEmpty()) {
			int u = pq.pollFirst();
			for (int w = 0; w <= N; w++) {
				if (mAdy[u][w] != INF && (mAdy[u][w] + solve[u]) < solve[w]) {
					solve[w] = mAdy[u][w] + solve[u];
					pq.add(w);
				}
			}
		}

		return solve;
	}


}
