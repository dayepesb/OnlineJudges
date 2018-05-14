package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LongestCommonSubsequence {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringBuffer sb = new StringBuffer("");
		String m = "", h = "";
		while ((m = in.readLine()) != null) {
			h = in.readLine();
			int x = LCS(m, h, new int[10][10]);
			sb.append(x).append("\n");
		}
		out.print(sb);
		in.close();
		out.close();
	}

	static int LCS(String m, String n, int[][] arr) {
		arr = new int[m.length() + 1][n.length() + 1];
		for (int i = 0; i < m.length() + 1; i++)
			arr[i][0] = 0;
		for (int i = 0; i < n.length() + 1; i++)
			arr[0][i] = 0;
		for (int i = 0; i < m.length(); i++) {
			for (int j = 0; j < n.length(); j++) {
				if (m.charAt(i) == n.charAt(j))
					arr[i + 1][j + 1] = arr[i][j] + 1;
				else
					arr[i + 1][j + 1] = Math.max(arr[i + 1][j], arr[i][j + 1]);
			}
		}
		return arr[m.length()][n.length()];
	}
}
