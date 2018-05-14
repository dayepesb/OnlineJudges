package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACISAContagiousvIruS {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int points,xr,yr;
		double arr [][];
		StringTokenizer st ;
		
		for (String line; !(line = in.readLine()).equals("*");) {
			points = Integer.parseInt(line);
			arr = new double [points][2];
			st = new StringTokenizer(in.readLine());
			xr = Integer.parseInt(st.nextToken());
			yr = Integer.parseInt(st.nextToken());
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(in.readLine());
				arr[i][0]=Double.parseDouble(st.nextToken())-xr;
				arr[i][1]=Double.parseDouble(st.nextToken())-yr;
			}
			double min = Double.POSITIVE_INFINITY;
			for (int i = 1; i < arr.length; i++) {
				min = Math.min(min, distPuntoSegmento(arr[i-1], arr[i], new double [] {0,0}));
			}
			
			min = Math.min(min, distPuntoSegmento(arr[arr.length-1], arr[0], new double [] {0,0}));
			out.println(String.format("%.3f", min).replace(",", "."));
			
		}

		out.close();
		in.close();
	}

	static double distPuntoSegmento(double[] p1, double[] p2, double[] p) {
		double dP = distanciaCuadrado(p1, p2), d1 = distanciaCuadrado(p1, p), d2 = distanciaCuadrado(p2, p);
		return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPuntoLinea(p1, p2, p);
	}

	static double distPuntoLinea(double[] p1, double[] p2, double[] p) {
		return Math.abs((p2[0] - p1[0]) * (p1[1] - p[1]) - (p2[1] - p1[1]) * (p1[0] - p[0]))
				/ Math.sqrt(distanciaCuadrado(p1, p2));
	}

	static double distanciaCuadrado(double[] a, double[] b) {
		return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
	}
}
