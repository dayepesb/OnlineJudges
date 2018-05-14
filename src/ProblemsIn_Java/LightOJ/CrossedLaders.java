package ProblemsIn_Java.LightOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.164 ms
 */
public class CrossedLaders {
	static double e = 1e-9;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.readLine().trim());
		for (int caso = 1; caso <= n; caso++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			double[] arr = { a, b };
			Arrays.sort(arr);
			a = arr[0];
			b = arr[1];
			double aa = 0.;
			double bb = a;
			double sol = 0.;
			for (int it = 0; it < 1000; it++) {
				double p = (aa + bb) / 2.;
				double anguloA = Math.atan2(c, p);
				double x = Math.cos(anguloA) * a;
				sol = x;
				double y = Math.sin(anguloA) * a;
				double angulo2 = Math.atan2(c, -(x - p));
				if (x + Math.cos(angulo2) * b > 0) {
					bb = p;
				} else
					aa = p;

			}
			out.println("Case " + caso + ": " + sol);
		}
		out.close();
	}
}
