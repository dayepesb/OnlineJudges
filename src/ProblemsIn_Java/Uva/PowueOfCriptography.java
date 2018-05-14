package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class PowueOfCriptography {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			double raiz = in.nextDouble(), num = in.nextDouble();
			System.out.println(Math.round(Math.pow(10, Math.log10(num) / raiz)) );
		}
		in.close();
	}
}
