package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author david yepes buitrago
 * @date 17-10-2017
 * @time 0.000 ms
 */
public class StringPartition {
	static String string;
	static long mem[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int tc = Integer.parseInt(in.readLine().trim());
		while (tc-- > 0) {
			string = in.readLine().trim();
			mem = new long[string.length() + 1];
			Arrays.fill(mem, -1);
			out.println(dinamic(0));
		}

		in.close();
		out.close();
	}

	static long dinamic(int i) {
		if (mem[i] != -1)
			return mem[i];
		if (i >= string.length()) {
			return mem[i] = 0;
		}
		if (string.charAt(i) == '0')
			return mem[i] = dinamic(i + 1);

		int k = 1, j;
		long ans = 0, pref;
		while (true) {
			pref = 0;
			for (j = i; (j < i + k); j++) {
				pref = pref * 10 + (string.charAt(j) - '0');
			}
			if (pref > Integer.MAX_VALUE)
				break;

			ans = Math.max(ans, pref + dinamic(i + k));
			k++;

			if (i + k > string.length())
				break;
		}

		return mem[i] = ans;
	}

}
