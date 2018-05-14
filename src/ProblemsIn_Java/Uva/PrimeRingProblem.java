package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrimeRingProblem {

	static int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

	static int[] output;
	static boolean[] used = new boolean[16];

	static boolean[] primes = { false, false, true, true, false, true, false, true, false, false, false, true, false,
			true, false, false, false, true, false, true, false, false, false, true, false, false, false, false, false,
			true, false, true };

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String input = "";
		int count = 1;
		boolean flg = false;

		while ((input = r.readLine()) != null) {
			int n = Integer.parseInt(input);
			if (flg) {
				out.println();
			}
			flg = true;

			output = new int[n];
			output[0] = 1;
			st = new StringBuilder("");
			prme(1, n);
			out.println("Case " + (count++) + ":");
			out.print(st);
		}
		out.close();
	}

	static StringBuilder st;

	private static void prme(int i, int len) {

		if (i == len) {
			if (primes[output[i - 1] + 1]) {
				for (int l = 0; l < len - 1; l++)
					st.append(output[l] + " ");

				st.append(output[len - 1] + "\n");
			}
			return;
		}

		for (int k = 1; k < len; k++) {
			if (!used[k]) {
				if (primes[input[k] + output[i - 1]]) {

					used[k] = true;
					output[i] = input[k];
					prme(i + 1, len);
					used[k] = false;
				}
			}
		}
	}
}