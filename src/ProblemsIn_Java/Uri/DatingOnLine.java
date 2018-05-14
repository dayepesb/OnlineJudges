package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class DatingOnLine {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(new Locale("eng", "US"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int point = Integer.parseInt(in.readLine().trim());
		double grados = 2 * Math.PI / point;
		StringTokenizer st = new StringTokenizer(in.readLine());
		int arr[] = new int[point];
		for (int i = 0; i < arr.length; arr[i] = Integer.parseInt(st.nextToken()), i++);
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		boolean s = false;

		for (int i = 0; i < arr.length; i++) {
			if (s) {
				list.add(arr[i]);
				s = false;
			} else {
				list.add(0, arr[i]);
				s = true;
			}
		}
		double[][] points = new double[point][2];
		double aux = grados;
		for (int i = 0; i < points.length; i++) {
			double x = list.get(i) * Math.cos(aux);
			double y = list.get(i) * Math.sin(aux);
			points[i][0] = x;
			points[i][1] = y;
			aux += grados;
		}
		out.printf("%.3f%n",area(points));
		out.close();
		in.close();
	}

	static double area(double[][] pt) {
		double r = 0d;
		int t = pt.length;
		for (int i = 0, j = 1; i < t; i++, j = j + 1 == t ? 0 : j + 1)
			r += pt[i][0] * pt[j][1] - pt[i][1] * pt[j][0];
		return Math.abs(r) / 2;
	}

}
