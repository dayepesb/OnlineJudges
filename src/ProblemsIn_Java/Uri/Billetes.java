package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class Billetes {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("US", "en"));

		int n = Integer.parseInt(in.readLine());

		out.printf("%d\n", n);
		out.printf("%d nota(s) de R$ 100,00\n", n / 100);
		n %= 100;
		out.printf("%d nota(s) de R$ 50,00\n", n / 50);
		n %= 50;
		out.printf("%d nota(s) de R$ 20,00\n", n / 20);
		n %= 20;
		out.printf("%d nota(s) de R$ 10,00\n", n / 10);
		n %= 10;
		out.printf("%d nota(s) de R$ 5,00\n", n / 5);
		n %= 5;
		out.printf("%d nota(s) de R$ 2,00\n", n / 2);
		n %= 2;
		out.printf("%d nota(s) de R$ 1,00\n", n);

		out.close();
		in.close();
	}
}
