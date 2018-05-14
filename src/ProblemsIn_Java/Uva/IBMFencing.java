package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 20-09-2017
 * @time 3.040 ms
 */
public class IBMFencing {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en"));

		int n;
		int caso = 1;
		StringTokenizer st;
		ArrayList<Cerca> cercas;
		double[] distances;

		while ((n = Integer.parseInt(in.readLine().trim())) != 0) {
			cercas = new ArrayList<>();
			ArrayList<Double> c = new ArrayList<>();
			int index = 0;
			HashMap<Integer, Integer> tam = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				int m = Integer.parseInt(st.nextToken());
				double pt[][] = new double[m][];
				for (int j = 0; j < m; j++) {
					double x = Double.parseDouble(st.nextToken());
					double y = Double.parseDouble(st.nextToken());
					pt[j] = new double[] { x, y };
				}
				cercas.add(new Cerca(pt, index));
				c.add(cercas.get(i).distance);
				tam.put(index, m);
				index++;
			}
			distances = new double[c.size()];
			index = 0;
			for (double d : c) {
				distances[index++] = d;
			}
			Collections.sort(cercas);
			int[] content = new int[n];
			Arrays.fill(content, -1);
			for (int i = 0; i < content.length; i++) {
				for (int j = i + 1; j < content.length; j++) {
					if (dentroPoligono(cercas.get(j).pt, cercas.get(i).pt[0], false)) {
						content[cercas.get(i).index] = cercas.get(j).index;
						break;
					}
				}
			}
			boolean[] corespond = new boolean[content.length];
			for (int i = 0; i < corespond.length; i++) {
				if (content[i] == -1) {
					// es de metal
					corespond[i] = true;
					dfs(i, corespond, content);
				}
			}
			int comunities = 0;
			double costoMetal = 0., costoMadera = 0.;
			for (int i = 0; i < corespond.length; i++) {
				if (content[i] == -1) {
					if (tam.get(i) > 2)
						comunities++;
					costoMetal += distances[i];
				} else if (corespond[i]) {
					costoMetal += distances[i];
				} else {
					costoMadera += distances[i];
				}
			}
			costoMetal *= 100;
			costoMadera *= 50;
			costoMetal /= 1000000;
			costoMadera /= 1000000;
			out.printf("Case %d:%n", caso);
			out.printf("Total Number of Communities %d%n", comunities);
			out.println("Total Cost:");
			out.printf("Steel Fence: %.8f Million Yuan%n", costoMetal);
			out.printf("Wooden Fence: %.8f Million Yuan%n%n", costoMadera);

			caso++;
		}

		in.close();
		out.close();
	}

	static void dfs(int u, boolean[] correspond, int[] content) {
		for (int i = 0; i < correspond.length; i++) {
			if (content[i] == u) {
				correspond[i] = !correspond[u];
				dfs(i, correspond, content);
			}
		}
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

	static class Cerca implements Comparable<Cerca> {
		double[][] pt;
		double distance;
		int index;

		public Cerca(double pt[][], int index) {
			this.pt = pt;
			this.index = index;
			this.distance = distancePolygon(pt);
		}

		@Override
		public int compareTo(Cerca o) {
			return Double.compare(this.distance, o.distance);
		}

		@Override
		public String toString() {
			return index + "--" + distance + "";
		}
	}

	static double distancePolygon(double[][] pt) {
		double distance = 0.;
		if (pt.length > 2)
			for (int i = 1; i < pt.length; i++) {
				distance += (distancePoints(pt[i][0], pt[i][1], pt[i - 1][0], pt[i - 1][1]));
			}
		distance += (distancePoints(pt[pt.length - 1][0], pt[pt.length - 1][1], pt[0][0], pt[0][1]));
		return distance;
	}

	static double distancePoints(double x1, double y1, double x2, double y2) {
		return Math.sqrt(((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2))));
	}
}
