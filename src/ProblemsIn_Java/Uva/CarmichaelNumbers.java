package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CarmichaelNumbers {
	
	public static boolean  b[];
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		primos();

		Ciclo: while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if (n == 0) {
				break Ciclo;
			}else if (!b[n]) {
				//Guardar esto en el notebook
				//este es bigmod
				String o = Integer.toBinaryString(n);
				boolean charmichael = true;
				Loop: for (int i = 2; i <= n/2; i++) {
					long modulo = 1;
					long potencia = i;
					for (int j = o.length() - 1; j > -1; j--) {
						if (o.charAt(j) == '1') {
							modulo = (modulo * potencia) % n;
						}
						potencia = (potencia * potencia) % n;
					}
					if (modulo != i) {
						charmichael = false;
						break Loop;
					}
				}
				if (charmichael) {
					out.printf("The number %d is a Carmichael number.%n", n);
				} else {
					out.printf("%d is normal.%n", n);
				}
			} else {
				out.printf("%d is normal.%n", n);
			}
		}

		out.close();
		in.close();
	}

	public static void primos() {
		int max = 65563;
		b = new boolean[max];
		b[2] = true;
		for (int i = 3; i < max; i += 2) {
			b[i] = true;
		}
		int I = (int) Math.sqrt(max) + 1;
		for (int i = 3; i <= I; i += 2) {
			if (b[i] == true) {
				for (int j = i * i, bi = 2 * i; j < max; j += bi) {
					b[j] = false;
				}
			}
		}
	}

}
