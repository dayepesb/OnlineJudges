package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 19-09-2017
 * @time 0.050 ms
 */
public class Submarines {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line;
		StringTokenizer st;
		ArrayList<submarine> submarines;
		ArrayList<double[][]> islands;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line.trim());
			submarines = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				double x1 = Double.parseDouble(st.nextToken());
				double y1 = Double.parseDouble(st.nextToken());
				double x2 = Double.parseDouble(st.nextToken());
				double y2 = Double.parseDouble(st.nextToken());
				submarines.add(new submarine(x1, y1, x2, y2));
			}
			islands = new ArrayList<>();
			int is = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < is; i++) {
				double pt[][];
				int points = Integer.parseInt(in.readLine().trim());
				pt = new double[points][];
				for (int j = 0; j < points; j++) {
					st = new StringTokenizer(in.readLine());
					pt[j] = new double[] { Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()) };
				}
				islands.add(pt);
			}

			int s = 1;
			for (submarine submarine : submarines) {
				double x1, y1, x2, y2;
				x1 = submarine.startX;
				y1 = submarine.startY;
				x2 = submarine.endX;
				y2 = submarine.endY;

				boolean isIntersect = false;
				boolean nunca = true;

				double x3, y3, x4, y4;
				islands: for (double[][] pt : islands) {
					x3 = pt[pt.length - 1][0];
					y3 = pt[pt.length - 1][1];
					x4 = pt[0][0];
					y4 = pt[0][1];
					double p[] = intSegmentos(x1, y1, x2, y2, x3, y3, x4, y4);
					if (p != null && p[0] != x1 && p[0] != x2 && p[1] != y1 && p[1] != y2) {
						isIntersect = true;
						break islands;
					}
					for (int i = 0; i < (pt.length - 1); i++) {
						x3 = pt[i][0];
						y3 = pt[i][1];
						x4 = pt[i + 1][0];
						y4 = pt[i + 1][1];
						p = intSegmentos(x1, y1, x2, y2, x3, y3, x4, y4);
						if (p != null && !((p[0] == x1 && p[1] == y1) || (p[0] == x2 && p[1] == y2))) {
							isIntersect = true;
							nunca = false;
							break islands;
						}
					}
				}
				if (isIntersect)
					out.println("Submarine " + s + " is partially on land.");
				else {
					if (nunca) {
						boolean isInIsland = false;
						for (double[][] pt : islands) {
							boolean a = dentroPoligono(pt, new double[] { x1, y1 }, false);
							boolean b = dentroPoligono(pt, new double[] { x2, y2 }, false);
							if (a && b) {
								isInIsland = true;
								break;
							}
						}
						if (isInIsland)
							out.println("Submarine " + s + " is completely on land.");
						else
							out.println("Submarine " + s + " is still in water.");
					}
				}

				s++;
			}

		}

		in.close();
		out.close();
	}

	static double[] intLineas(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		double xa = x2 - x1, xb = x4 - x3, xc = x1 - x3, ya = y2 - y1, yb = y4 - y3, yc = y1 - y3,
				d = yb * xa - xb * ya, n = xb * yc - yb * xc;
		return Math.abs(d) < 1e-11 ? null : new double[] { x1 + xa * n / d, y1 + ya * n / d };
	}

	static double[] intSegmentos(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
			double y4) { // No se sobrelapan
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

	static class submarine {
		double startX, startY, endX, endY;

		public submarine(double startX, double startY, double endX, double endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}
	}
}
