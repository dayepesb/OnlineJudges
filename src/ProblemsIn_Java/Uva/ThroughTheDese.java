package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class ThroughTheDese {
	static char event[];
	static int cost[], km[], n;

	public static void main(String[] args) throws Exception {
		Locale.setDefault(new Locale("en","US"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line, inp[];
		int size;
		double hi, low, mid;
		n = 0;

		event = new char[55];
		cost = new int[55];
		km = new int[55];

		while (true) {

			line = in.readLine();
			inp = line.split(" ");

			size = inp.length;
			if (size == 4 && inp[3].charAt(0) == '0') {
				break;
			}

			if (size == 2 && inp[1].charAt(0) == 'G') {
				km[n] = Integer.parseInt(inp[0]);
				event[n] = 'g';
				n++;
				hi = 10000;
				low = 0;
				while (hi - low > 1e-9) {
					mid = (hi + low) / 2;
					if (can(mid))
						hi = mid;
					else
						low = mid;
				}
				out.printf("%.3f%n", (hi + low) / 2);
				n = 0;
			} else {
				if (size <= 3) {
					km[n] = Integer.parseInt(inp[0]);
					event[n] = inp[1].charAt(0);
					n++;
				}
				if (size == 4) {
					km[n] = Integer.parseInt(inp[0]);
					event[n] = inp[1].charAt(0);
					cost[n] = Integer.parseInt(inp[3]);
					n++;
				}
			}

		}

		out.close();
		in.close();
	}

	static boolean can(double fuel) {
		double init = fuel;
		int cons = 0;
		int ckm = 0;
		int leek = 0;
		int i;
		for (i = 0; i < n; i++) {
			fuel = fuel - (km[i] - ckm) * leek - (km[i] - ckm) / 100.00 * cons;
			if (fuel < 0)
				return false;
			if (event[i] == 'F')
				cons = cost[i];
			else if (event[i] == 'L')
				leek++;
			else if (event[i] == 'M')
				leek = 0;
			else if (event[i] == 'G' && fuel >= 0)
				fuel = init;
			ckm = km[i];
		}
		return true;
	}

}
