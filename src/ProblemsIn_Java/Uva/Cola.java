package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Cola {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line;
		while ((line = in.readLine())!=null) {
			int n = Integer.parseInt(line);
			out.println(countBottles(n));
		}

		out.close();
		in.close();
	}

	private static int countBottles(int n) {
		int count = n;

		while (n >= 3) {
			count += n / 3;
			n = n / 3 + n % 3;
		}

		if (n == 2) {
			count += 1;
		}

		return count;
	}
}