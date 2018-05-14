package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 02-08-2017
 * @time 0.000 ms
 */
public class Staircases {
	static BigInteger memo[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		 BigInteger n = new BigInteger(in.readLine().trim());
		memo = new BigInteger[501][501];
		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) {
				memo[i][j] = new BigInteger("-1");
			}
		}
		int sol = Integer.parseInt(solve(n, n.subtract(new BigInteger("-1"))).toString());
		System.out.println(sol);

		in.close();
		out.close();
	}

	/**
	 * @param n
	 * @param m
	 */
	static BigInteger solve(BigInteger n, BigInteger m) {
		if (n.toString().trim().equals("0"))
			return BigInteger.ONE;
		if (m.toString().trim().equals("0"))
			return BigInteger.ZERO;

		BigInteger ret = memo[Integer.parseInt(n.toString())][Integer.parseInt(m.toString())];

		if (ret.toString().trim().equals("-1")) {
			int n1 = Integer.parseInt(n.toString());
			int m1 = Integer.parseInt(m.toString());
			if (n1 >= m1) {
				ret = solve(new BigInteger((n1 - m1) + ""), new BigInteger((m1 - 1) + ""));
			} else {
				ret = BigInteger.ZERO;
			}
			ret = ret.add(solve(n, new BigInteger((m1 - 1) + "")));
		}
		return ret;

	}
}
