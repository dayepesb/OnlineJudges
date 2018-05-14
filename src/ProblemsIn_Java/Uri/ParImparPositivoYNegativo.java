package ProblemsIn_Java.Uri;

import java.io.PrintWriter;
import java.util.Scanner;

public class ParImparPositivoYNegativo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int X, even = 0, odd = 0, positive = 0, negative = 0;
		for (int i = 1; i <= 5; i++) {
			X = in.nextInt();
			if (X % 2 == 0) {
				even += 1;
			}
			if (X % 2 != 0) {
				odd += 1;
			}
			if (X > 0) {
				positive += 1;
			}
			if (X < 0) {
				negative += 1;
			}

		}
		out.print(even + " valor(es) par(es)\n");
		out.print(odd + " valor(es) impar(es)\n");
		out.print(positive + " valor(es) positivo(s)\n");
		out.print(negative + " valor(es) negativo(s)\n");

		out.close();
		in.close();
	}

}