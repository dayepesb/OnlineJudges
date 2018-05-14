package ProblemsIn_Java.ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PandigitalFibonacci {
    public static int A;
	public static void main(String[] args) throws Exception {
		System.out.println(Long.MAX_VALUE);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(System.out);

		long fn2 = 1;
		long fn1 = 1;
		long fn;

		long cut = 1000000000;

		int n = 2;
		boolean find = false;

		while (!find) {
			n++;
			fn = (fn1 + fn2) % cut;
			fn2 = fn1;
			fn1 = fn;

			if (acepted(fn)) {
				double t = (n * 0.20898764024997873 - 0.3494850021680094);
				long pandigital = (long) Math.pow(10, t - (long) t + 8);
				if (acepted(pandigital))
					find = true;
			}
		}

		out.println(n);

		out.close();
		in.close();
	}

	static boolean acepted(long n) {
		int digits = 0;
		int count = 0;
		int tmp;

		while (n > 0) {
			tmp = digits;
			digits = digits | 1 << (int) ((n % 10) - 1);
			if (tmp == digits) {
				return false;
			}

			count++;
			n /= 10;
		}
		return digits == (1 << count) - 1;
	}

}
