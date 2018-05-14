package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class Promedio1 {
	public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale("eng", "US"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine()) != null;) {
			double x = Double.parseDouble(line);
			double y = Double.parseDouble(in.readLine());
			out.printf("MEDIA = %.5f%n", (0.35 * 10 * x / 11) + (0.75 * 10 * y / 11));
		}
		in.close();
		out.close();
	}
}
