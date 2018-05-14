package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TheTwinTowers {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		long casos = 1;
		while (true) {
			h = new HashMap<>();
			StringTokenizer st = new StringTokenizer(tec.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			;
			if (a == 0 && b == 0)
				break;
			long[] x = new long[a];
			long[] y = new long[b];
			st = new StringTokenizer(tec.readLine());
			for (int i = 0; i < x.length; i++)
				x[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(tec.readLine());
			for (int i = 0; i < y.length; i++)
				y[i] = Long.parseLong(st.nextToken());
			int res = resolver(x, y, 0, 0);
			out.println("Twin Towers #" + casos++);
			out.println("Number of Tiles : " + res + "\n");
		}
		out.close();
	}

	static HashMap<String, Integer> h = new HashMap<>();

	private static int resolver(long[] x, long[] y, int i, int j) {
		String l = i + " " + j;
		if (h.containsKey(l))
			return h.get(l);
		int res = 0;
		if (i == x.length || j == y.length) {
			h.put(i + " " + j, 0);
			return 0;
		}
		if (x[i] == y[j]) {
			res = Math.max(1 + resolver(x, y, i + 1, j + 1),
					Math.max(resolver(x, y, i + 1, j), resolver(x, y, i, j + 1)));
			h.put(i + " " + j, res);
			return res;
		}
		res = Math.max(resolver(x, y, i + 1, j), resolver(x, y, i, j + 1));
		h.put(i + " " + j, res);
		return res;
	}

}
