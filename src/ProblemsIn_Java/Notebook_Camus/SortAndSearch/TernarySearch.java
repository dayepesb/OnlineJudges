package ProblemsIn_Java.Notebook_Camus.SortAndSearch;

public static void busquedaTernearea(int tam) {
	double b = 0, a = 0, difa= 0, difb= 0, cortei= 0, cortef = 0, lon = 0;
	double[][] matriz = new double[tam][tam];
	// f es la funcion que se calcula
	while (b - a > 1e-10) {
		difa = f(a, matriz, lon); difb = f(b, matriz, lon);
		if (difa <= difb) {
			cortei = a; a = cortei + ((cortef - a) / 3);
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