package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.100 ms
 */

public class BalancedBase3 {

	static int[] res = new int[11];
	static int[] pots = new int[11];

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		pots[10] = 1;
		for (int i = 9; i >= 0; i--)
			pots[i] = pots[i + 1] * 3;
		int t = Integer.parseInt(tec.readLine().trim());
		for (int caso = 0; caso < t; caso++) {
			n = Integer.parseInt(tec.readLine());
			rec(0, 0);
			boolean ini = false;
			for (int i = 0; i < res.length; i++) {
				if (res[i] != 0)
					ini = true;
				if (ini)
					out.print(res[i] == 1 ? "+" : res[i] == -1 ? "-" : 0);
			}
			out.println();
		}
		out.close();
	}

	static int n;

	private static boolean rec(int i, int suma) {
		if (suma == n) {
			for (int j = i; j < res.length; j++)
				res[j] = 0;
			return true;
		}
		if (i == res.length)
			return false;
		res[i] = 0;
		if (rec(i + 1, suma))
			return true;
		res[i] = 1;
		if (rec(i + 1, suma + pots[i]))
			return true;
		res[i] = -1;
		if (rec(i + 1, suma - pots[i]))
			return true;
		return false;
	}
}