package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 17-10-2017
 * @time 0.000 ms
 */
public class RegularConvexPolygon {

	static final double PI = 3.141592653589793238, EPS = 1e-6;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine());
			if (st.countTokens() == 1)
				break;
			point p1 = new point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
			st = new StringTokenizer(in.readLine());
			point p2 = new point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
			st = new StringTokenizer(in.readLine());
			point p3 = new point(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));

			

		}

		in.close();
		out.close();
	}

	static class point {
		double x, y;

		public point(double x,double y) {
			this.x = x;
			this.y = y;
		}
	}

}
