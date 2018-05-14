package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BigNumber {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine()), number;
		for (int caso = 0; caso < casos; caso++) {
			number = Integer.parseInt(in.readLine());
			double sum = 0;
			for (int i = number; i > 1; i--) {
				sum += Math.log10((double) i);
			}
			out.println((int) Math.floor(sum) + 1);
		}

		out.close();
		in.close();
	}
}
