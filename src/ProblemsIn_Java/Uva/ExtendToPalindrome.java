package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExtendToPalindrome {

	static final long MOD = 2096725343;
	static final long BASE = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line = in.readLine()) != null;) {
			int n = line.trim().length();
			int l = n - 1;
			long h1 = 0;
			long h2 = 0;
			long cbase = 1;
			int best = 0;
			for (int j = l; j >= 0; j--) {
				h2 = (h2 * BASE + line.charAt(j)) % MOD;
				h1 = (h1 + line.charAt(j) * cbase) % MOD;
				if (h1 == h2)
					best = n - j;
				cbase = (cbase * BASE) % MOD;
			}
			out.print(line);
			for (int i = (n-best)-1; i >= 0; i--) {
				out.print(line.charAt(i));
			}
			out.println();
		}

		out.close();
		in.close();
	}
}