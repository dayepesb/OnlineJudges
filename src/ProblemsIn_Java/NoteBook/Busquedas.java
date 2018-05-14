package ProblemsIn_Java.NoteBook;

import java.util.Arrays;

public class Busquedas {
	public static boolean BusquedaBinaria(int[] a, int s, int e, int b) {
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			if (a[0] == b) {
				return true;
			} else if (a.length == 0) {
				return false;
			} else if (a[a.length / 2] == b) {
				return true;
			} else if (b > a[a.length / 2]) {
				BusquedaBinaria(a, (a.length / 2) + 1, (a.length) - 1, b);
			} else if (b < a.length / 2) {
				BusquedaBinaria(a, 0, (a.length / 2) - 1, b);
			}
		}
		return false;
	}

	public static boolean BusquedaBinariaSinRecursion(int[] a, int s, int e, int b) {
		while (s <= e) {
			int middle = a[(s + e) / 2];
			if (middle == b) {
				return true;
			} else if (middle < b) {
				s = ((s + e) / 2) - 1;
			} else {
				e = ((s + e) / 2) - 1;
			}
		}
		return false;
	}

	public static int[] BusquedaBinariaNumPosicion(int[] a, int s, int e, int b) {
		int i = 0;
		int[] Arreglo = new int[1];
		while (s <= e) {
			int middle = a[(s + e) / 2];
			if (middle == b) {
				Arreglo[0] = middle;
			} else if (middle < b) {
				s = ((s + e) / 2) - 1;
			} else {
				e = ((s + e) / 2) - 1;
			}
		}

		return Arreglo;
	}

	public static void busquedaTernearea(int tam) {
		double b = 0, a = 0, difa= 0, difb= 0, cortei= 0, cortef = 0, lon = 0;
		double[][] matriz = new double[tam][tam];
		// f es la funcion que se calcula
		while (b - a > 1e-10) {
			difa = f(a, matriz, lon);
			difb = f(b, matriz, lon);
			if (difa <= difb) {
				cortei = a;
				a = cortei + ((cortef - a) / 3);
				b = cortei + ((cortef - cortei) * 2 / 3);
			} else {
				cortef = b;
				b = cortei + (((cortef - cortei) * 2) / 3);
				a = cortei + ((cortef - cortei) / 3);
			}
		}
	}
	public static double f(double a, double matriz [][], double lon) {
		return 0;
	}
}
