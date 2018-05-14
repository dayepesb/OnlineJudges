package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ColourFlowers {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (String line; !((line = in.readLine())==null); ) {
			StringTokenizer st = new StringTokenizer(line);
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			// calcular circulo inscrito
			double fp = ((a + b + c) / 2);
			double sp = (fp - a) * (fp - b) * (fp - c);
			double tp = Math.sqrt(fp * sp);
			double ins = Math.PI * (tp / fp) * (tp / fp);
			// calcular triangulo
			double s = (a + b + c) / 2;
			double tri = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			// circulo circunscrito
			double r = (a * b * c) / (4 * tri);
			double cir = (Math.PI * (r) * (r)) - tri;
			tri -= ins;
			out.printf("%.4f %.4f %.4f%n",cir,tri,ins);
		}
		out.close();
		in.close();
	}
}
