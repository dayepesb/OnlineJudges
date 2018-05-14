package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class BombsNoTheyAreMines {
	static boolean boms[][];
	static int FILLS, ROWS;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line = in.readLine().trim();; line = in.readLine().trim()) {
			st = new StringTokenizer(line);
			FILLS = Integer.parseInt(st.nextToken());
			ROWS = Integer.parseInt(st.nextToken());
			if (FILLS == 0 && ROWS == 0)
				break;
			boms = new boolean[FILLS][ROWS];
			int numberBombs = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < numberBombs; i++) {
				st = new StringTokenizer(in.readLine());
				int index = Integer.parseInt(st.nextToken());
				int quanty = Integer.parseInt(st.nextToken());
				for (int j = 0; j < quanty; j++) {
					boms[index][Integer.parseInt(st.nextToken())] = true;
				}
			}
			st = new StringTokenizer(in.readLine());
			int sourceFill = Integer.parseInt(st.nextToken());
			int sourceRow = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int targetFill = Integer.parseInt(st.nextToken());
			int targetRow = Integer.parseInt(st.nextToken());
			out.println(bfs(sourceRow, sourceFill, targetRow, targetFill));
		}

		in.close();
		out.close();
	}

	static int bfs(int sourceRow, int sourceFill, int targetRow, int targetFill) {
		int visit[][] = new int[boms.length][boms[0].length];
		for (int[] is : visit) {
			Arrays.fill(is, -1);
		}
		Queue<node> q = new LinkedList<>();

		visit[sourceFill][sourceRow] = 0;
		q.add(new node(sourceFill, sourceRow));
		while (!q.isEmpty()) {
			node u = q.poll();
			// mirar los 4 movimientos hacia arriva,abajo,izq,derecha
			if (u.fill - 1 >= 0 && !boms[u.fill - 1][u.row] && visit[u.fill - 1][u.row] == -1) {
				visit[u.fill - 1][u.row] = visit[u.fill][u.row] + 1;
				if (u.fill - 1 == targetFill && u.row == targetRow)
					break;
				q.add(new node(u.fill - 1, u.row));
			}
			if (u.fill + 1 < FILLS && !boms[u.fill + 1][u.row] && visit[u.fill + 1][u.row] == -1) {
				visit[u.fill + 1][u.row] = visit[u.fill][u.row] + 1;
				if (u.fill + 1 == targetFill && u.row == targetRow)
					break;
				q.add(new node(u.fill + 1, u.row));
			}
			if (u.row - 1 >= 0 && !boms[u.fill][u.row - 1] && visit[u.fill][u.row - 1] == -1) {
				visit[u.fill][u.row - 1] = visit[u.fill][u.row] + 1;
				if (u.fill == targetFill && u.row - 1 == targetRow)
					break;
				q.add(new node(u.fill, u.row - 1));
			}
			if (u.row + 1 < ROWS && !boms[u.fill][u.row + 1] && visit[u.fill][u.row + 1] == -1) {
				visit[u.fill][u.row + 1] = visit[u.fill][u.row] + 1;
				if (u.fill == targetFill && u.row + 1 == targetRow)
					break;
				q.add(new node(u.fill, u.row + 1));
			}
		}

		return visit[targetFill][targetRow];
	}

	static class node {
		int row, fill;

		public node(int fill, int row) {
			this.row = row;
			this.fill = fill;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return fill + " " + row;
		}
	}

}
