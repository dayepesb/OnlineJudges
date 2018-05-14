package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FormulaDeBhaskara {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			if (Double.isFinite(r1) && Double.isFinite(r2)) {
				out.printf("R1 = %.5f%nR2 = %.5f%n", r1, r2);
			} else {
				out.println("Impossivel calcular");
			}
		}
		in.close();
		out.close();
	}
}
