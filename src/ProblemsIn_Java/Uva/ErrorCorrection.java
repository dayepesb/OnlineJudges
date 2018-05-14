package ProblemsIn_Java.Uva;

import java.util.*;
import java.io.*;

public class ErrorCorrection {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;

			int[][] mat = new int[N][N];
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j)
					mat[i][j] = Integer.parseInt(stk.nextToken());
			}

			int[] rowSum = new int[N];
			int[] colSum = new int[N];

			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j) {
					rowSum[i] += mat[i][j];
					colSum[i] += mat[j][i];
				}

			int r = -1, c = -1;
			int rowCnt = 0;
			int colCnt = 0;
			for (int i = 0; i < N; ++i) {
				if (rowSum[i] % 2 == 1) {
					r = i;
					++rowCnt;
				}
				if (colSum[i] % 2 == 1) {
					c = i;
					++colCnt;
				}
			}

			if (rowCnt == 0 && colCnt == 0)
				out.println("OK");
			else if (rowCnt > 1 || colCnt > 1)
				out.println("Corrupt");
			else
				out.println("Change bit (" + (r + 1) + "," + (c + 1) + ")");
		}

		in.close();
		out.close();
	}
}