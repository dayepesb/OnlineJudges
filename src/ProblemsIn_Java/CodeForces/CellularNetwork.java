package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CellularNetwork {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n, m;
		String line = in.readLine();
		StringTokenizer st = new StringTokenizer(line);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		long cities[] = new long[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; ++i)
			cities[i] = Long.parseLong(st.nextToken());

		long towers[] = new long[m];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; ++i)
			towers[i] = Long.parseLong(st.nextToken());

		int j = 0;
		long ans = 0;

		for (int i = 0; i < n; ++i) {
			while (j + 1 < m && Math.abs(cities[i] - towers[j]) >= Math.abs(cities[i] - towers[j + 1]))
				++j;
			ans = Math.max(ans, Math.abs(cities[i] - towers[j]));
		}

		out.printf("%d\n", ans);

		out.close();
		in.close();
	}
}
