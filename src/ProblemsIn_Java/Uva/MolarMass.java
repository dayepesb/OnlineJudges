package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class MolarMass {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en"));
		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 0; k < casos; k++) {
			String line = in.readLine().trim();
			double sum = 0.0;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				int n = 0;
				if (i + 1 < line.length() && Character.isDigit(line.charAt(i + 1))) {
					if (i + 2 < line.length() && Character.isDigit(line.charAt(i + 2))) {
						n = Integer.parseInt(line.charAt(i + 1) + "" + line.charAt(i + 2));
						i += 2;
					} else {
						n = Integer.parseInt(line.charAt(i + 1) + "");
						i += 1;
					}
				} else {
					n = 1;
				}
				switch (c) {

				case 'C':
					sum += 12.01 * n;
					break;
				case 'H':
					sum += 1.008 * n;
					break;
				case 'O':
					sum += 16.00 * n;
					break;
				case 'N':
					sum += 14.01 * n;
					break;

				}
			}
			System.out.printf("%.3f%n", sum);
		}

		out.close();
		in.close();
	}
}
