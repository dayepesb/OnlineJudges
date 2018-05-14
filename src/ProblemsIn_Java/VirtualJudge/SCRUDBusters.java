package ProblemsIn_Java.VirtualJudge;

import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 15-09-2017
 * @time 0.070 ms
 */
public class SCRUDBusters {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		ArrayList<double[][]> reinos = new ArrayList<>();
		int n;
		while ((n = Integer.parseInt(in.readLine().trim())) != -1) {
			double pt[][] = new double[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				pt[i] = new double[] { Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()) };
			}
			reinos.add(convexHullGS(pt, true));
		}

		double area = 0.;
		String line;
		boolean[] vis = new boolean[reinos.size()];
		while ((line = in.readLine())!=null) {
			st = new StringTokenizer(line);
			double x = Double.parseDouble(st.nextToken()), y = Double.parseDouble(st.nextToken());
			for (int i = 0; i < reinos.size(); i++) {
				if (!vis[i])
					if (dentroPoligono(reinos.get(i), new double[] { x, y }, false)) {
						area += area(reinos.get(i));
						vis[i] = true;
					}
			}
		}

		out.printf(Locale.ENGLISH,"%.2f%n", area);

		out.close();
		in.close();
	}

	static double area(double[][] pt) {
		double r = 0d;
		int t = pt.length;
		for (int i = 0, j = 1; i < t; i++, j = j + 1 == t ? 0 : j + 1)
			r += pt[i][0] * pt[j][1] - pt[i][1] * pt[j][0];
		return Math.abs(r) / 2;
	}

	static boolean dentroPoligono(double[][] pt, double[] p, boolean bd) { // bd: con borde?
		for (int i = 0, j = 1, t = pt.length; i < t; i++, j = j + 1 == t ? 0 : j + 1)
			if (Line2D.ptSegDist(pt[i][0], pt[i][1], pt[j][0], pt[j][1], p[0], p[1]) < 1e-11)
				return bd;
		return getShape(pt).contains(p[0], p[1]);
	}

	static Path2D.Double getShape(double[][] pt) {
		Path2D.Double r = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		r.moveTo(pt[0][0], pt[0][1]);
		for (int i = 1; i < pt.length; i++)
			r.lineTo(pt[i][0], pt[i][1]);
		r.closePath();
		return r;
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