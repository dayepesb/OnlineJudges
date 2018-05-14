package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class Salario {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("US", "en"));
		in.readLine();
		double c = Double.parseDouble(in.readLine()), d = Double.parseDouble(in.readLine());
		out.printf("TOTAL = R$ %.2f%n", (d * 15 / 100) + c);

		out.close();
		in.close();
	}
}
