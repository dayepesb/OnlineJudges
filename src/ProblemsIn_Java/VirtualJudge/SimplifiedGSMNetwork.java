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
 * @date 28-01-2018
 * @time 0.000 ms
 */
public class SimplifiedGSMNetwork {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		ArrayList<Point2D> towers, cities;
		ArrayList<edge> graph[];
		int B, C, R;

		for (String line; !(line = in.readLine().trim()).equals("0 0 0");) {
			st = new StringTokenizer(line);
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			towers = new ArrayList<>();
			for (int i = 0; i < B; i++) {
				st = new StringTokenizer(in.readLine());
				towers.add(new Point2D.Double(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			cities = new ArrayList<>();
			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(in.readLine());
				cities.add(new Point2D.Double(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			graph = new ArrayList[C];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			int[][] roads = new int[2][R];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(in.readLine());
				roads[0][i] = Integer.parseInt(st.nextToken());
				roads[1][i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(roads[0]));
			System.out.println(Arrays.toString(roads[1]));
			System.out.println(cities);
			System.out.println(towers);
			System.out.println();
			double p = cities.get(0).getX();
			double q = cities.get(0).getY();
			double r = cities.get(1).getX();
			double s = cities.get(1).getY();
			double a = towers.get(0).getX();
			double b = towers.get(0).getY();
			for (int i = 1; i < B; i++) {
				double c = towers.get(i).getX();
				double d = towers.get(i).getY();
				System.out.println(p + " " + q + " " + r + " " + s + " " + a + " " + b + " " + c + " " + d + " ");
				System.out.println(func(p, q, r, s, a, b, c, d));
			}
		}

		in.close();
		out.close();
	}

	static double func(double p, double q, double r, double s, double a, double b, double c, double d) {
		// 111111111111
		// double num = -2*s*d+2*s*b-b*b-2*r*c-a*a+2*r*a+c*c+d*d;
		// double den = 2*(p*c-p*a+s*b-s*d-b*q-r*c+r*a+q*d);
		// 22222222222222
		// double num = -2*s*d+2*s*b-b*b-2*r*c-a*a+2*r*a+c*c+a*a;
		// double den = 2*(p*c-p*a+s*b-s*d-b*q-r*c+r*a+q*d);
		// 33333333333
		// double num = -2*s*b+2*s*d-2*r*a-c*c-d*d+b*b+2*r*c+a*a;
		// double den = 2*(-p*c+p*a-s*b+s*d+b*q+r*c-r*a-q*d);
//		 44444
		 double num = -2*s*b+2*s*d-2*r*a-c*c-d*d+b*b+2*r*c+a*a;
		 double den = 2*(-p*c+p*a-s*b+s*d+b*q+r*c-r*a-q*d);
		double solve = num / den;
		return solve;
	}

	static class edge implements Comparable<edge> {
		int source, target, weith;

		public edge(int souce, int target) {
			this.source = source;
			this.target = target;
			this.weith = 0;
		}

		@Override
		public int compareTo(edge e) {
			return Integer.compare(this.weith, e.weith);
		}
	}
}
