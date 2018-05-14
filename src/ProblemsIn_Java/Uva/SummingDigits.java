package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SummingDigits {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n;

		n = Integer.parseInt(in.readLine().trim());

		do {
			out.println(sumOfDigit(n));
			n = Integer.parseInt(in.readLine().trim());
		} while (n != 0);

		out.close();
		in.close();
	}

	public static int sumOfDigit(int x) {
		int sum = 0;
		for (int i = x; i != 0; i = i / 10) {
			sum = sum + i % 10;
		}
		if (sum < 10) {
			return sum;
		} else {
			return sumOfDigit(sum);
		}
	}
}
