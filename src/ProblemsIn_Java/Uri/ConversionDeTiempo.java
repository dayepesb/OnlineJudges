package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class ConversionDeTiempo {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("US", "en"));

		int n = Integer.parseInt(in.readLine());

		int h = n / 3600, m = n % 3600 / 60, s = n % 60;
		out.printf("%d:%d:%d\n", h, m, s);

		out.close();
		in.close();
	}
}
