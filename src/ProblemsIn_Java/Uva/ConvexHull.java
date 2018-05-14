package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 14-09-2017
 * @time 0.590 ms
 */
public class ConvexHull {
	static double[][] pt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < casos; c++) {
			int n = Integer.parseInt(in.readLine().trim());
			ArrayList<double[]> points = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				if (st.nextToken().equals("Y")) {
					points.add(new double[] { x, y });
				}
			}
			pt = new double[points.size()][2];
			int i = 0;
			for (double[] ds : points) {
				pt[i] = ds;
				i++;
			}
			double resp[][] = convexHullGS(pt, true);
			int index = index(resp);
			out.println(pt.length);
			for (i = index; i < resp.length; i++) {
				out.println(((int)resp[i][0]) + " " + ((int)resp[i][1]));
			}
			for (i = 0; i < index; i++) {
				out.println(((int)resp[i][0]) + " " + ((int)resp[i][1]));
			}
		}

		in.close();
		out.close();
	}

	static int index(double[][] resp) {
		int index = 0;
		double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE;
		for (int i = 0; i < resp.length; i++) {
			if (resp[i][0] < minX) {
				minX = resp[i][0];
				minY = resp[i][1];
				index = i;
			} else if (resp[i][0] == minX) {
				if ((resp[i][1] < minY)) {
					minX = resp[i][0];
					minY = resp[i][1];
					index = i;
				}
			}
		}
		return index;
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
