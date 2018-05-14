package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 15-09-2017
 * @time 0.050 ms
 */
public class Polygon {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		double pt[][];
		int n;
		while ((n = Integer.parseInt(in.readLine().trim())) != 0) {
			pt = new double[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				pt[i][0] = Double.parseDouble(st.nextToken());
				pt[i][1] = Double.parseDouble(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			double p[] = new double[] { Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()) };
			out.println((dentroPoligono(pt, p, true)) ? "T" : "F");
		}

		in.close();
		out.close();
	}

	static boolean dentroPoligono(double[][] pt, double[] p, boolean bd) { // bd: con
		// borde?
		boolean b = false;
		for (int i = 0, j = 1, t = pt.length; i < t; i++, j = j + 1 == t ? 0 : j + 1) {
			if (distPS(pt[i], pt[j], p) < 1e-11)
				return bd;
			if (((pt[j][1] <= p[1] && p[1] < pt[i][1]) || (pt[i][1] <= p[1] && p[1] < pt[j][1]))
					&& (p[0] - pt[j][0] < (p[1] - pt[j][1]) * (pt[i][0] - pt[j][0]) / (pt[i][1] - pt[j][1])))
				b = !b;
		}
		return b;
	}

	static double distPS(double[] p1, double[] p2, double[] p) {
		double dP = ds(p1, p2), d1 = ds(p1, p), d2 = ds(p2, p);
		return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPL(p1, p2, p);
	}

	static double ds(double[] a, double[] b) {
		return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
	}

	static double distPL(double[] p1, double[] p2, double[] p) {
		return Math.abs((p2[0] - p1[0]) * (p1[1] - p[1]) - (p2[1] - p1[1]) * (p1[0] - p[0])) / Math.sqrt(ds(p1, p2));
	}

}
