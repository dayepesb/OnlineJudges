package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 24-08-2017
 * @time 0.000 ms
 */
public class ChocolateChipCookies {
	static Pt p[];
	static final double eps = 1e-9;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine().trim());
		String line = in.readLine();
		int i, j;

		line = in.readLine();

		for (i = 0; i < casos; i++) {
			if (i > 0)
				out.println();
			int n = 0;
			p = new Pt[250];
			while (line != null && !line.equals("")) {
				st = new StringTokenizer(line);
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				p[n] = new Pt(x, y);
				line = in.readLine();
				n++;
			}

			int ans = 0, tmp;
			Pt m, C;
			for (i = 0; i < n; i++) {
				C = p[i];
				tmp = check(n, C);
				if (tmp > ans)
					ans = tmp;
				for (j = i + 1; j < n; j++) {
					Pt A = p[i], B = p[j];
					double distAB = Math.sqrt(dist(A, B));
					if (distAB <= 5 + eps) {
						double distmC = Math.sqrt(2.5 * 2.5 - distAB * distAB / 4 + eps);
						double vx = A.y - B.y, vy = B.x - A.x, vv;
						m = new Pt((A.x + B.x) / 2, (A.y + B.y) / 2);
						vv = Math.sqrt(vx * vx + vy * vy);
						vx /= vv;
						vy /= vv;
						C.x = m.x + vx * distmC;
						C.y = m.y + vy * distmC;
						tmp = check(n, C);
						if (tmp > ans)
							ans = tmp;
						C.x = m.x - vx * distmC;
						C.y = m.y - vy * distmC;
						tmp = check(n, C);
						if (tmp > ans)
							ans = tmp;
					}
				}
			}
			out.printf("%d\n", ans);
		}

		in.close();
		out.close();
	}

	static class Pt {
		double x, y;

		public Pt(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static double dist(Pt a, Pt b) {
		return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
	}

	static int check(int n, Pt c) {
		int i, cnt = 0;
		for (i = 0; i < n; i++) {
			if (dist(c, p[i]) <= 2.5 * 2.5 + eps)
				cnt++;
		}
		return cnt;
	}
}
