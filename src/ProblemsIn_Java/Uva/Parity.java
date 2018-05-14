package ProblemsIn_Java.Uva;

import java.util.*;

public class Parity {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		while (a != 0) {
			String s = Integer.toBinaryString(a);
			int cont = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					cont++;
				}
			}
			System.out.printf("The parity of %s is %d (mod 2).%n", s, cont);
			a = in.nextInt();
		}
	}
}
