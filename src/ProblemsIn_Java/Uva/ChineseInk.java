package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChineseInk {
	static int set[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line;
		ArrayList<double[][]> poligons;
		while (!(line = in.readLine().trim()).equals("0")) {
			int poligonos = Integer.parseInt(line);
			StringTokenizer st;
			poligons = new ArrayList<>();
			for (int c = 0; c < poligonos; c++) {
				st = new StringTokenizer(in.readLine());
				double[][] points = new double[st.countTokens() / 2][2];
				int i = 0;
				while (st.hasMoreTokens()) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					points[i][0] = x;
					points[i][1] = y;
					i++;
				}
				poligons.add(points);
			}

			set = new int[poligonos];
			Arrays.fill(set, -1);

			for (int i = 0; i < poligonos; i++) {
				for (int j = i + 1; j < poligonos; j++) {
					if (find(i) != find(j)) {
						double poligono1[][] = poligons.get(i);
						double poligono2[][] = poligons.get(j);
						Ciclo: for (int i1 = 1; i1 < poligono1.length; i1++) {
							for (int j2 = 1; j2 < poligono2.length; j2++) {
								// puntos del poligono 1
								double x1 = poligono1[i1 - 1][0];
								double y1 = poligono1[i1 - 1][1];
								double x2 = poligono1[i1][0];
								double y2 = poligono1[i1][1];
								// puntos de la linea del poligono 2
								double x3 = poligono2[j2 - 1][0];
								double y3 = poligono2[j2 - 1][1];
								double x4 = poligono2[j2][0];
								double y4 = poligono2[j2][1];

								double sol[] = intSegmentos(x1, y1, x2, y2, x3, y3, x4, y4);
								boolean punto1 = dentroPoligono(poligono1, new double[] { x3, y3 }, true);
								boolean punto2 = dentroPoligono(poligono1, new double[] { x4, y4 }, true);
								boolean punto3 = dentroPoligono(poligono2, new double[] { x1, y1 }, true);
								boolean punto4 = dentroPoligono(poligono2, new double[] { x2, y2 }, true);
								if (sol != null || punto1|| punto2|| punto3|| punto4) {
									union(i, j);
									break Ciclo;
								}
							}
						}
					}
				}
			}

			int count = 0;
			for (int i = 0; i < set.length; i++) {
				if (set[i] < 0) {
					count++;
				}
			}
			out.println(count);

		}

		out.close();
		in.close();
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		int sizex = -(set[x]);
		int sizey = -(set[y]);

		if (sizex < sizey) {
			set[y] = set[y] + set[x];
			set[x] = y;
		} else {
			set[x] = set[x] + set[y];
			set[y] = x;
		}

	}

	static int find(int x) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x]);
	}

	static boolean dentroPoligono(double[][] pt, double[] p, boolean bd) { // bd:
																			// con
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

	static double[] intSegmentos(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
			double y4) { // No
		// se
		// sobrelapan
		double[] p1 = { x1, y1 }, p2 = { x2, y2 }, p3 = { x3, y3 }, p4 = { x4, y4 }, p12[] = { p1, p2 },
				p34[] = { p3, p4 };
		for (double[] p : p12)
			if (distPS(p3, p4, p) < 1e-11)
				return p;
		for (double[] p : p34)
			if (distPS(p1, p2, p) < 1e-11)
				return p;
		double[] p = intLineas(x1, y1, x2, y2, x3, y3, x4, y4);
		return p != null && distPS(p1, p2, p) < 1e-11 && distPS(p3, p4, p) < 1e-11 ? p : null;
	}

	static double distPS(double[] p1, double[] p2, double[] p) {
		double dP = ds(p1, p2), d1 = ds(p1, p), d2 = ds(p2, p);
		return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPL(p1, p2, p);
	}

	static double[] intLineas(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		double xa = x2 - x1, xb = x4 - x3, xc = x1 - x3, ya = y2 - y1, yb = y4 - y3, yc = y1 - y3,
				d = yb * xa - xb * ya, n = xb * yc - yb * xc;
		return Math.abs(d) < 1e-11 ? null : new double[] { x1 + xa * n / d, y1 + ya * n / d };
	}

	static double distPL(double[] p1, double[] p2, double[] p) {
		return Math.abs((p2[0] - p1[0]) * (p1[1] - p[1]) - (p2[1] - p1[1]) * (p1[0] - p[0])) / Math.sqrt(ds(p1, p2));
	}

	static double ds(double[] a, double[] b) {
		return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
	}
}
