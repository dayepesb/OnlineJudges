package ProblemsIn_Java.NoteBook;

import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProgramacionDinamica {
	class cortarndoPalos {
		void solucion() {
			int stickSize = 10;// tama�o del palo

			int n = 9;// numero de cortes
			int cuts[] = new int[n + 1];

			// llenar el arreglo
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
		}
	}

	class parentizacionRecusiva {
		int d[], dp[][], prev[][];
		PrintWriter out = new PrintWriter(System.out);

		int parentizacion(int a, int b) {
			int ret = dp[a][b];
			if (ret != Integer.MAX_VALUE)
				return ret;
			if (a == b)
				return ret = 0;
			for (int k = a; k < b; k++) {
				int cost = d[a - 1] * d[k] * d[b] + parentizacion(a, k) + parentizacion(k + 1, b);
				if (ret == Integer.MAX_VALUE || cost < ret) {
					ret = cost;
					prev[a][b] = k;
				}
			}
			return ret;
		}

		void construir(int a, int b) {
			if (a == b)
				out.printf("A%d", a);
			else {
				out.printf("(");
				construir(a, prev[a][b]);
				out.printf(" x ");
				construir(prev[a][b] + 1, b);
				out.printf(")");
			}
		}

	}

	class LCP {
		int longestCommonSubstring1(String a, String b) {
			int m = a.length();
			int n = b.length();

			int max = 0;

			int[][] dp = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (a.charAt(i) == b.charAt(j)) {
						if (i == 0 || j == 0) {
							dp[i][j] = 1;
						} else {
							dp[i][j] = dp[i - 1][j - 1] + 1;
						}

						if (max < dp[i][j])
							max = dp[i][j];
					}

				}
			}

			return max;
		}

		int longestCommonSubstring2(String s, String t) {
			int m = s.length();
			int n = t.length();

			int LCSuff[][] = new int[m + 1][n + 1];
			int result = 0; // To store length of the longest common substring

			/* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == 0 || j == 0)
						LCSuff[i][j] = 0;
					else if (s.charAt(i - 1) == t.charAt(j - 1)) {
						LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
						result = Math.max(result, LCSuff[i][j]);
					} else
						LCSuff[i][j] = 0;
				}
			}
			return result;
		}

	}
}
