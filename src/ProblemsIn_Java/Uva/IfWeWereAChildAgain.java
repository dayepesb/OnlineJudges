package ProblemsIn_Java.Uva;

import java.math.BigInteger;
import java.util.Scanner;

public class IfWeWereAChildAgain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger a, b;
		int i, n;
		String ch;
		while (in.hasNext()) {
			a = in.nextBigInteger();
			ch = in.next();
			b = in.nextBigInteger();
			if (ch.charAt(0) == '/')
				a = a.divide(b);
			else
				a = a.mod(b);
			System.out.println(a);
		}
	}
}
