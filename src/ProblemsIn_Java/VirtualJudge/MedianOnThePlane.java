package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 1-08-2017
 * @time 0.655 ms
 */
public class MedianOnThePlane {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int points;
		for (String line; (line = in.readLine()) != null;) {
			points = Integer.parseInt(line.trim());

			double[][] p = new double[points][2];
			for (int i = 0; i < points; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				p[i][0] = Integer.parseInt(st.nextToken());
				p[i][1] = Integer.parseInt(st.nextToken());
			}

			int sumIzq = 0;
			int sumDer = 0;
			Loop: for (int i = 0; i < points; i++) {
				for (int j = i + 1; j < points; j++) {
					if ((p[i][0] != p[j][0]) || (p[i][0] != p[j][0])) {
						for (int k = 0; k < points; k++) {
							if (k != i && k != j) {

								if (ccw(p[i], p[j], p[k])) {
									sumIzq++;
								} else {
									sumDer++;
								}
							}
						}
					}
					if (sumIzq == sumDer && sumIzq + sumDer == (points - 2)) {
						out.println((i + 1) + " " + (j + 1));
						break Loop;
					}
					sumIzq = 0;
					sumDer = 0;
				}
			}

		}

		out.close();
		in.close();
	}

	static double cross(double[] p, double[] q, double[] r) {
		return (r[0] - q[0]) * (p[1] - q[1]) - (r[1] - q[1]) * (p[0] - q[0]);
	}

	static boolean ccw(double[] p, double[] q, double[] r) {
		return cross(p, q, r) > 0;
	}

}
