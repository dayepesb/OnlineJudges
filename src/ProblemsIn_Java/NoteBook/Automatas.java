package ProblemsIn_Java.NoteBook;

public class Automatas {

	public static String patron;

	public static void main(String[] args) {
		patron = "ababaca";
		automata("cabacabababacabababaca");
	}

	public static void automata(String cadena) {
		int va = 0;
		for (int i = 0; i < cadena.length(); i++) {
			System.out.println(va);
			va = transicion(va, cadena.charAt(i));
		}
	}

	public static int transicion(int q, char a) {
		String x = patron;
		int iteraciones = 0;
		if (q == 0) {
			if (a == patron.charAt(1))
				return q + 1;
		}
		if (q == patron.length() || patron.charAt(q) != a) {
			return transicion(borde(patron.toCharArray())[q], a);
		} else {
			if (q == patron.length() - 1)
				iteraciones++;
			return q + 1;
		}
	}

	public static int[] borde(char[] cadena) {
		int[] T = new int[cadena.length + 1];
		T[0] = -1;
		T[1] = 0;
		for (int i = 2, j = 0; i <= cadena.length;) {
			if (cadena[i - 1] == cadena[j])
				T[i++] = ++j;
			else if (j > 0)
				j = T[j];
			else
				T[i++] = 0;
		}
		return T;
	}
}
