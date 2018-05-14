package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class SimpleCalculations {
	static int n;
	static double a0;
	static double an1;
	static double[] c;
	static double[] mem;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en", "US"));
		int casos = Integer.parseInt(in.readLine().trim());

		while (casos-- > 0) {
			in.readLine();
			n = Integer.parseInt(in.readLine().trim());
			a0 = Double.parseDouble(in.readLine().trim());
			an1 = Double.parseDouble(in.readLine().trim());
			c = new double[n];
			mem = new double[n + 1];
			for (int i = 0; i < c.length; i++) {
				c[i] = Double.parseDouble(in.readLine().trim());
			}
			double s = a0 * n + an1;
			for (int i = n; i >= 1; i--) {
				s -= 2 * (n - i + 1) * c[i - 1];
			}
			out.println(String.format("%.2f", s / (n + 1)));
			if (casos != 0)
				out.println();
		}
		out.close();
		in.close();
	}
}