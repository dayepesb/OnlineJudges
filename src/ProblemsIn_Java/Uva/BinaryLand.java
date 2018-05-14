package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BinaryLand {
	static final int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int visit[][][][], fc, cc, fil, col, INF = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		String line;
		char arr[][];
		for (; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			fil = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			visit = new int[fil+1][col+1][fil+1][col+1];
			arr = new char[fil][col];

			for (int i = 0; i < fil; i++) {
				for (int j = 0; j < col; j++) {
					for (int k = 0; k < fil; k++) {
						Arrays.fill(visit[i][j][k], INF);
					}
				}
			}

			st = new StringTokenizer(in.readLine());
			fc = Integer.parseInt(st.nextToken()) - 1;
			cc = Integer.parseInt(st.nextToken()) - 1;
			int[] ini = { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 };
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.readLine().toCharArray();
			}
			int res = bfs(ini,arr);
			out.println(res == INF ? "NO LOVE" : res);
		}
		out.close();
	}

	static int bfs(int[] ini,char arr[][]) {

		Deque<int[]> cola = new ArrayDeque<>();
		cola.add(ini);
		visit[ini[0]][ini[1]][ini[2]][ini[3]] = 0;

		while (!cola.isEmpty()) {
			int[] u = cola.poll();
			int rg = u[0], cg = u[1], rm = u[2], cm = u[3];
			for (int[] dir : dirs) {
				int r1, c1, r2, c2;
				r1 = rg + dir[0];
				c1 = cg + dir[1];
				r2 = rm + dir[0];
				c2 = cm - dir[1];
				if (r1 >= fil || r1 < 0 || c1 >= col || c1 < 0 || arr[r1][c1] == '#') {r1 = rg;c1 = cg;}
				if (r2 >= fil || r2 < 0 || c2 >= col || c2 < 0 || arr[r2][c2] == '#') {r2 = rm;c2 = cm;}
				if (visit[r1][c1][r2][c2] > visit[rg][cg][rm][cm] + 1) {
					visit[r1][c1][r2][c2] = visit[rg][cg][rm][cm] + 1;
					cola.add(new int[] { r1, c1, r2, c2 });
				}
				if(visit[fc][cc][fc][cc]!=INF){
					return visit[fc][cc][fc][cc];
				}
			}
		}
		return INF;
	}
}