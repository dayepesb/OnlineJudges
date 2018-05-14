package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NumberMaze {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			int fil = Integer.parseInt(in.readLine().trim());
			int col = Integer.parseInt(in.readLine().trim());
			int[][] mAdy = new int[fil][col];

			for (int j = 0; j < mAdy.length; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < mAdy[0].length; k++) {
					mAdy[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			out.println(Dijkstra(mAdy,fil,col));
		}
		out.close();
	}

	private static long Dijkstra(int[][] mAdy,int fil , int col) {
		int[][] solve = new int[fil][col];
		for (int[] js : solve) {
			Arrays.fill(js, Integer.MAX_VALUE);
		}
		
		PriorityQueue<Egde> q = new PriorityQueue<Egde>();

		q.add(new Egde(0, 0, mAdy[0][0]));
		solve[0][0] = mAdy[0][0];

		
		// su remplaza u.costo por solve[u.i][u.j] suben los costos
		
		while (!q.isEmpty()) {
			Egde u = q.poll();
			if ((u.i == fil - 1) && (u.j == col - 1)) {
				return solve[fil - 1][col - 1];
			} else {
				if (u.i - 1 >= 0) {
					if (solve[u.i-1][u.j] > solve[u.i][u.j] + mAdy[u.i-1][u.j]) {
						solve[u.i-1][u.j] = solve[u.i][u.j] + mAdy[u.i-1][u.j];
						q.add(new Egde(u.i-1, u.j, solve[u.i-1][u.j]));
					}
				}
				if (u.i + 1 < fil) {
					if (solve[u.i+1][u.j] > solve[u.i][u.j] + mAdy[u.i+1][u.j]) {
						solve[u.i+1][u.j] = solve[u.i][u.j] + mAdy[u.i+1][u.j];
						q.add(new Egde(u.i+1, u.j, solve[u.i+1][u.j]));
					}
				}
				if (u.j - 1 >= 0) {
					if (solve[u.i][u.j-1] > solve[u.i][u.j] + mAdy[u.i][u.j-1]) {
						solve[u.i][u.j-1] = solve[u.i][u.j] + mAdy[u.i][u.j-1];
						q.add(new Egde(u.i , u.j-1, solve[u.i][u.j-1]));
					}
				}
				if (u.j + 1 < col) {
					if (solve[u.i][u.j+1] > solve[u.i][u.j] + mAdy[u.i][u.j+1]) {
						solve[u.i][u.j+1] = solve[u.i][u.j] + mAdy[u.i][u.j+1];
						q.add(new Egde(u.i , u.j+1, solve[u.i][u.j+1]));
					}
				}
			}
		}
		return solve[fil - 1][col - 1];
	}

	public static class Egde implements Comparable<Egde> {

		public int i;
		public int j;
		public int costo;

		public Egde(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.costo = d;
		}

		@Override
		public int compareTo(Egde o) {
			return (costo-o.costo);
		}
	}
}
