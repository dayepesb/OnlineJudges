package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrimeCuts {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String line;
		int n, c, l, ini, tam;
		StringTokenizer st;
		ArrayList<Integer> prime = new ArrayList<Integer>();

		for (; !((line = in.readLine()) == null);) {

			prime.clear();
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= n; i++) {
				if (isPrime(i)) {
					prime.add(i);
				}
			}
			tam = prime.size();
			ini = 0;
			l = 0;
			if (tam % 2 == 0) {
				l = 2 * c;
				ini = (tam - l) / 2;
			} else {
				l = 2 * c - 1;
				ini = (tam - l) / 2;
			}
			if (l > tam) {
				ini = 0;
				l = tam;
			}

			out.print(n + " " + c + ":");
			for (int i = ini; i < ini + l; i++) {
				out.print(" " + prime.get(i));
			}
			out.println("\n");
		}

		in.close();
		out.close();
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}