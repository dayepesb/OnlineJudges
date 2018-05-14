package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 14-09-2017
 * @time 0.250 ms
 */
public class CopsAndRobbers {
	static HashSet<String> copsSet, robertsSet;
	static ArrayList<double[]> copList, robetsList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int c, r, o;
		int caso = 1;
		double[][] cops, robbers;
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			o = Integer.parseInt(st.nextToken());
			int copsReals = c;
			int robbersReals = r;
			if (c == 0 & r == 0 && o == 0)
				break;
			out.printf("Data set %d:%n", caso++);

			copList = new ArrayList<>();
			copsSet = new HashSet<>();

			for (int i = 0; i < c; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				if (!copsSet.contains(x + "," + y)) {
					copList.add(new double[] { x, y });
					copsSet.add(x + "," + y);
				}
			}

			robetsList = new ArrayList<>();
			robertsSet = new HashSet<>();

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				if (!robertsSet.contains(x + "," + y)) {
					robetsList.add(new double[] { x, y });
					robertsSet.add(x + "," + y);
				}
			}

			cops = new double[copList.size()][];
			int i = 0;
			for (double[] ds : copList) {
				cops[i] = ds;
				i++;
			}
			robbers = new double[robetsList.size()][];
			i = 0;
			for (double[] ds : robetsList) {
				robbers[i] = ds;
				i++;
			}
			c = copList.size();
			r = robetsList.size();

			// System.out.println(c+" "+r);
			cops = c < 4 ? cops : convexHullGS(cops, true);
			robbers = r < 4 ? robbers : convexHullGS(robbers, true);

			for (i = 0; i < o; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());

				boolean intoCops = false;
				boolean intoRobberts = false;

				if (c < 3) {
					if (copsReals < 3)
						intoCops = false;
					else {
						for (double[] ds : cops) {
							if (ds[0] == x && ds[1] == y) {
								intoCops = true;
								break;
							}
						}
					}
				} else {
					intoCops = dentroPoligono(cops, new double[] { x, y }, true);
				}

				if (r < 3) {
					if (robbersReals < 3)
						intoRobberts = false;
					else {
						for (double[] ds : robbers) {
							if (ds[0] == x && ds[1] == y) {
								intoRobberts = true;
								break;
							}
						}
					}
				} else {
					intoRobberts = dentroPoligono(robbers, new double[] { x, y }, true);
				}

				if (intoCops)
					out.printf("     Citizen at (%.0f,%.0f) is safe.%n", x, y);
				else if (intoRobberts)
					out.printf("     Citizen at (%.0f,%.0f) is robbed.%n", x, y);
				else
					out.printf("     Citizen at (%.0f,%.0f) is neither.%n", x, y);

			}
			out.println();
			in.readLine();
		}

		in.close();
		out.close();
	}

	static boolean dentroPoligono(double[][] pt, double[] p, boolean bd) {
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
