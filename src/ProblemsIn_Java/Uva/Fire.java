package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		long casos = Long.parseLong(in.readLine().trim());
		for (int caso = 0; caso < casos; caso++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int fil = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			char[][] array = new char[fil][col];
			for (int j = 0; j < fil; j++) {
				array[j] = in.readLine().toCharArray();
			}
			int a = 0, b = 0;
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					if (array[i][j] == 'F') {
						q.add(i);
						q.add(j);
					}
					if (array[i][j] == 'J') {
						a = i;
						b = j;
					}
				}
			}
			int bfs = bfs(a, b, q, array);
			out.println(bfs <= 0 ? "IMPOSSIBLE" : bfs);
		}
		out.close();
		in.close();
	}

	private static int bfs(int a, int b, Queue<Integer> q, char[][] array) {
		q.add(a);
		q.add(b);
		if (a == 0 || a == array.length - 1 || b == 0 || b == array[0].length - 1) {
			return 1;
		}
		int[][] paso = new int[array.length][array[0].length];
		paso[a][b] = 2;
		while (!q.isEmpty()) {
			int x = q.poll(), y = q.poll();
			if (x - 1 >= 0 && array[x - 1][y] == '.') {
				q.add(x - 1);
				q.add(y);
				array[x - 1][y] = array[x][y];
				if (array[x - 1][y] == 'J') {
					paso[x - 1][y] = paso[x][y] + 1;
					if (x - 1 == 0) {
						return paso[x][y];
					}
				}
			}
			if (x + 1 < array.length && array[x + 1][y] == '.') {
				q.add(x + 1);
				q.add(y);
				array[x + 1][y] = array[x][y];
				if (array[x + 1][y] == 'J') {
					paso[x + 1][y] = paso[x][y] + 1;
					if (x + 1 == array.length - 1) {
						return paso[x][y];
					}
				}
			}
			if (y - 1 >= 0 && array[x][y - 1] == '.') {
				q.add(x);
				q.add(y - 1);
				array[x][y - 1] = array[x][y];
				if (array[x][y - 1] == 'J') {
					paso[x][y - 1] = paso[x][y] + 1;
					if (y - 1 == 0) {
						return paso[x][y];
					}
				}
			}
			if (y + 1 < array[0].length && array[x][y + 1] == '.') {
				q.add(x);
				q.add(y + 1);
				array[x][y + 1] = array[x][y];
				if (array[x][y + 1] == 'J') {
					paso[x][y + 1] = paso[x][y] + 1;
					if (y + 1 == array[0].length - 1) {
						return paso[x][y];
					}
				}
			}
		}
		return 0;
	}

}
