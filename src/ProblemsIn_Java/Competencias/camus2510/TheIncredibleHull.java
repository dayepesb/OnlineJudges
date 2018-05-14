package ProblemsIn_Java.Competencias.camus2510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TheIncredibleHull {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = in.readLine();
		while (true) {
			if (s.equals("END"))
				break;
			String name = s.substring(2);
			StringTokenizer st;
			ArrayList<double[]> pts = new ArrayList<>();
			s = in.readLine();
			while (s.startsWith("P")) {
				st = new StringTokenizer(s);
				st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				double[][] m = new double[n][];
				for (int i = 0; i < n; i++) {
					double x = Integer.parseInt(st.nextToken());
					double y = Integer.parseInt(st.nextToken());
					m[i] = new double[] { x, y };
				}
				m = convexHullGS(m, false);
				for (double[] ds : m)
					pts.add(ds);
				s = in.readLine();
			}
			double[][] pt = new double[pts.size()][2];
			for (int i = 0; i < pts.size(); i++)
				pt[i] = pts.get(i);
			double[][] ch = convexHullGS(pt, true);
			// ch puntos
			int ind = 0;
			for (int i = 0; i < ch.length; i++) {
				if (ch[i][0] > ch[ind][0])
					ind = i;
				if (ch[i][0] == ch[ind][0] && ch[i][1] < ch[ind][1])
					ind = i;
			}
			out.println(name + " convex hull:");
			for (int punto = 0; punto < ch.length; punto++)
				out.print(" (" + (int) ch[(ind + punto) % ch.length][0] + "," + (int) ch[(ind + punto) % ch.length][1]
						+ ")");
			out.println();
		}
		out.close();
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

	static double[][] convexHullGS(double[][] pt, boolean bd) {
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
