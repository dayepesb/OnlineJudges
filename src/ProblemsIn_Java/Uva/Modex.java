package ProblemsIn_Java.Uva;

import java.math.BigInteger;
import java.util.Scanner;

public class Modex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		while (tc > 0) {
			BigInteger x = in.nextBigInteger();
			BigInteger y = in.nextBigInteger();
			BigInteger n = in.nextBigInteger();
			System.out.println(x.modPow(y, n));
			tc--;
		}
	}
}
