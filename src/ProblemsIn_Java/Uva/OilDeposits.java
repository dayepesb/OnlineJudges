package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OilDeposits {

	static boolean[][] visit;
	static int filas, columnas;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		String line;

		while (true) {
			st = new StringTokenizer(in.readLine());
			filas = Integer.parseInt(st.nextToken());
			columnas = Integer.parseInt(st.nextToken());
			if (filas == columnas && columnas == 0) {
				break;
			}
			visit = new boolean[filas][columnas];
			for (int i = 0; i < filas; i++) {
				line = in.readLine().trim();
				for (int j = 0; j < columnas; j++) {
					char c = line.charAt(j);
					if (c == '*')
						visit[i][j] = true;

				}
			}
			int depositos = 0;
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					if (!visit[i][j]) {
						depositos++;
						visit[i][j] = true;
						dfs(i, j);
					}
				}
			}
			out.println(depositos);
		}

		out.close();
		in.close();
	}

	static void dfs(int x, int y) {
		if (x - 1 > -1 && y - 1 > -1) {
			if (!visit[x - 1][y - 1]) {
				visit[x - 1][y - 1] = true;
				dfs(x - 1, y - 1);
			}
		}
		if (x - 1 > -1) {
			if (!visit[x - 1][y]) {
				visit[x - 1][y] = true;
				dfs(x - 1, y);
			}
		}
		if (x - 1 > -1 && y + 1 < columnas) {
			if (!visit[x - 1][y + 1]) {
				visit[x - 1][y + 1] = true;
				dfs(x - 1, y + 1);
			}
		}
		if (y - 1 >= 0) {
			if (!visit[x][y - 1]) {
				visit[x][y - 1] = true;
				dfs(x, y - 1);
			}
		}
		if (y + 1 < columnas) {
			if (!visit[x][y + 1]) {
				visit[x][y + 1] = true;
				dfs(x, y + 1);
			}
		}
		if (x + 1 < filas && y - 1 >= 0) {
			if (!visit[x + 1][y - 1]) {
				visit[x + 1][y - 1] = true;
				dfs(x + 1, y - 1);
			}
		}
		if (x + 1 < filas) {
			if (!visit[x + 1][y]) {
				visit[x + 1][y] = true;
				dfs(x + 1, y);
			}
		}
		if (x + 1 < filas && y + 1 < columnas) {
			if (!visit[x + 1][y + 1]) {
				visit[x + 1][y + 1] = true;
				dfs(x + 1, y + 1);
			}
		}
	}

}
