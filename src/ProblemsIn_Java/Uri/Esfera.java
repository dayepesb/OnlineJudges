package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class Esfera {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("US", "en"));
		double c = Double.parseDouble(in.readLine());
		out.printf("VOLUME = %.3f%n", (4.0 / 3) * 3.14159 * c * c * c);

		out.close();
		in.close();
	}
}
