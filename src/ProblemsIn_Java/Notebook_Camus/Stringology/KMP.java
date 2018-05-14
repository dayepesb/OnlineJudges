package ProblemsIn_Java.Notebook_Camus.Stringology;int KMP(char[] palabraConsult, char[] cadena) {
	int T[] = getBorderkMP(cadena);
	if (palabraConsult.length == 0) return 0;
	for (int m = 0, i = 0; m + i < cadena.length;) {
		if (palabraConsult[i] == cadena[m + i]) {
			if (++i == palabraConsult.length)
				return m;
		} else {
			m += i - T[i];
			if (i > 0) i = T[i];
		}
	}
	return -1;
}
