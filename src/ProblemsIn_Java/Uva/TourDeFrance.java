package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TourDeFrance {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int tamFrontal, tamTrasera, total, frontal[], trasera[];
		double res[];
		StringTokenizer st = new StringTokenizer(in.readLine());
		while (true) {
			tamFrontal = Integer.parseInt(st.nextToken());

			if (tamFrontal == 0)
				break;

			tamTrasera = Integer.parseInt(st.nextToken());
			total = tamTrasera * tamFrontal;
			frontal = new int[tamFrontal];
			trasera = new int[tamTrasera];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < frontal.length; i++) {
				frontal[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < trasera.length; i++) {
				trasera[i] = Integer.parseInt(st.nextToken());
			}

			res = new double[total];
			int index = 0;
			for (int i = 0; i < frontal.length; i++) {
				for (int j = 0; j < trasera.length; j++) {
					res[index++] = (frontal[i] * 1.00 / trasera[j]);
				}
			}

			Arrays.sort(res);
			double max = -1;
			for (int i = 1; i < res.length; i++) {
				max = Math.max(max, res[i] / res[i - 1]);
			}

			out.printf("%.2f%n", max);

			st = new StringTokenizer(in.readLine());
		}

		out.close();
		in.close();
	}
}
