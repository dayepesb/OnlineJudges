package ProblemsIn_Java.Competencias.Nacional_2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fish {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		double pt1[][];
		double pt2[][];
		String line;
		StringTokenizer st;
		while (!(line = in.readLine().trim()).equals("0 0")) {
			st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int index1 = 0;
			int index2 = 0;
			pt1 = new double[n][2];
			pt2 = new double[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				if (st.nextToken().equals("A")) {
					pt1[index1][0] = x;
					pt1[index1][1] = y;
					index1++;
				} else {
					pt2[index2][0] = x;
					pt2[index2][1] = y;
					index2++;
				}
			}
			double res[][] = SumasDeMunkoskyMejorado(Arrays.copyOfRange(pt1, 0, index1),
					Arrays.copyOfRange(pt2, 0, index2));
			
		}

		out.close();
		in.close();
	}

	static double[][] SumasDeMunkoskyMejorado(double pt1[][], double pt2[][]) {
		int n = pt1.length, m = pt2.length;
		double pt[][] = new double[n + m][2];
		int index = 0, i = 0, j = 0;
		do {
			pt[index][0] = pt1[i][0] + pt2[j][0];
			pt[index][1] = pt1[i][1] + pt2[j][1];
			System.out.println(Arrays.toString(pt[index]));
			index++;
			double anguloV = angule(pt1[i], pt1[(i + 1) >= n ? 0 : i + 1]);
			double anguloW = angule(pt2[j], pt2[(j + 1) >= m ? 0 : j + 1]);
			if (anguloV < anguloW)
				i++;
			else if (anguloV > anguloW)
				j++;
			else {
				i++;
				j++;
			}
			if (i > n)
				i = n;
			if (j > n)
				j = m;
		} while (i < n && j < m);
		return Arrays.copyOfRange(pt, 0, index);
	}

	static double angule(double pt1[], double pt2[]) {
		double y = ((pt1[1] - pt2[1]));
		double x = ((pt1[0] - pt2[0]));
		return Math.atan2(y, x);
	}
}
