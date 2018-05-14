package ProblemsIn_Java.Competencias.Camus20171101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SaintJohnFestival {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		double L[][], S[][];
		String line;
		StringTokenizer st;
		while ((line = in.readLine()) != null) {
			int lPoints = Integer.parseInt(line.trim());
			L = new double[lPoints][2];
			for (int i = 0; i < lPoints; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				L[i][0] = x;
				L[i][1] = y;
			}
			int sPoints = Integer.parseInt(in.readLine().trim());
			S = new double[sPoints][2];
			for (int i = 0; i < sPoints; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				S[i][0] = x;
				S[i][1] = y;
			}
			L = convexHullGS(L, true);
			int cont = 0;
			for (double[] point : S) {
				if (dentroPoligono(L, point, true)) {
					cont++;
				}
			}
			out.println(cont);
		}

		out.close();
		in.close();
	}

	static boolean dentroPoligono(double[][] pt, double[] p, boolean bd) { // bd: con borde?
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

	static double ds(double[] a, double[] b) {
		return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
	}

	static double distPL(double[] p1, double[] p2, double[] p) {
		return Math.abs((p2[0] - p1[0]) * (p1[1] - p[1]) - (p2[1] - p1[1]) * (p1[0] - p[0])) / Math.sqrt(ds(p1, p2));
	}

	static double distPS(double[] p1, double[] p2, double[] p) {
		double dP = ds(p1, p2), d1 = ds(p1, p), d2 = ds(p2, p);
		return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPL(p1, p2, p);
	}

	static int sgn(double x) {
		return Math.abs(x) > 9.9e-12 ? (x < 0 ? -1 : 1) : 0;
	}

	static double cruz(double[] a, double[] b) {
		return a[0] * b[1] - a[1] * b[0];
	}

	static double cruz(double[] a, double[] b, double[] c) {
		return cruz(a, b) + cruz(b, c) + cruz(c, a);
	}

	static double[][] convexHullGS(double[][] pt, boolean bd) { // bd: con borde?
		int h = pt.length, i = h, t = 0;
		double v[] = null, w[], r[][] = new double[h][];
		for (double[] p : pt)
			if (v == null || p[1] < v[1] || (p[1] == v[1] && p[0] > v[0]))
				v = p;
		v = v.clone();
		for (double[] p : pt) {
			p[0] -= v[0];
			p[1] -= v[1];
		}
		Arrays.sort(pt, new Comparator<double[]>() {
			public int compare(double[] a, double[] b) {
				double cz = cruz(b, a);
				return sgn(sgn(cz) != 0 ? cz : a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
			}
		});
		if (bd)
			while (i - 1 >= 0 && cruz(pt[h - 1], pt[i - 1]) == 0)
				i--;
		if (bd)
			for (int k = i; k < (i + h) / 2; k++) {
				w = pt[k];
				pt[k] = pt[h - 1 - k + i];
				pt[h - 1 - k + i] = w;
			}
		for (double[] p : pt) {
			while (t >= 2 && sgn(cruz(r[t - 1], p, r[t - 2])) < (bd ? 0 : 1))
				t--;
			r[t++] = p;
		}
		for (double[] p : pt) {
			p[0] += v[0];
			p[1] += v[1];
		}
		return Arrays.copyOfRange(r, 0, t);
	}
}
