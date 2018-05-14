package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LessPrime {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader dy = new BufferedReader(new InputStreamReader(System.in));
		String it = dy.readLine();
		long n = Long.parseLong(it);
		for (int i = 0; i < n; i++) {
			String numero = dy.readLine();
			long num = Long.parseLong(numero);
			boolean encontrado = false;
			num = (num / 2) + 1;
			while (!encontrado) {
				if (esPrimo(num)) {
					encontrado = true;
				} else {
					num++;
				}
			}
			System.out.println(num);
		}
	}

	public static boolean esPrimo(long n) {
		if (n == 0 || n == 1) {
			return false;

		}

		int multiplos = 0;
		for (int i = 1; i < n + 1; i++) {
			if (n % i == 0) {
				multiplos++;
			}
		}

		if (multiplos != 2) {
			return false;
		}

		else {
			return true;
		}
	}
}
