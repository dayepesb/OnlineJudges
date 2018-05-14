package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JustInTime {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		long num = Long.parseLong(in.readLine().trim());
		long res = primo(num);
		out.println(res);

		out.close();
		in.close();
	}

	private static long primo(long num) {
		while (true) {
			if (isPrime(num))
				break;
			num--;
		}
		return num;
	}

	private static boolean isPrime(long num) {
		if ((num & 1) == 0 && (num != 2) || num == 1)
			return false;
		for (int i = 3; i <= Math.sqrt(num); i += 2)
			if (num % i == 0)
				return false;
		return true;
	}
}
