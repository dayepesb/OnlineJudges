package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author david yepes buitrago
 * @date 30-07-2017
 * @time 0.402 ms
 */
public class OnionLayers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		double pt[][];
		int n;
		for (String line; !(line = in.readLine().trim()).equals("0");) {
			n = Integer.parseInt(line);
			pt = new double[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Integer.parseInt(st.nextToken());
				double y = Integer.parseInt(st.nextToken());
				pt[i][0] = x;
				pt[i][1] = y;
			}
			int capas = 1;
			while (true) {
				double pt2[][] = convexHullGS(pt, true);
				n -= pt2.length;
				pt = quitarCapa(pt, pt2, n);
				if (n < 3)
					break;
				capas++;
			}
			out.println((capas % 2 == 0) || (n < 3 && n != 0) ? "Do not take this onion to the lab!"
					: "Take this onion to the lab!");
		}

		in.close();
		out.close();
	}

	static double[][] quitarCapa(double pt[][], double pt2[][], int n) {
		TreeSet<String> ts = new TreeSet<>();
		for (double p[] : pt2) {
			ts.add(p[0] + "," + p[1]);
		}
		double res[][] = new double[n][2];
		int t = 0;
		for (double[] p : pt) {
			if (!ts.contains(p[0] + "," + p[1])) {
				res[t][0] = p[0];
				res[t][1] = p[1];
				t++;
			}
		}
		return res;
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
