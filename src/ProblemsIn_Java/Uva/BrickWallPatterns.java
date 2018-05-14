package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrickWallPatterns {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		Ciclo: while (true) {
			long s = Long.parseLong(in.readLine());
			if (s == 0) {
				break Ciclo;
			}
			out.println(F(s));
		}

		out.close();
		in.close();
	}

	public static long F(long n) {
		if (n <= 1) {
			return 1;
		}
		return F(n - 1) + F(n - 2);
	}
}
