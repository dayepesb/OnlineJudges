package ProblemsIn_Java.Uva;

import java.util.Scanner;
import java.math.BigInteger;

public class Stripe {
	public static final int MAX_LENGTH = 200;
	private static BigInteger[] factorialArr = new BigInteger[MAX_LENGTH + 1];

	public static void main(String[] args) {
		precomputeFactorial();

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T > 0) {
			int length = sc.nextInt();
			int numBlack = sc.nextInt();
			int lengthBlack = 0;

			for (int i = 0; i < numBlack; i++) {
				int black = sc.nextInt();
				lengthBlack += black;
			}

			int lengthWhite = length - lengthBlack;
			System.out.println((computeCombination(lengthWhite + 1, numBlack)).toString());

			T--;
		}
	}

	private static void precomputeFactorial() {
		factorialArr[0] = BigInteger.ONE;

		for (int ind = 1; ind <= MAX_LENGTH; ind++)
			factorialArr[ind] = factorialArr[ind - 1].multiply(new BigInteger(Integer.toString(ind)));
	}

	private static BigInteger computeCombination(int n, int k) {
		if (n == 0) {
			if (k == 0)
				return BigInteger.ONE;
			return BigInteger.ZERO;
		}

		if (k > n)
			return BigInteger.ZERO;
		if (k == n)
			return BigInteger.ONE;

		return factorialArr[n].divide(factorialArr[k].multiply(factorialArr[n - k]));
	}
}