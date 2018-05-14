package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Headshot {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line;
		while ((line = in.readLine()) != null) {
			int zero = 0, czero = 0;
			int n = line.length();
			for (int i = 0; i < n; i++) {
				if (line.charAt(i) == '1') {
					continue;
				}
				zero++;
				if (line.charAt((i + 1) % n) == '0') {
					czero++;
				}
			}
			if (czero * n == zero * zero) {
				out.println("EQUAL");
			} else if (czero * n > zero * zero) {
				out.println("SHOOT");
			} else {
				out.println("ROTATE");
			}
		}

		out.close();
		in.close();
	}
}
