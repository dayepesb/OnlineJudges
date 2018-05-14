package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 03-11-2017
 * @time 0.000 ms
 */
public class Census {
	static int A[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, q, x1, y1, x2, y2, v;

		for (String line; (line = in.readLine()) != null;) {
			n = Integer.parseInt(line.trim());
			A = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			SegmentTree st2d = new SegmentTree(0, 0, n - 1, n - 1);
			q = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(in.readLine());
				switch (st.nextToken().toLowerCase()) {
				case "q":
					x1 = Integer.parseInt(st.nextToken());
					y1 = Integer.parseInt(st.nextToken());
					x1 = Integer.parseInt(st.nextToken());
					v = Integer.parseInt(st.nextToken());
					break;
				case "c":
					x1 = Integer.parseInt(st.nextToken());
					y1 = Integer.parseInt(st.nextToken());
					x2 = Integer.parseInt(st.nextToken());
					y2 = Integer.parseInt(st.nextToken());
					break;
				default:
					break;
				}
			}

		}

		in.close();
		out.close();
	}

	static class SegmentTree {
		public int x1, y1, x2, y2, min, max;
		public SegmentTree leftUp, leftDown, rigthUp, rigthDown;

		public SegmentTree(int x1, int y1, int x2, int y2) {
			if (x1 >= x2 && y1 >= y2) {
				min = max = A[x1][y2];
			} else {
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
				int midX = ((x2 + x1) / 2);
				int midY = ((y2 + y1) / 2);
				leftUp = new SegmentTree(x1, y1, midX, midY);
				leftDown = new SegmentTree(x1, midY + 1, midX, y2);
				rigthUp = new SegmentTree(midX + 1, y1, x2, midY);
				rigthDown = new SegmentTree(midX + 1, midY + 1, x2, y2);
			}
		}
	}
}
