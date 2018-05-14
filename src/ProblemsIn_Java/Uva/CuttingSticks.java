package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CuttingSticks {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;

		for (String line; !(line = in.readLine().trim()).equals("0");) {
			int stickSize = Integer.parseInt(line);

			int n = Integer.parseInt(in.readLine().trim());
			int[] cuts = new int[n + 2];

			st = new StringTokenizer(in.readLine());
			for (int k = 1; k <= n; k++)
				cuts[k] = Integer.parseInt(st.nextToken());
			cuts[n + 1] = stickSize;

			int m[][] = new int[n + 2][n + 2];

			for (int d = 2; d < cuts.length; d++) {
				for (int i = 0; i < cuts.length - d; i++) {
					int j = d + i;

					int cutMin = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++)
						cutMin = Math.min(cutMin, m[i][k] + m[k][j]);

					m[i][j] = cutMin + cuts[j] - cuts[i];
				}
			}
			out.println("The minimum cutting is " + m[0][n + 1] + ".");
		}

		out.close();
		in.close();
	}
}
