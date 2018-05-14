package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AnnoyingPaintingTool {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, m, r, c, i, j, I, J, k, l, ans;
		char a[][];

		while (true) {
			String line = in.readLine().trim();
			if (line.equals("0 0 0 0"))
				break;
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			a = new char[n + 1][n + 1];

			for (i = 0; i < n; ++i) {
				a[i] = in.readLine().toCharArray();
			}

			I = n - r + 1;
			J = m - c + 1;
			ans = 0;
			for (i = 0; i < I; ++i) {
				for (j = 0; j < J; ++j) {
					if (a[i][j] == '1') {
						for (l = 0; l < r; ++l) {
							for (k = 0; k < c; ++k) {
								boolean aux;
								if (a[i + l][j + k] == '1') {
									aux = true;
								} else {
									aux = false;
								}
								aux ^= true;
								if (aux) {
									a[i + l][j + k] = '1';
								} else {
									a[i + l][j + k] = '0';
								}
							}
						}
						++ans;
					}
				}
			}

			Ciclo: for (i = 0; i < n; ++i) {
				for (j = 0; j < m; ++j) {
					if (a[i][j] == '1') {
						ans = -1;
						break Ciclo;
					}
				}
			}
			out.println(ans);

		}

		out.close();
		in.close();
	}
}
