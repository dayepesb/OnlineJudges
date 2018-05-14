package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KnightsInFen {

	static String solved = "111110111100 110000100000";
	static int[] dr = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String board = "";
			for (int i = 0; i < 5; ++i)
				board += in.readLine();
			int dist = bfs(board);
			out.println(dist >= 0 ? "Solvable in " + (dist) + " move(s)." : "Unsolvable in less than 11 move(s).");
		}

		in.close();
		out.close();
	}

	public static int bfs(String s) {
		HashSet<String> visited = new HashSet<String>();
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		Queue<String> q = new LinkedList<String>();

		visited.add(s);
		dist.put(s, 0);
		q.offer(s);

		while (!q.isEmpty()) {
			String x = q.poll();
			int d = dist.get(x);
			if (d > 10)
				return -1;
			if (x.equals(solved))
				return d;

			int r = 0;
			int c = 0;
			for (int i = 0; i < x.length(); ++i)
				if (x.charAt(i) == ' ') {
					r = i / 5;
					c = i % 5;
					break;
				}

			char[] board = x.toCharArray();
			for (int k = 0; k < dr.length; ++k) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (inside(nr, nc)) {
					swap(board, 5 * r + c, 5 * nr + nc);
					String next = String.valueOf(board);
					swap(board, 5 * r + c, 5 * nr + nc);
					if (!visited.contains(next)) {
						visited.add(next);
						dist.put(next, d + 1);
						q.offer(next);
					}
				}
			}
		}

		return -1;
	}

	public static boolean inside(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < 5;
	}

	public static void swap(char[] b, int i, int j) {
		char t = b[i];
		b[i] = b[j];
		b[j] = t;
	}

}