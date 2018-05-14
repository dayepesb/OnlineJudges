package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarvelousMazes {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader tec = new BufferedReader(
				new InputStreamReader(System.in));
		String entrada = tec.readLine();
		StringBuilder out = new StringBuilder();
		int x = 0;
		while (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (entrada.charAt(i) >= '0' && entrada.charAt(i) <= '9') {
					x = x + Integer.parseInt("" + entrada.charAt(i));
				} else {
					if (entrada.charAt(i) == '!') {
						out.append("\n");
					} else
						for (int j = 0; j < x; j++) {
							if (entrada.charAt(i) == 'b') {
								out.append(" ");
							} else {
								out.append("" + entrada.charAt(i));
							}
						}
					x = 0;
				}

			}
			out.append("\n");
			entrada = tec.readLine();
		}
		System.out.print(out);
	}
}