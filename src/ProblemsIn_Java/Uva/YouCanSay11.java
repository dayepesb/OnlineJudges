package ProblemsIn_Java.Uva;

import java.math.BigInteger;
import java.util.Scanner;

public class YouCanSay11 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		final BigInteger eleven = new BigInteger("11");

		String input = in.next();
		while (!input.equals("0")) {
			BigInteger X = new BigInteger(input);
			BigInteger modded = X.mod(eleven);

			if (modded.equals(BigInteger.ZERO))
				System.out.printf("%s is a multiple of 11.\n", input);
			else
				System.out.printf("%s is not a multiple of 11.\n", input);

			input = in.next();
		}
	}
}