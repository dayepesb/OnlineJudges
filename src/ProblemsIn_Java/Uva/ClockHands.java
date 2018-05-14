package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ClockHands {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int horas, minutos;
		double sol;

		while (true) {
			st = new StringTokenizer(in.readLine(), ":");
			horas = Integer.parseInt(st.nextToken());
			minutos = Integer.parseInt(st.nextToken());
			if (horas == minutos && horas == 0)
				break;
			sol = Math.abs(0.5 * (60 * horas - 11 * minutos));
			sol = sol > 180 ? 360 - sol : sol;
			out.printf("%.3f%n", sol);
		}

		out.close();
		in.close();
	}

}
