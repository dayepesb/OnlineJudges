package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlyonaYMex {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n, m;
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			StringTokenizer st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int ans = (int) 100010, l, r;
			while (m != 0) {
				st = new StringTokenizer(in.readLine());
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				ans = Math.min(ans, r - l + 1);
				m--;
			}
			out.println(ans);
			int cont = 0;
			out.printf("%d", cont);
			cont++;
			cont %= ans;
			for (int i = 2; i <= n; ++i) {
				out.printf(" %d", cont);
				cont++;
				cont %= ans;
			}
			out.printf("\n");
		}

		out.close();
		in.close();
	}
}
