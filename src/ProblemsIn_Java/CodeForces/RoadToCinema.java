package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadToCinema {

	static int n, k, s, t;
	static int c[], v[], g[];
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line = in.readLine();
		StringTokenizer st;
		st = new StringTokenizer(line);
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		c = new int[n];
		v = new int[n];
		g = new int[k + 2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			c[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= k; i++) {
			g[i] = Integer.parseInt(st.nextToken());
		}
		g[0] = 0;
		g[k + 1] = s;
		k += 2;

		Arrays.sort(g);
		flag = false;
		long l = 0, r = s * 2, mid;
		while (l < r) {
			mid = (l + r) / 2;
			if (can(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		if (!flag) {
			out.println(-1);
		} else {
			int ans = (int) 1e9 + 10;
			for (int i = 0; i < n; i++) {
				if (v[i] >= l) {
					ans = Math.min(ans, c[i]);
				}
			}
			if (ans == (int) 1e9 + 10) {
				out.println(-1);
			} else {
				out.println(ans);
			}
		}

		out.close();
		in.close();
	}

	static boolean can(long mid) {
		long time = 0;
		for (int i = 1; i < k; ++i) {
			long dix = g[i] - g[i - 1];
			if (dix > mid)
				return false;
			long fv = (mid - dix) * 2;
			long sv = mid - fv;
			if (sv < 0)
				time += dix;
			else
				time += fv / 2 + sv * 2;
		}
		if (time <= t) {
			flag = true;
			return true;
		} else
			return false;
	}
}
