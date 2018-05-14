package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bingo {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		while (true) {
			String line = in.readLine();
			st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (N == 0 && B == 0)
				break;

			int[] bingo = new int[B];
			boolean[] found = new boolean[N + 1];
			line = in.readLine();
			st = new StringTokenizer(line);

			for (int i = 0; i < B; ++i)
				bingo[i] = Integer.parseInt(st.nextToken());

			found[0] = true;
			boolean ok = true;

			for (int i = 0; i < B; ++i)
				for (int j = i + 1; j < B; ++j) {
					int diff = Math.abs(bingo[i] - bingo[j]);
					if (diff <= N)
						found[diff] = true;
				}

			for (int i = 0; i <= N; ++i)
				ok &= found[i];

			out.println(ok ? "Y" : "N");
		}

		out.close();
		in.close();
	}
}
