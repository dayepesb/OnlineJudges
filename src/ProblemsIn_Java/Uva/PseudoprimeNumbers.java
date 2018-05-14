package ProblemsIn_Java.Uva;

import java.util.*;
import java.io.*;
import java.math.*;

public class PseudoprimeNumbers {
	public static void main(String[] args) {
		long a, p;
		Scanner in = new Scanner(System.in);
		p = in.nextLong();
		a = in.nextLong();
		while (!((a == 0) && (p == 0))) {
			BigInteger A = BigInteger.valueOf(a);
			BigInteger P = BigInteger.valueOf(p);
			BigInteger ans2 = A.modPow(P, P);
			if ((A.equals(ans2)) && !(P.isProbablePrime(10))) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

			p = in.nextLong();
			a = in.nextLong();
		}
	}
}