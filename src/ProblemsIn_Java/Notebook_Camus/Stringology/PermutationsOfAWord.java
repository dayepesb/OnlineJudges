package ProblemsIn_Java.Notebook_Camus.Stringology;int count = 0;
HashSet<String> dictionary;
public void combinaciones(String primero, String cadena) {
	if (cadena.length() == 2) { count = count + 2;
		dictionary.add(primero + cadena.charAt(1) + "" + cadena.charAt(0));
		dictionary.add(primero + cadena.charAt(0) + "" + cadena.charAt(1));
	} else {
		for (int i = 0; i < cadena.length(); i++) {
			combinaciones(primero + cadena.charAt(i), quitarLetra(cadena, i));
		}
	}
}
public String quitarLetra(String cadena, int i) {
	if (i == 0) { return cadena.substring(i + 1, cadena.length());
	} else {
		if (i == cadena.length()) {
			return cadena.substring(0, cadena.length() - 1);
		} else {
			return cadena.substring(0, i) + cadena.substring(i + 1, cadena.length());
		}
	}
}
