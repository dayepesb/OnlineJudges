package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class WakingUpBrain {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line = in.readLine(); line != null;) {
			int N = Integer.parseInt(line.trim()) - 3;
			int M = Integer.parseInt(in.readLine().trim());
			String despiertas = in.readLine();
			int conj[] = new int[26];
			Arrays.fill(conj, -1);
			boolean[][] con = new boolean[26][26];
			for (int i = 0; i < M; i++) {
				line = in.readLine();
				int x = line.charAt(0) - 'A';
				int y = line.charAt(1) - 'A';
				con[x][y] = con[y][x] = true;
			}
			conj = union(despiertas.charAt(0) - 'A', despiertas.charAt(1) - 'A', conj);
			conj = union(despiertas.charAt(1) - 'A', despiertas.charAt(2) - 'A', conj);
			int parent = find(despiertas.charAt(0) - 'A', conj);

			int year = 0;
			boolean sePuede = true;
			while (sePuede) {
				sePuede = false;
				boolean despierta[] = new boolean[26];
				for (int i = 0; i < 26; i++) {
					if (find(i, conj) == parent) {
						continue;
					}
					int count = 0;
					for (int j = 0; j < 26; j++) {
						if (con[i][j] && find(j, conj) == parent) {
							count++;
						}
					}
					if (count > 2) {
						sePuede = true;
						despierta[i] = true;
						N--;
					}
				}
				for (int i = 0; i < 26; i++) {
					if (despierta[i]) {
						conj = union(i, despiertas.charAt(0) - 'A', conj);
					}
				}
				if (sePuede) {
					year++;
				}
			}
			if (N <= 0) {
				out.printf("WAKE UP IN, %d, YEARS%n", year);
			} else {
				out.printf("THIS BRAIN NEVER WAKES UP%n");
			}

			in.readLine();
			line = in.readLine();
		}

		out.close();
		in.close();
	}

	static int[] union(int x, int y, int[] set) {
		x = find(x, set);
		y = find(y, set);

		if (x == y)
			return set;

		int sizex = -(set[x]);
		int sizey = -(set[y]);

		if (sizex < sizey) {
			set[y] = set[y] + set[x];
			set[x] = y;
		} else {
			set[x] = set[x] + set[y];
			set[y] = x;
		}

		return set;
	}

	static int find(int x, int[] set) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x], set);
	}

}
