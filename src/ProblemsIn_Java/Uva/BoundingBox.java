package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 */
public class BoundingBox {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en"));

		StringTokenizer st;
		int n, caso = 1;
		for (String line; !(line = in.readLine().trim()).equals("0");) {

			n = Integer.parseInt(line);

			double minx = 1e30, maxx = -1e30;
			double miny = 1e30, maxy = -1e30;

			point p[] = new point[3];

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				p[i] = new point(x, y);
			}

			pair circle = circumcircle(p[0], p[1], p[2]);
			double theta = 2 * Math.PI / n;
			double offset = Math.atan2(circle.p.y - p[0].y, circle.p.x - p[0].x);

			for (int i = 0; i < n; i++) {
				double x = circle.p.x + circle.r * Math.cos(theta * i + offset);
				double y = circle.p.y + circle.r * Math.sin(theta * i + offset);
				minx = Math.min(minx, x);
				maxx = Math.max(maxx, x);
				miny = Math.min(miny, y);
				maxy = Math.max(maxy, y);
			}

			out.printf("Polygon %d: %.3f\n", caso, (maxx - minx) * (maxy - miny));

			caso++;
		}

		in.close();
		out.close();
	}

	static pair circumcircle(point a, point b, point c) {
		if (collinear(a, b, c))
			return new pair(new point(0, 0), -1);
		double A = 2 * (b.x - a.x);
		double B = 2 * (b.y - a.y);
		double C = sq(a.x) + sq(a.y) - sq(b.x) - sq(b.y);
		double D = 2 * (c.x - a.x);
		double E = 2 * (c.y - a.y);
		double F = sq(a.x) + sq(a.y) - sq(c.x) - sq(c.y);

		double x = (B * F - C * E) / (A * E - B * D);
		double y = (C * D - A * F) / (A * E - B * D);

		return new pair(new point(x, y), Math.sqrt(sq(a.x - x) + sq(a.y - y)));
	}

	static boolean collinear(point a, point b, point c) {
		return (a.x - b.x) * (a.y - c.y) == (a.x - c.x) * (a.y - b.y);
	}

	static double sq(double b) {
		return b * b;
	}

	static class point {
		double x, y;

		public point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class pair {
		point p;
		double r;

		public pair(point p, double r) {
			this.p = p;
			this.r = r;
		}
	}

}
