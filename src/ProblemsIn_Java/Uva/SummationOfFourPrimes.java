package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 11-09-2017
 * @time 0.080 ms
 */
public class SummationOfFourPrimes {
	static int[] primes = new int[446];
	static boolean[] isPrime = new boolean[3162];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		preLoad();
		for (String line; (line = in.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			if (n < 8)
				out.println("Impossible.");
			else if (n % 2 == 0) {
				int[] sp = split(n - 4);
				out.println("2 2 " + sp[0] + " " + sp[1]);
			} else {
				int[] sp = split(n - 5);
				out.println("2 3 " + sp[0] + " " + sp[1]);
			}
		}

		in.close();
		out.close();
	}

	static void preLoad() {
		for (int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;

		for (int i = 2; i * i < isPrime.length; i++)
			if (isPrime[i])
				for (int j = 2 * i; j < isPrime.length; j += i)
					isPrime[j] = false;

		int p = 0;
		for (int i = 0; i < isPrime.length; i++)
			if (isPrime[i])
				primes[p++] = i;
	}

	static int[] split(int n) {
		for (int p : primes)
			if (isPrime(n - p))
				return new int[] { p, n - p };
		return null;
	}

	static boolean isPrime(int n) {
		if (n < isPrime.length)
			return isPrime[n];
		for (int i = 2; i <= (int) (Math.sqrt(n) + 1); i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
