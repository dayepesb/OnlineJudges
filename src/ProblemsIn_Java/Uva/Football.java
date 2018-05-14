package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 23-08-2017
 * @time 0.290 ms
 */
public class Football {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, g;
		int i, lose[];
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			lose = new int[105];
			int points = 0;
			for (i = 1; i <= n; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a > b)
					points += 3;
				else if (a == b) {
					if (g > 0) {
						points += 3;
						g--;
					} else
						points++;
				} else
					lose[b - a]++;
			}
			if (g > 0) {
				for (i = 1; i < 102; i++) {
					while (g >= i && lose[i] > 0) {
						if (g > i) {
							points += 3;
							g -= i + 1;
						} else {
							points++;
							g -= i;
						}
						lose[i]--;
					}
				}
			}
			out.println(points);
		}
		in.close();
		out.close();
	}
}
