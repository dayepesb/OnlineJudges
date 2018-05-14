package ProblemsIn_Java.Uva;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Perfection {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		out.write("PERFECTION OUTPUT"+"\n");
		while (true) {
			int n = in.nextInt();
			if (n == 0) {
				out.write("END OF OUTPUT"+"\n");
				break;
			} else {
				int sum = -n;
				for (int i = 1, I = (int) Math.sqrt(n); i <= I; i++) {
					if (n % i == 0) {
						sum += i;
						if (i != n / i) {
							sum += n / i;
						}
					}
				}
				
				String l = "PERFECT";
				if (sum > n) {
					l = "ABUNDANT";
				} else if (sum < n) {
					l = "DEFICIENT";
				}
				out.write(String.format("%5d  %s%n", n, l));
			}
		}
		in.close();
		out.close();
	}
}

