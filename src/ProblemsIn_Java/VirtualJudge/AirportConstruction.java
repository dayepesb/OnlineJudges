package ProblemsIn_Java.VirtualJudge;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 07-01-2018
 * @time 0.000 ms
 */
public class AirportConstruction {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int n;
		ArrayList<Point2D> points;
		for (String line; (line = in.readLine()) != null;) {
			n = Integer.parseInt(line.trim());
			points = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points.add(new Point2D.Double(x, y));
			}
			points.add(points.get(0));
			double max = Double.MIN_VALUE;
			for (int i = 0; i < points.size() - 1; i++) {
				for (int j = i + 1; j < points.size() - 1; j++) {
					Point2D a = points.get(i);
					Point2D b = points.get(j);
					boolean good = true;
					LOOP: for (int k = 0; k < points.size() - 1; k++) {
						if (k == i + 1 || k == i - 1 || k == j - 1 || k == j + 1) {
							continue;
						}
						Point2D c = points.get(k);
						Point2D d = points.get(k + 1);
						if (isDiferent(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(),
								d.getY())) {
							if (intLineas(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(),
									d.getY()) == null) {
								// porque no importa
								continue;
							} else {
								if (intSegmentos(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY(), d.getX(),
										d.getY()) == null) {
									good = true;
								} else {
									// paila
									good = false;
									break LOOP;
								}
							}
						}
					}
					if (good) {
						max = Math.max(max, a.distance(b));
					}
				}
			}
			out.println(max);
		}

		in.close();
		out.close();
	}

	static boolean isDiferent(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		if ((x1 == x3 && y1 == y3) || (x1 == x4 && y1 == y4) || (x2 == x3 && y2 == y3) || (x2 == x4 && y2 == y4)) {
			return false;
		}
		return true;
	}

	static double[] intSegmentos(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
			double y4) {
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
