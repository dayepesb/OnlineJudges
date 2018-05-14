package ProblemsIn_Java.Light

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 27-07-2017
 */
public class PowerPuffGirls {
	static final int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int vis[][], n, m;
	static char world[][];
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int t = Integer.parseInt(in.readLine().trim());
		for (int c = 1; c <= t; c++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			world = new char[n][m];
			for (int i = 0; i < n; i++) {
				world[i] = in.readLine().trim().toCharArray();
			}
			/*
			 * a 0 b 1 c 2 h 3
			 */
			int pos[][] = new int[4][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (world[i][j] == 'a') {
						pos[0][0] = i;
						pos[0][1] = j;
					}
					if (world[i][j] == 'b') {
						pos[1][0] = i;
						pos[1][1] = j;
					}
					if (world[i][j] == 'c') {
						pos[2][0] = i;
						pos[2][1] = j;
					}
					if (world[i][j] == 'h') {
						pos[3][0] = i;
						pos[3][1] = j;
					}
				}
			}
			int min = -65464;
			for (int i = 0; i < 3; i++) {
				int res = bfs(pos[i][0], pos[i][1], pos[3][0], pos[3][1]);
				min = Math.max(min, res);
			}
			out.printf("Case %d: %d%n",c,min);
		}

		in.close();
		out.close();
	}

	/**
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @return
	 */
	private static int bfs(int startx, int starty, int endx, int endy) {
		vis = new int[n][m];
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < vis.length; i++) {
			Arrays.fill(vis[i], INF);
		}

		vis[startx][starty] = 0;
		q.addLast(new int[] { startx, starty });
		while (!q.isEmpty()) {
			int[] u = q.pollFirst();
			int x = u[0];
			int y = u[1];
			for (int i[] : dirs) {
				int wx = x + i[0];
				int wy = y + i[1];
				if (vis[wx][wy] == INF && world[wx][wy] != 'm' && world[wx][wy] != '#') {
					vis[wx][wy] = vis[x][y] + 1;
					if (wx == endx && wy == endy)
						return vis[wx][wy];
					q.addLast(new int [] {wx,wy});
				}
			}
		}

		return vis[endx][endy];
	}
}
