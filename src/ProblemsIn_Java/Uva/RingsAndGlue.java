package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RingsAndGlue {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		double radio[];

		for (String line = in.readLine().trim(); !line.equals("-1"); line = in.readLine().trim()) {
			int n = Integer.parseInt(line);
			if (n != 0) {
				radio = new double[n];
				int conj[] = new int[n];
				Arrays.fill(conj, -1);
				ArrayList<Point2D> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					StringTokenizer st = new StringTokenizer(in.readLine());
					double x = Double.parseDouble(st.nextToken());
					double y = Double.parseDouble(st.nextToken());
					double r = Double.parseDouble(st.nextToken());
					list.add(new Point2D.Double(x, y));
					radio[i] = r;
				}
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						if (list.get(i).distance(list.get(j)) < (radio[i] + radio[j])) {
							if (!(list.get(i).distance(list.get(j)) + Math.min(radio[i], radio[j]) <= Math.max(radio[i],
									radio[j]))) {
								if (find(i, conj) != find(j, conj)) {
									conj = union(i, j, conj);
								}
							}
						}
					}
				}
				int max = -1;
				for (int i = 0; i < conj.length; i++) {
					max = Math.max(max, -conj[i]);
				}
				if (max == 1)
					out.printf("The largest component contains 1 ring.\n");
				else
					out.printf("The largest component contains %d rings.\n", max);
			} else {
				out.printf("The largest component contains 0 rings.\n");
			}
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
