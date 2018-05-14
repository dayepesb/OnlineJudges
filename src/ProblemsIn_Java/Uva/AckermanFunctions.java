package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.000 ms
 */
public class AckermanFunctions {

	private final static int MaxValue = 1000000;
	private final static long[] memo = new long[MaxValue];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			st = new StringTokenizer(line);
			long from1 = Integer.parseInt(st.nextToken());
			long to1 = Integer.parseInt(st.nextToken());
			long from = Math.min(from1, to1);
			long to = Math.max(from1, to1);
			long maxValue = from;
			long maxLength = 0;

			for (long i = from; i <= to; i++) {
				long length = computeCycleLength(nextAckermannNumber(i));
				if (maxLength < length) {
					maxValue = i;
					maxLength = length;
				}
			}

			out.println(String.format("Between %d and %d, %d generates the longest sequence of %d values.", from, to,
					maxValue, maxLength));

		}

		in.close();
		out.close();
	}

	private static long computeCycleLength(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n < MaxValue && memo[(int) n] != 0)
			return memo[(int) n];
		long len = 1 + computeCycleLength(nextAckermannNumber(n));
		if (n < MaxValue)
			memo[(int) n] = len;
		return len;
	}

	public static long nextAckermannNumber(long n) {
		if (n % 2 == 0)
			return n / 2;
		else
			return n * 3 + 1;
	}

}
