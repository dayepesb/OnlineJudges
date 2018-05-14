package ProblemsIn_Java.Uva;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class tresnmasuno {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Ciclo: while (true) {
			if (in.hasNextLong()) {
				long i = in.nextLong();
				long j = in.nextLong();
				long n;
				long maximo = 0;
				for (n = Math.min(i, j); n <= Math.max(i, j); n++) {
					long s = solucion(n);
					if (maximo > s) {
						maximo = maximo;
					} else {
						maximo = s;
					}
				}
				out.write(i + " " + j + " " + maximo + "\n");
			} else {
				break Ciclo;
			}
		}
		out.close();
		in.close();
	}

	public static long solucion(long n) {

		int cont = 1;
		while (n != 1) {
			if (n == 1) {
				return cont;
			}
			if (n % 2 != 0) {
				return solucion(3 * n + 1) + cont;
			} else {
				return solucion(n / 2) + cont;
			}
		}
		return cont;

	}
}
