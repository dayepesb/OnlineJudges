package ProblemsIn_Java.Uri;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
public class Taxes {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Locale.setDefault(new Locale("eng","US"));
		float n, r, f1, f2, f3;
		n = in.nextFloat();

		if (n <= 2000) {
			out.print("Isento\n");
		} else {
			if (n > 2000 && n <= 3000) {
				f1 = n - 2000;
				f1 = ((f1 * 8) / 100);
				r = f1;
			} else if (n > 3000 && n <= 4500) {
				f1 = n - 2000;
				f2 = f1 - 1000;
				f1 -= f2;
				f1 = ((f1 * 8) / 100);
				f2 = ((f2 * 18) / 100);
				r = f2 + f1;
			} else {
				f1 = n - 2000;
				f2 = f1 - 1000;
				f3 = f2 - 1500;
				f1 -= f2;
				f2 -= f3;
				f1 = ((f1 * 8) / 100);
				f2 = ((f2 * 18) / 100);
				f3 = ((f3 * 28) / 100);
				r = f3 + f2 + f1;
			}
			out.printf("R$ %.2f\n", r);
		}
		out.close();
	}

}