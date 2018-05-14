package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class CalculoSimple {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("US", "en"));

		double a, b, c, d;
		StringTokenizer st = new StringTokenizer(in.readLine());
		st.nextToken();
		a = Double.parseDouble(st.nextToken());
		b = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(in.readLine());
		st.nextToken();
		c = Double.parseDouble(st.nextToken());
		d = Double.parseDouble(st.nextToken());
		out.printf("VALOR A PAGAR: R$ %.2f%n", (a * b) + (c * d));

		out.close();
		in.close();
	}
}
