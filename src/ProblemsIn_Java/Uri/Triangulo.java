package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Triangulo {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(new Locale("eng","US"));
		BufferedReader inAux = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(inAux);
		PrintWriter out = new PrintWriter(System.out);
		double a = in.nextDouble(), b = in.nextDouble(), c = in.nextDouble(), perm, area;
		if (a + b > c && b + c > a && a + c > b) {
			perm = a + b + c;
			out.printf("Perimetro = %.1f\n", perm);
		} else {
			area = .5 * (a + b) * c;
			out.printf("Area = %.1f\n", area);
		}

		out.close();
		in.close();
	}
}