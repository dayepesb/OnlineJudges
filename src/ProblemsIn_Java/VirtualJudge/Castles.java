package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 26-01-2018
 * @time 0.222 ms
 */
public class Castles {
	static int mAdy[][], visit[], grade[], n, status;
	static edge[] c;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		for (int cs = 0; (n = Integer.parseInt(in.readLine().trim())) != 0;) {
			c = new edge[n];
			grade = new int[n];
			visit = new int[n];
			mAdy = new int[n][n];
			for (int i = 0; i < n; grade[i++] = 0) {
				st = new StringTokenizer(in.readLine());
				int j = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
				c[i] = new edge(Math.max(j, k), k);
			}
			for (int k = 0; k < n - 1; ++k) {
				st = new StringTokenizer(in.readLine());
				int i = Integer.parseInt(st.nextToken()) - 1;
				int j = Integer.parseInt(st.nextToken()) - 1;
				mAdy[i][grade[i]++] = j;
				mAdy[j][grade[j]++] = i;
			}
			edge ans, e;
			int i;
			status = 0;
			for (ans = new edge(536870912, 536870912), i = 0; i < n; ++i) {
				++status;
				e = solution(i);
				if (less(e, ans))
					ans = e;
			}
			out.printf("Case %d: %d\n", ++cs, ans.a);
		}

		in.close();
		out.close();
	}

	static boolean less(edge x, edge y) {
		if (x.a == y.a)
			return x.b < y.b;
		return x.a < y.a;
	}

	static edge solution(int x) {
		int i, y, l = 0, k = 0, aa, bb;
		for (i = 0; i < grade[x]; ++i)
			if (visit[mAdy[x][i]] != status)
				++l;
		edge[] B = new edge[l];
		for (visit[x] = status, i = 0; i < grade[x] && (y = mAdy[x][i]) >= 0; ++i)
			if (visit[y] != status)
				B[k++] = solution(y);
		for (Arrays.sort(B), aa = c[x].a, bb = c[x].b, i = 0; i < k; ++i) {
			aa = Math.max(aa, bb + B[i].a);
			bb += B[i].b;
		}
		return new edge(Math.max(aa, bb), bb);
	}

	static class edge implements Comparable<edge> {
		int a, b;

		public edge(int a, int g) {
			this.a = a;
			this.b = g;
		}

		@Override
		public int compareTo(edge other) {
			if (this.a == other.a)
				return this.b < other.b ? -1 : 1;
			return this.a > other.a ? -1 : 1;
		}
	}
}
