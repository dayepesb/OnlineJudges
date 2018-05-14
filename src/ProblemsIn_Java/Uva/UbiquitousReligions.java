package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UbiquitousReligions {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n, m, x, y;
		StringTokenizer st;
		int caso = 1;
		while (true) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0)
				break;

			int arr[] = new int[n+1];
			Arrays.fill(arr, -1);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr = union(x, y, arr);
			}

			int cont = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					cont++;
				}
			}
			out.printf("Case %d: %d%n", caso, cont);
			caso++;
		}

		in.close();
		out.close();
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
