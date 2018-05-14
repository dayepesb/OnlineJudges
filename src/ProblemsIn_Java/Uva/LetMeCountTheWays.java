package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LetMeCountTheWays {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		long nWay[] = new long[40000]; // SIZE
		int coin[] = { 50, 25, 10, 5, 1 }; // ORDER
		int types = 5;
		int i, j, taken, change;

		nWay[0] = 1;
		for (i = 0; i < types; i++) {
			taken = coin[i];
			for (j = taken; j <= 30000; j++) {
				nWay[j] += nWay[j - taken];
			}
		}

		for (String line; (line = in.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			if (nWay[n] == 1)
				out.printf("There is only %d way to produce %d cents change.\n", nWay[n], n);
			else
				out.printf("There are %d ways to produce %d cents change.\n", nWay[n], n);
		}
		out.close();
		in.close();
	}
}
