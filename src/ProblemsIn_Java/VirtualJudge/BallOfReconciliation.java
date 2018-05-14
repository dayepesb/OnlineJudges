package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BallOfReconciliation {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n, count, a, b, c, d, i;
		while ((n = Integer.parseInt(in.readLine().trim())) != -1) {
			if (n == 1)
				out.println(1);
			else {
				count = 0;
				for (a = 1; a <= n; a++) {
					i = ((n / a) < a) ? n / a : a;
					for (b = 1; b <= i; b++) {
						if ((n - a * b) % (a + b) == 0) {
							c = (n - a * b) / (a + b);
							if (c <= b)
								count++;
						}
					}
				}
				out.println(count);
			}
		}

		
		out.close();
		in.close();
	}
}
