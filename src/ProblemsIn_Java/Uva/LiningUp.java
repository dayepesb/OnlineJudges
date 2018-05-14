package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 23-08-2017
 * @time 1.310 ms
 */
public class LiningUp {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine().trim());
		in.readLine();
		for (int c = 0; c < casos; c++) {
			if (c > 0)
				out.println();
			ArrayList<Point2D> points = new ArrayList<>();
			String line = in.readLine();
			double max = -1;
			while (line != null && !line.equals("")) {
				st = new StringTokenizer(line);
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				max = Math.max(max, Math.max(x, y));
				points.add(new Point2D.Double(x, y));
				line = in.readLine();
			}
			int n = points.size();
			double dp[][] = new double[n][n];
			for (int i = 0; i < points.size(); i++) {
				for (int j = 0; j < points.size(); j++) {
					double slope = (points.get(j).getY() - points.get(i).getY())
							/ (points.get(j).getX() - points.get(i).getX());
					dp[i][j] = Double.isInfinite(slope) ? Double.MAX_VALUE : slope;
				}
			}
			int maxPoints = 0;
			for (double[] ds : dp) {
				HashMap<Double, Integer> map = new HashMap<>();
				for (double d : ds) {
					if (!map.containsKey(d))
						map.put(d, 1);
					else {
						int s = map.get(d);
						map.put(d, (s + 1));
					}
				}
				double maxSlope = 0.;
				int repeat = 0;
				for (Entry<Double, Integer> s : map.entrySet()) {
					if (repeat < s.getValue() && !Double.isNaN(s.getKey())) {
						repeat = s.getValue();
						maxSlope = s.getKey();
					}
				}
				int numPoints = 0;
				for (double d : ds) {
					if (Double.isNaN(d) || d == maxSlope)
						numPoints++;
				}
				maxPoints = Math.max(numPoints, maxPoints);
			}

			out.println(maxPoints);

		}

		in.close();
		out.close();
	}
}
