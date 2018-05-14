package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 04-02-2018
 * @time 0.000 ms
 */
public class FenceTheVegetablesFail {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int p, v;
		double pt[][], vt[][];
		for (String line; (line = in.readLine())!=null;) {
			st = new StringTokenizer(line);
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			vt = new double[p][2];
			pt = new double[v][2];
			for (int i = 0; i < p; i++) {
				st = new StringTokenizer(in.readLine());
				vt[i][0] = Double.parseDouble(st.nextToken());
				vt[i][1] = Double.parseDouble(st.nextToken());
			}
			for (int i = 0; i < v; i++) {
				st = new StringTokenizer(in.readLine());
				pt[i][0] = Double.parseDouble(st.nextToken());
				pt[i][1] = Double.parseDouble(st.nextToken());
			}
			int value = 1;
			int sum = 0;
			for (double[] point : vt) {
				if (!dentroPoligono(pt, point, true))
					sum += value;
				value++;
			}
			out.println(sum);
		}
		in.close();
		out.close();
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
}
