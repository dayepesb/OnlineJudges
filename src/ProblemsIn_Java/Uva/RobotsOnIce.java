package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 16-11-2017
 * @time 0.000 ms
 */
public class RobotsOnIce {
	static int R, C, r1, c1, r2, c2, r3, c3, s1, s2, s3, roads, movX[] = { -1, 1, 0, 0 }, movY[] = { 0, 0, -1, 1 },
			testCase;
	static boolean mAdy[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		testCase = 1;
		while (true) {
			st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (R == C & C == 0)
				break;
			st = new StringTokenizer(in.readLine());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r3 = Integer.parseInt(st.nextToken());
			c3 = Integer.parseInt(st.nextToken());
			mAdy = new boolean[R][C];
			s1 = (R * C) / 4;
			s2 = (R * C) / 2;
			s3 = (3 * R * C) / 4;
			roads = 0;
			mAdy[0][0] = true;
			solve(0, 0, 1);
			out.printf("Case %d: %d%n", testCase++, roads);
		}

		in.close();
		out.close();
	}

	public static void solve(int x, int y, int iter) {
		if (x == 0 && y == 1) {
			if (iter == R * C)
				roads++;
			return;
		}
		if (x == r1 && y == c1 && iter != s1)
			return;
		if (x == r2 && y == c2 && iter != s2)
			return;
		if (x == r3 && y == c3 && iter != s3)
			return;
		if ((x != r1 || y != c1) && iter == s1)
			return;
		if ((x != r2 || y != c2) && iter == s2)
			return;
		if ((x != r3 || y != c3) && iter == s3)
			return;

		if (iter < s1 && distance(x, y, r1, c1) > (s1 - iter))
			return;
		if (iter < s2 && distance(x, y, r2, c2) > (s2 - iter))
			return;
		if (iter < s3 && distance(x, y, r3, c3) > (s3 - iter))
			return;

		int urgent = 0, index = -1;
		for (int k = 0; k < movX.length; k++) {
			int r = x + movX[k], c = y + movY[k];
			if (!valid(r, c, R, C))
				continue;
			if (mAdy[r][c] || (r == 0 && c == 1))
				continue;
			int next = 0;
			for (int i = 0; i < movX.length; i++) {
				int nr = r + movX[i], nc = c + movY[i];
				if (!valid(nr, nc, R, C) || mAdy[nr][nc])
					continue;
				next++;
			}
			if (next == 0)
				return;
			if (next == 1) {
				urgent++;
				index = k;
			}
		}

		if (urgent > 1)
			return;
		else if (urgent == 1) {
			mAdy[x + movX[index]][y + movY[index]] = true;
			solve(x + movX[index], y + movY[index], iter + 1);
			mAdy[x + movX[index]][y + movY[index]] = false;
			return;
		}

		for (int k = 0; k < movX.length; k++) {
			int r = x + movX[k], c = y + movY[k];
			if (!valid(r, c, R, C) || mAdy[r][c])
				continue;
			mAdy[r][c] = true;
			solve(r, c, iter + 1);
			mAdy[r][c] = false;
		}

	}

	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static boolean valid(int x, int y, int X, int Y) {
		return x >= 0 && x < X && y >= 0 && y < Y;
	}

}
