package ProblemsIn_Java.Uva;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeFrecuency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// NUMERO DE CASOS, INGRESADO POR EL USUARIO

		int c = 1;

		String z[] = new String[T];

		for (int i = 0; i < z.length; i++) {// INGRESAR LOS STRINGS
			z[i] = sc.next();
			
		}

		// System.out.println(" ");

		for (int i = 0; i < z.length; i++) {// RESPUESTA
			System.out.print("Case " + c + ": ");
			a(z[i]);
			c++;
		}
	}

	public static void a(String s) {

		char arreglo[] = s.toCharArray();
		String c = "";
		String f = c;

		for (int i = 0; i < arreglo.length; i++) {
			int o = 1;
			for (int j = arreglo.length - 1; j > i; j--) {
				if (arreglo[i] == arreglo[j]) {
					o++;
					arreglo[j] = ' ';// CAMBIA EL VALOR DE arreglo[j] POR UN
										// ESPACIO, DESPUES DE COMPARARLO
				}

			}
			if (esPrimo(o) == true) {
				f = f + arreglo[i];
				arreglo[i] = ' ';// CAMBIA EL VALOR DE arreglo[i] POR UN
									// ESPACIO, DESPUES DE REVISAR TODO EL
									// STRING

			}

		}

		f = f.replace(" ", "");// QUITAR TODOS LOS ESPACIOS DE F

		if (f.equals(c) == true) {// SI F ESTA VACIO
			System.out.println("empty");
		}

		else { // SI F TIENE ALGO
			arreglo = f.toCharArray();// CONVERTIR F A UN ARREGLO DE CHAR
			Arrays.sort(arreglo);// ORDENAR EL ARREGLO LEXICOGRAFICAMENTE
			for (int i = 0; i < arreglo.length; i++) {
				System.out.print(arreglo[i]);
			}
			System.out.println();
		}

	}

	public static boolean esPrimo(int n) {// SABER SI EL NUMERO ES PRIMO O NO
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
