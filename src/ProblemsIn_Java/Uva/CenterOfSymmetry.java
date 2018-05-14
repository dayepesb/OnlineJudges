package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CenterOfSymmetry {

	static final double INF = 1e7, EPS = 1e-9;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new  InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tc = Integer.parseInt(in.readLine().trim());
		StringTokenizer st;
		while (tc-- > 0) {
			int n = Integer.parseInt(in.readLine().trim());
			double maxX, maxY, minX, minY;
			maxX = maxY = -(minX = minY = INF);
			Point[] points = new Point[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				maxX = Math.max(maxX, x);
				minX = Math.min(minX, x);
				maxY = Math.max(maxY, y);
				minY = Math.min(minY, y);
				points[i] = new Point(x, y);
			}
			Point c = new Point((maxX + minX) / 2.0, (maxY + minY) / 2.0);
			Arrays.sort(points);
			boolean has = true;
			for (int i = 0; has && i < n; i++) {
				Vector v = new Vector(points[i], c);
				if (!contains(points, points[i].translate(v).translate(v)))
					has = false;
			}
			out.print(has ? "yes\n" : "no\n");
		}
		out.flush();

	}

	static boolean contains(Point[] points, Point x) {
		int lo = 0, hi = points.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int c = points[mid].compareTo(x);
			if (c == 0)
				return true;
			if (c == 1)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return false;
	}

	static class Point implements Comparable<Point> {
		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		public int compareTo(Point o) {

			if (Math.abs(x - o.x) > EPS)
				return x > o.x ? 1 : -1;
			if (Math.abs(y - o.y) > EPS)
				return y > o.y ? 1 : -1;
			return 0;
		}

		Point translate(Vector v) {
			return new Point(x + v.x, y + v.y);
		}

	}

	static class Vector {
		double x, y;

		Vector(Point p, Point q) {
			x = q.x - p.x;
			y = q.y - p.y;
		}
	}
}