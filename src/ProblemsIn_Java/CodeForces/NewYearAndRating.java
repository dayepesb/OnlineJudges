package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearAndRating {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int hi = Integer.MAX_VALUE, lo = Integer.MIN_VALUE, n, ci, di, sum;
		n = Integer.parseInt(in.readLine().trim());
		sum = 0;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			ci = Integer.parseInt(st.nextToken());
			di = Integer.parseInt(st.nextToken());
			if (di == 1) {
				lo = Math.max(lo, 1900 - sum);
			} else {
				hi = Math.min(hi, 1899 - sum);
			}
			sum += ci;
		}
		if (hi == Integer.MAX_VALUE)
			out.println("Infinity");
		else if (hi < lo)
			out.println("Impossible");
		else {
			out.println(hi + sum);
		}
		out.close();
		in.close();
	}

}
